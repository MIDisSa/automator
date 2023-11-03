package com.example.automator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.nlogo.app.App;
import org.springframework.boot.autoconfigure.web.reactive.ResourceHandlerRegistrationCustomizer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.automator.helper.ABMRunner;
import com.example.automator.helper.CLIRunner;
import com.example.automator.helper.CSVReader;
import com.example.automator.helper.ModelInput;
import com.example.automator.helper.ModelResults;
import com.example.automator.helper.OptimizationInput;
import com.example.automator.helper.OptimizationResults;
import com.example.automator.helper.OptimizationResultsMerger;
import com.example.automator.helper.XMLUpdater;

@RestController
public class AutomatorController { 
    ModelInput defaultModelInput = new ModelInput();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/results")
    public Object modelResults(@RequestBody ModelInput modelInput) {

         try {
            //run netlogo model and receive results
            ArrayList<String> results = ABMRunner.runABM(modelInput);

            // create ModelResults from results
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setNrOfDirectAds(results.get(2));
            modelResults.setNrOfChiefTrainings(results.get(3));
            modelResults.setAwareFarmersPerTick(results.get(4));
            modelResults.setAdoptersPerTick(results.get(5));

            return modelResults;
         } catch (Exception e) {
             System.out.println(e);
         }

        return null;
    }

        @PostMapping("/resultsGUI")
        public Object modelResultsGui(@RequestBody ModelInput modelInput) {

            try {
                //run netlogo model and receive results
                ArrayList<String> results = ABMRunner.runABMWithGUI(modelInput);

                // create ModelResults from results
                ModelResults modelResults = new ModelResults();
                modelResults.setAwareFarmers(results.get(0));
                modelResults.setAdopters(results.get(1));
                modelResults.setNrOfDirectAds(results.get(2));
                modelResults.setNrOfChiefTrainings(results.get(3));
                modelResults.setAwareFarmersPerTick(results.get(4));
                modelResults.setAdoptersPerTick(results.get(5));

                return modelResults;
            } catch (Exception e) {
                System.out.println(e);
            }

            return null;
        }

    @PostMapping("/optimization") //Optimization
    public ModelResults optimize(@RequestBody OptimizationInput optimizationInput) {
        try {
            String optimizationType = optimizationInput.getOptimizationType();
            int budget = optimizationInput.getBudget();
            ModelResults results = null;
            

            if (optimizationType.equalsIgnoreCase("maxAdopters")) {results = maxAdopters(budget);}
            else if (optimizationType.equalsIgnoreCase("maxKnowledge")) {results = maxKnowledge(budget);}
            else if (optimizationType.equalsIgnoreCase("minCost")) {results = minCost(budget);}
            else if(optimizationType.equalsIgnoreCase("test")) {results = testResults(budget);}


            //Make Interpreter return results + the nr of ads/trainings and change return type of optimize() to a new type which includes those?
            
            return results;

        } catch(Exception e) {
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

    //Helper methods:

    public ModelResults maxAdopters(int budget) {
        try {
            //Update Budget
            updateBudget("MaxAdopters.bsearch", Integer.valueOf(budget));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxAdopters.bsearch -o optimization-results-go-here/MaxAdopters");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxAdopters.finalCheckedBests.csv");
            ModelInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, budget, defaultModelInput);
            
            ArrayList<String> results = ABMRunner.runABM(optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setNrOfDirectAds(results.get(2));
            modelResults.setNrOfChiefTrainings(results.get(3));
            modelResults.setAwareFarmersPerTick(results.get(4));
            modelResults.setAdoptersPerTick(results.get(5));

            return modelResults;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ModelResults maxKnowledge(int budget) {
        try {
            //Update Budget
            updateBudget("MaxKnowledge.bsearch", Integer.valueOf(budget));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxKnowledge.bsearch -o optimization-results-go-here/MaxKnowledge");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxKnowledge.finalCheckedBests.csv");
            ModelInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, budget, defaultModelInput);
            
            ArrayList<String> results = ABMRunner.runABM(optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setNrOfDirectAds(results.get(2));
            modelResults.setNrOfChiefTrainings(results.get(3));
            modelResults.setAwareFarmersPerTick(results.get(4));
            modelResults.setAdoptersPerTick(results.get(5));

            return modelResults;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ModelResults minCost(int budget) {
        try {
            //Update Budget
            updateBudget("MinCostPerAdopter.bsearch.bsearch", Integer.valueOf(budget));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MinCostPerAdopter.bsearch -o optimization-results-go-here/MinCostPerAdopter");
            
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MinCostPerAdopter.finalCheckedBests.csv");
            ModelInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, budget, defaultModelInput);
            
            ArrayList<String> results = ABMRunner.runABM(optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setNrOfDirectAds(results.get(2));
            modelResults.setNrOfChiefTrainings(results.get(3));
            modelResults.setAwareFarmersPerTick(results.get(4));
            modelResults.setAdoptersPerTick(results.get(5));

            return modelResults;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ModelResults testResults(int budget) {
        try {
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("testResults.csv");
            ModelInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, budget, defaultModelInput);
            
            ArrayList<String> results = ABMRunner.runABM(optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.setAwareFarmers(results.get(0));
            modelResults.setAdopters(results.get(1));
            modelResults.setNrOfDirectAds(results.get(2));
            modelResults.setNrOfChiefTrainings(results.get(3));
            modelResults.setAwareFarmersPerTick(results.get(4));
            modelResults.setAdoptersPerTick(results.get(5));

            return modelResults;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void updateBudget(String fileName, int value) {
        XMLUpdater xmlUpdater = new XMLUpdater();
        xmlUpdater.updateXML(fileName, value);
    }
}
