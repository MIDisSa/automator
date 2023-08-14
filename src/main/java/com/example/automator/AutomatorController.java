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
         try {
            //get csv from folder and parse it as Parameters object
            String pathToCSV = "CSV-files-go-here/data-processed.csv";
            Parameters parameters = new CSVReader().parseCSV(pathToCSV);

            //run netlog model and receive results
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
    public void maxAdopters() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here\\MaxAdopters.bsearch -o optimization-results-go-here\\MaxAdopters");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping("/maxKnowledge") //maximizes Adopters + Considerers
    public void maxKnowledge() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here\\MaxKnowledge.bsearch -o optimization-results-go-here\\MaxKnowledge");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping("/minCost") //minimizes intervention cost per Adopter
    public void optimizeModel() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here\\MinCostPerAdopter.bsearch -o optimization-results-go-here\\MinCostPerAdopter");
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping("testOptimizer") //Starts up optimizer with a test model
    public void testOptimizer() {
        try {
            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here\\TestSettings.bsearch -o optimization-results-go-here\\Test");
                     
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
