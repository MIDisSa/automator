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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
            Parameters parameters = new CSVReader().parseCSV();

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
}
