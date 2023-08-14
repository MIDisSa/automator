package com.example.automator.helper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVReader {
    
    public Parameters parseCSV(String pathToCSV) {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(pathToCSV));
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
}
