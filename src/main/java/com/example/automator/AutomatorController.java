package com.example.automator;

import org.nlogo.headless.HeadlessWorkspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.automator.helper.ABMRunner;
import com.example.automator.helper.CSVReader;
import com.example.automator.helper.Parameters;

@RestController
public class AutomatorController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/model-results")
    public String modelResults() {
        //get csv from folder and parse it as Parameters object
         try {
            Parameters parameters = new CSVReader().parseCSV();
         } catch (Exception e) {
             System.out.println(e);
         }

        //run netlog model and receive results
        ABMRunner.runABM();

        return "result"; //TODO: this should return actual results
    }
}
