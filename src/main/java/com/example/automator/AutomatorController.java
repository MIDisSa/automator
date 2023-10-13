package com.example.automator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import org.apache.commons.io.IOUtils;

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
         try {
            //get csv from folder and parse it as Parameters object
            String CSV_FILE_PATH_DATA = "CSV-files-go-here/data-processed.csv";
            Parameters parameters = new CSVReader().parseDataCSV(CSV_FILE_PATH_DATA);

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

    @PostMapping("uploadCSV") //uploads CSV and stores it locally
    public void uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("File is empty");
        }

        try {
            Path filePath = Path.of("CSV-files-go-here/data-processed.csv");

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
    }

    @GetMapping(value="downloadCSV", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE) //downloads CSV from server
    public @ResponseBody byte[] downloadCSV() throws IOException{
        String path = "CSV-files-go-here/data-empty.csv";
        InputStream in = Files.newInputStream(Path.of(path));
        return IOUtils.toByteArray(in);
    }
}
