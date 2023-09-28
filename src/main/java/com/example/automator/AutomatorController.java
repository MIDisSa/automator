package com.example.automator;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.automator.helper.ABMRunner;
import com.example.automator.helper.CSVReader;
import com.example.automator.helper.ModelInput;
import com.example.automator.helper.ModelResults;
import com.example.automator.helper.OptimizationResults;
import com.example.automator.helper.Parameters;
import com.example.automator.helper.CLIRunner;

@RestController
public class AutomatorController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/results")
    public Object modelResults(@RequestBody ModelInput modelInput) {
    @PostMapping("/results")
    public Object modelResults(@RequestBody ModelInput modelInput) {
         try {
            //get csv from folder and parse it as Parameters object
            Parameters parameters = new CSVReader().parseDataCSV();

            //run netlogo model and receive results
            ArrayList<String> results = ABMRunner.runABM(parameters, modelInput);

            // create ModelResults from results
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setAwareFarmersPerTick(results.get(2));
            modelResults.setAdoptersPerTick(results.get(3));

            return modelResults;
         } catch (Exception e) {
             System.out.println(e);
         }

        return null;
    }

    @GetMapping("/maxAdopters") //maximizes Adopters
    public OptimizationResults maxAdopters() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxAdopters.bsearch -o optimization-results-go-here/MaxAdopters");

            OptimizationResults results = new CSVReader().parseResultsCSV("MaxAdopters.finalCheckedBests.csv");
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/maxKnowledge") //maximizes Adopters + Considerers
    public OptimizationResults maxKnowledge() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxKnowledge.bsearch -o optimization-results-go-here/MaxKnowledge");

            OptimizationResults results = new CSVReader().parseResultsCSV("MaxKnowledge.finalCheckedBests.csv");
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/minCost") //minimizes intervention cost per Adopter
    public OptimizationResults optimizeModel() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MinCostPerAdopter.bsearch -o optimization-results-go-here/MinCostPerAdopter");
            
            OptimizationResults results = new CSVReader().parseResultsCSV("MinCostPerAdopter.finalCheckedBests.csv");
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/testOptimizer") //Starts up optimizer with a test model
    public OptimizationResults testOptimizer() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/TestSettings.bsearch -o optimization-results-go-here/Test");
            
            OptimizationResults results = new CSVReader().parseResultsCSV("Test.finalCheckedBests.csv");
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
