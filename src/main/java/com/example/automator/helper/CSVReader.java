package com.example.automator.helper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVReader {

    private static final String CSV_FILE_PATH_DATA = "CSV-files-go-here/data-processed.csv";
    private static final String CSV_FILE_PATH_RESULTS = "optimization-results-go-here/";
    
    public Parameters parseDataCSV() {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH_DATA));
        ) {
            CsvToBean<Parameters> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Parameters.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

            Iterator<Parameters> parameterIterator = csvToBean.iterator();

            while (parameterIterator.hasNext()) {
                Parameters parameters = parameterIterator.next();
                return parameters;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public OptimizationResults parseResultsCSV(String fileName) {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH_RESULTS + fileName));
        ) {
            CsvToBean<OptimizationResults> csvToBean = new CsvToBeanBuilder(reader)
            .withType(OptimizationResults.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

            Iterator<OptimizationResults> resultsIterator = csvToBean.iterator();

            while (resultsIterator.hasNext()) {
                OptimizationResults results = resultsIterator.next();
                return results;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
