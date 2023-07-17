package com.example.automator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.automator.helper.CSVReader;
import com.example.automator.helper.Parameters;
import com.opencsv.bean.CsvToBeanBuilder;

@RestController
public class AutomatorController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/model-results")
    public Parameters modelResults() throws IOException {
        //get csv from folder and parse it
        Parameters parameters = new CSVReader().parseCSV();

        //run netlog model and receive results

        return parameters; //TODO: this should return actual results
    }
}
