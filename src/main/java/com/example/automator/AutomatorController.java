package com.example.automator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.automator.helper.ABMRunner;
import com.example.automator.helper.CLIRunner;
import com.example.automator.helper.CSVReader;
import com.example.automator.helper.ModelResults;
import com.example.automator.helper.OptimizationResults;
import com.example.automator.helper.OptimizationResultsConverter;
import com.example.automator.helper.XMLUpdater;
import com.example.automator.helper.DataInput;
import com.example.automator.helper.UserInput;
import com.example.automator.helper.OptimizationOutput;
import com.example.automator.helper.Parameters;
import com.example.automator.helper.CSVBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AutomatorController { 
    DataInput workingDataInput = new DataInput();
    UserInput workingUserInput = new UserInput();

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping(value="/downloadModelResultsCSV", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] downloadModelResultsCSV() throws IOException {
        String path = "model-results-go-here/modelResults.csv";
        InputStream in = Files.newInputStream(Path.of(path));
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value="/downloadOptimizationResultsCSV", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] downloadOptimizationResultsCSV() throws IOException {
        String path = "optimization-results-go-here/optimizationResults.csv";
        InputStream in = Files.newInputStream(Path.of(path));
        return IOUtils.toByteArray(in);
    }

    @PostMapping("/updateInput")
    @ResponseStatus(HttpStatus.OK)
    public void updateInput(@RequestBody DataInput input) {
        // check if input is valid
        String inputValidation = input.isDataInputValid(input);
        if (inputValidation != "ok") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, inputValidation); // 400 - bad request
        }
        System.out.println("input is valid");

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

    @PostMapping("/resetInput")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DataInput> resetInput(){
        DataInput workingDataInput = new DataInput();
        System.out.println("DataInput set to default parameters");
        return ResponseEntity.ok(workingDataInput); // gives back workingDataInput with 200 OK message
    }

    @PostMapping("/updateGlobalInput") 
    @ResponseStatus(HttpStatus.OK)
    public void updateGlobalInput(@RequestBody UserInput userInput) {
        //check if input is valid

        //Update Global Parameters
        workingUserInput.setNumberOfTicks(userInput.getNumberOfTicks());
        workingUserInput.setBudget(userInput.getBudget());
        workingUserInput.setFixedCostsDirectAd(userInput.getFixedCostsDirectAd());
        workingUserInput.setFixedCostsTrainChiefs(userInput.getFixedCostsTrainChiefs());
        workingUserInput.setVariableCostsDirectAd(userInput.getVariableCostsDirectAd());
        workingUserInput.setVariableCostsDiscount(userInput.getVariableCostsDiscount());
        workingUserInput.setVariableCostsDelayed(userInput.getVariableCostsDelayed());
        workingUserInput.setVariableCostsDelayedDiscount(userInput.getVariableCostsDelayedDiscount());
        workingUserInput.setVariableCostsTrainChiefs(userInput.getVariableCostsTrainChiefs());

        workingUserInput.setFrequencyDirectAd(userInput.getFrequencyDirectAd());
        workingUserInput.setFrequencyChiefTraining(userInput.getFrequencyChiefTraining());
        workingUserInput.setDirectAdType(userInput.getDirectAdType());
        workingUserInput.setDirectAdCoverage(userInput.getDirectAdCoverage());
        workingUserInput.setTrainChiefsCoverage(userInput.getTrainChiefsCoverage());
        workingUserInput.setPercentageOfVillagersAddressed(userInput.getPercentageOfVillagersAddressed());

        //add later maybe:
        /*workingUserInput.setFarmersPerVillage(userInput.getFarmersPerVillage());
        workingUserInput.setNrOfVillages(userInput.getNrOfVillages());
        workingUserInput.setNrOfNeighborhoods(userInput.getNrOfNeighborhoods());
        workingUserInput.setPercentageOfNumbersInFarmgroup(userInput.getPercentageOfNumbersInFarmgroup());

        workingUserInput.setOptimizationType(userInput.getOptimizationType());*/

        // check if input is valid
        String inputValidation = userInput.isGlobalInputValid(userInput);
        if (inputValidation != "ok") {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, inputValidation); // 406 - not acceptable
        }
        System.out.println("input is valid");
    }

    @PostMapping("/resetGlobalInput")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserInput> resetGlobalInput(){
        UserInput workingUserInput = new UserInput();
        System.out.println("UserInput set to default parameters");
        return ResponseEntity.ok(workingUserInput); // gives back workingDataInput with 200 OK message
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/results")
    @ResponseStatus(HttpStatus.OK)
    public Object modelResults(@RequestBody UserInput userInput) {

        // check if user input is valid
        String inputValidation = userInput.isModelInputValid(userInput);
        if (inputValidation != "ok") {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, inputValidation); // 406 - not acceptable
        }
        System.out.println("input is valid");

        //Path to output CSV
        File file = new File("model-results-go-here/modelResults.csv");

         try {
            //run netlogo model and receive results
            workingUserInput.setFrequencyDirectAd(userInput.getFrequencyDirectAd());
            workingUserInput.setFrequencyChiefTraining(userInput.getFrequencyChiefTraining());
            String directAdType = userInput.getDirectAdType();
            workingUserInput.setDirectAdType(userInput.getDirectAdType().substring(1, directAdType.length() - 1));
            workingUserInput.setDirectAdCoverage(userInput.getDirectAdCoverage());
            workingUserInput.setTrainChiefsCoverage(userInput.getTrainChiefsCoverage());

            ArrayList<String> results = ABMRunner.runABM(workingDataInput, workingUserInput);

            // create ModelResults from results
            ModelResults modelResults = new ModelResults();
            modelResults.saveABMRunnerOutput(results);
            
            //Build row for ResultsCSV
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] newRow = CSVBuilder.buildCsvEntryForModelResults(modelResults, workingDataInput, workingUserInput);

            //Update ResultsCSV
            writer.writeNext(newRow);
            writer.close();
            
            // check if model results are valid
            String outputValidation = modelResults.isModelResultsValid(modelResults);
            if (outputValidation != "ok") {
                throw new ResponseStatusException(HttpStatus.CONFLICT, outputValidation); // 409 - conflict
            }
            System.out.println("output is valid");

            return modelResults;
         } catch (Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Something went wrong: ", e)); // 400 - bad request
         }
    }

    @PostMapping("/testUpdateXML") 
    public void updateXML(@RequestBody UserInput input) {
        XMLUpdater.updateXML("MaxAdoptersTest.bsearch", workingDataInput, input);
    }
    
    @PostMapping("/optimization") //Optimization
    @ResponseStatus(HttpStatus.OK)
    public OptimizationOutput optimize(@RequestBody UserInput userInput) {

        // check if user input is valid
       /*  String inputValidation = userInput.isOptimizationInputValid(optimizationType);
        if (inputValidation != "ok") {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, inputValidation); // 406 - not acceptable
        }
        System.out.println("input is valid");*/

        try {
            workingUserInput.setOptimizationType(userInput.getOptimizationType());
            System.out.println(workingUserInput.getOptimizationType());
            OptimizationOutput results = null;
            
            switch(workingUserInput.getOptimizationType()) {
                case "maxAdopters":
                    results = maxAdopters(workingUserInput);
                    System.out.println("maximizing adopters");
                    break;
                case "maxKnowledge":
                    results = maxKnowledge(workingUserInput);
                    break;
                case "minCost":
                    results = minCost(workingUserInput);
                    System.out.println("minimizing cost");
                    break;
                case "test":
                    results = testResults(workingUserInput);
                    System.out.println("returning test results");
                    break;
            }

            // check if optimization results are valid
            String outputValidation = results.isOptimizationResultValid(results);
            if (outputValidation != "ok") {
                throw new ResponseStatusException(HttpStatus.CONFLICT, outputValidation); // 409 - conflict
            }
            System.out.println("output is valid");

            //Make Interpreter return results + the nr of ads/trainings and change return type of optimize() to a new type which includes those?
            return results;

        } catch(Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Something went wrong: ", e)); // 400 - bad request
        }
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
    @ResponseStatus(HttpStatus.OK)
    public Parameters uploadRawCSV(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("The file you uploaded is empty.")); // 400 - bad request
        }

        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, String.format("The file you uploaded does not have a .csv ending.")); // 415 - unsupported media type
        }

        try {
            Path filePath = Path.of("./CSV-files-go-here/raw-data.csv");

            // check if file already exists and delete if it does
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }

            // save new file to folder
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("File uploaded successfully");

        } catch (IOException e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Something went wrong when trying to store the file: ", e)); // 400 - bad request
        }

        // check if file is valid CSV
        CSVReader csvReader = new CSVReader();
        String validHeader = csvReader.checkDataCSVHeader("./CSV-files-go-here/raw-data.csv");
        if(validHeader != "ok") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validHeader); // 400 - bad request
        }
        String validValues = csvReader.checkDataCSVValues("./CSV-files-go-here/raw-data.csv");
        if(validValues != "ok") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validValues); // 400 - bad request
        }
        System.out.println("File is valid CSV");

        // run python script to process data
        try {
            ProcessBuilder pb = new ProcessBuilder();
            if (SystemUtils.IS_OS_WINDOWS) {
                System.out.println("Building process for Windows...");
                pb.command("python3", "./data-processing/process-survey-data.py");
            } else if (SystemUtils.IS_OS_UNIX) {
                System.out.println("Building process for UNIX-System...");
                pb.command("/bin/bash", "-c", "python3 ./data-processing/process-survey-data.py");

            } else {
                throw new IOException("OS not compatible.");
            }

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //get csv from folder and parse it as Parameters object
        String CSV_FILE_PATH_DATA = "./CSV-files-go-here/data-processed.csv";
        Parameters parameters = new CSVReader().parseDataCSV(CSV_FILE_PATH_DATA);

        return parameters;
    }


    //Helper methods:

    public OptimizationOutput maxAdopters(UserInput userInput) {
        try {
            //Update Budget
            XMLUpdater.updateXML("MaxAdopters.bsearch", workingDataInput, userInput);

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxAdopters.bsearch -o optimization-results-go-here/MaxAdopters");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxAdopters.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsConverter.convertResultsToUserInput(OptimizationResults, userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.saveABMRunnerOutput(results);

            OptimizationOutput output = new OptimizationOutput(OptimizationResults, modelResults);
            ArrayList<String> nrOfInterventions = optimalInput.calculateNrOfInterventions();
            output.setNrOfDirectAds(nrOfInterventions.get(0));
            output.setNrOfChiefTrainings(nrOfInterventions.get(0));
            output.setOptimizationType("Max Adopters");

            //Path to output CSV
            File file = new File("optimization-results-go-here/optimizationResults.csv");

            //Build row for ResultsCSV
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] newRow = CSVBuilder.buildCSVEntryForOptimizationResults(output, workingDataInput, workingUserInput);

            //Update ResultsCSV
            writer.writeNext(newRow);
            writer.close();            

            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public OptimizationOutput maxKnowledge(UserInput userInput) {
        try {
            //Update Budget
            XMLUpdater.updateXML("MaxKnowledge.bsearch", workingDataInput, userInput);

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MaxKnowledge.bsearch -o optimization-results-go-here/MaxKnowledge");

            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MaxKnowledge.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsConverter.convertResultsToUserInput(OptimizationResults, userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.saveABMRunnerOutput(results);

            OptimizationOutput output = new OptimizationOutput(OptimizationResults, modelResults);
            ArrayList<String> nrOfInterventions = optimalInput.calculateNrOfInterventions();
            output.setNrOfDirectAds(nrOfInterventions.get(0));
            output.setNrOfChiefTrainings(nrOfInterventions.get(0));
            output.setOptimizationType("Max Knowledge");

            //Path to output CSV
            File file = new File("optimization-results-go-here/optimizationResults.csv");

            //Build row for ResultsCSV
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] newRow = CSVBuilder.buildCSVEntryForOptimizationResults(output, workingDataInput, workingUserInput);

            //Update ResultsCSV
            writer.writeNext(newRow);
            writer.close();

            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public OptimizationOutput minCost(UserInput userInput) {
        try {
            //Update Budget
            XMLUpdater.updateXML("MinCostPerAdopter.bsearch", workingDataInput, userInput);

            CLIRunner CLIRunner = new CLIRunner();
            CLIRunner.runCommand("-p optimization-settings-go-here/MinCostPerAdopter.bsearch -o optimization-results-go-here/MinCostPerAdopter");
            
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("MinCostPerAdopter.finalCheckedBests.csv");
            UserInput optimalInput = OptimizationResultsConverter.convertResultsToUserInput(OptimizationResults, userInput);
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.saveABMRunnerOutput(results);

            OptimizationOutput output = new OptimizationOutput(OptimizationResults, modelResults);
            ArrayList<String> nrOfInterventions = optimalInput.calculateNrOfInterventions();
            output.setNrOfDirectAds(nrOfInterventions.get(0));
            output.setNrOfChiefTrainings(nrOfInterventions.get(0));
            output.setOptimizationType("Min Cost per Adopter");

            //Path to output CSV
            File file = new File("optimization-results-go-here/optimizationResults.csv");

            //Build row for ResultsCSV
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] newRow = CSVBuilder.buildCSVEntryForOptimizationResults(output, workingDataInput, workingUserInput);

            //Update ResultsCSV
            writer.writeNext(newRow);
            writer.close();

            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public OptimizationOutput testResults(UserInput userInput) {
        try {
            OptimizationResults OptimizationResults = new CSVReader().parseResultsCSV("testResults.csv");
            UserInput optimalInput = OptimizationResultsConverter.convertResultsToUserInput(OptimizationResults, userInput);
            
            
            ArrayList<String> results = ABMRunner.runABM(workingDataInput, optimalInput);
            ModelResults modelResults = new ModelResults();
            modelResults.saveABMRunnerOutput(results);

            OptimizationOutput output = new OptimizationOutput(OptimizationResults, modelResults);
            ArrayList<String> nrOfInterventions = optimalInput.calculateNrOfInterventions();
            output.setNrOfDirectAds(nrOfInterventions.get(0));
            output.setNrOfChiefTrainings(nrOfInterventions.get(0));
            output.setOptimizationType("Test Results");

            //Path to output CSV
            File file = new File("optimization-results-go-here/optimizationResults.csv");

            //Build row for ResultsCSV
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] newRow = CSVBuilder.buildCSVEntryForOptimizationResults(output, workingDataInput, workingUserInput);

            //Update ResultsCSV
            writer.writeNext(newRow);
            writer.close();

            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
