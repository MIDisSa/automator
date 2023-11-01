package com.example.automator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

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
import com.example.automator.helper.ModelResults;
import com.example.automator.helper.OptimizationResults;
import com.example.automator.helper.OptimizationResultsMerger;
import com.example.automator.helper.XMLUpdater;
import com.example.automator.helper.DataInput;
import com.example.automator.helper.UserInput;
import com.example.automator.helper.Parameters;

@RestController
public class AutomatorController { 
    DataInput defaultDataInput = new DataInput();
    DataInput workingDataInput = new DataInput();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/updateInput")
    public void updateInput(@RequestBody DataInput input) {
        //Update Model Parameters
        workingDataInput.setTrainChiefInfluence(input.getTrainChiefInfluence());
        workingDataInput.setNrDefaultFriendsInterVillage(input.getNrDefaultFriendsInterVillage());
        workingDataInput.setStdNrDefaultFriendsInterVillage(input.getStdNrDefaultFriendsInterVillage());
        workingDataInput.setAvgIntraVillageInteractionFrequency(input.getAvgIntraVillageInteractionFrequency());
        workingDataInput.setStdevIntraVillageInteractionFrequency(input.getStdevIntraVillageInteractionFrequency());
        workingDataInput.setAvgInterVillageInteractionFrequency(input.getAvgInterVillageInteractionFrequency());
        workingDataInput.setStdevInterVillageInteractionFrequency(input.getStdevInterVillageInteractionFrequency());
        workingDataInput.setAvgChiefFarmerMeetingFrequency(input.getAvgChiefFarmerMeetingFrequency());
        workingDataInput.setAvgIntraMentionPercentage(input.getAvgIntraMentionPercentage());
        workingDataInput.setStdevIntraMentionPercentage(input.getStdevIntraMentionPercentage());
        workingDataInput.setAvgInterMentionPercentage(input.getAvgInterMentionPercentage());
        workingDataInput.setStdevInterMentionPercentage(input.getStdevInterMentionPercentage());
        workingDataInput.setPercentageNegativeWoM(input.getPercentageNegativeWoM());
        workingDataInput.setBaseAdoptionProbability(input.getBaseAdoptionProbability());

        System.out.println("Updated input");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/results")
    public Object modelResults(@RequestBody UserInput userInput) {

         try {
            //run netlogo model and receive results
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, userInput);

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
    public ModelResults optimize(@RequestBody UserInput userInput) {
        try {
            String optimizationType = userInput.getOptimizationType();
            int budget = Integer.valueOf(userInput.getBudget());
            ModelResults results = null;
            

            if (optimizationType.equalsIgnoreCase("maxAdopters")) {results = maxAdopters(userInput);}
            else if (optimizationType.equalsIgnoreCase("maxKnowledge")) {results = maxKnowledge(userInput);}
            else if (optimizationType.equalsIgnoreCase("minCost")) {results = minCost(userInput);}
            else if(optimizationType.equalsIgnoreCase("test")) {results = testResults(userInput);}


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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/uploadRawCSV") //uploads CSV, runs it through the data processing script and return parameters
    public Parameters uploadRawCSV(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            System.out.println("Error: file is empty");
        }

        try {
            Path filePath = Path.of("CSV-files-go-here/raw-data.csv");

            // check if file already exists and delete if it does
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }

            // save new file to folder
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("File uploaded successfully");

        } catch (IOException e) {
            System.out.println(e);
        }

        // run python script to process data
        try {
            Runtime.getRuntime().exec("python3 data-processing/process-survey-data.py");
        } catch (Exception e) {
            System.out.println(e);
        }

        //get csv from folder and parse it as Parameters object
        String CSV_FILE_PATH_DATA = "CSV-files-go-here/data-processed.csv";
        Parameters parameters = new CSVReader().parseDataCSV(CSV_FILE_PATH_DATA);

        return parameters;


    }


    //Helper methods:

    public ModelResults maxAdopters(UserInput userInput) {
        try {
            //Update Budget
            updateBudget("MaxAdopters.bsearch", Integer.valueOf(userInput.getBudget()));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxAdopters.bsearch -o optimization-results-go-here/MaxAdopters");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxAdopters.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, Integer.valueOf(userInput.getBudget()), userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
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




    public ModelResults maxKnowledge(UserInput userInput) {
        try {
            //Update Budget
            updateBudget("MaxKnowledge.bsearch", Integer.valueOf(userInput.getBudget()));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxKnowledge.bsearch -o optimization-results-go-here/MaxKnowledge");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxKnowledge.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, Integer.valueOf(userInput.getBudget()), userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
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

    public ModelResults minCost(UserInput userInput) {
        try {
            //Update Budget
            updateBudget("MinCostPerAdopter.bsearch.bsearch", Integer.valueOf(userInput.getBudget()));

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MinCostPerAdopter.bsearch -o optimization-results-go-here/MinCostPerAdopter");
            
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MinCostPerAdopter.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, Integer.valueOf(userInput.getBudget()), userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
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

    public ModelResults testResults(UserInput userInput) {
        try {
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("testResults.csv");
            UserInput optimalInput = OptimizationResultsMerger.mergeResults(OptimizationResults, Integer.valueOf(userInput.getBudget()), userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
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
