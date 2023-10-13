package com.example.automator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.automator.helper.CSVReader;
import com.example.automator.helper.Parameters;

public class CSVReaderTests {

    @Test
    public void testParseCSV() {

        // mock results
        Parameters mockParameters = new Parameters();
        mockParameters.setTrainChiefInfluence("2");
        mockParameters.setNrDefaultFriendsInterVillage("2");
        mockParameters.setStdNrDefaultFriendsInterVillage("2");
        mockParameters.setAvgIntraVillageInteractionFrequency("2");
        mockParameters.setStdevIntraVillageInteractionFrequency("2");
        mockParameters.setAvgInterVillageInteractionFrequency("2");
        mockParameters.setStdevInterVillageInteractionFrequency("2");
        mockParameters.setAvgChiefFarmerMeetingFrequency("2");
        mockParameters.setAvgIntraMentionPercentage("2");
        mockParameters.setStdevIntraMentionPercentage("2");
        mockParameters.setAvgInterMentionPercentage("2");
        mockParameters.setStdevInterMentionPercentage("2");
        mockParameters.setPercentageNegativeWoM("2");
        mockParameters.setBaseAdoptionProbability("2");

        // test results
        CSVReader csvReader = new CSVReader();
        String pathToTestCSV = "src/test/java/com/example/automator/test-helpers/data-processed-for-tests.csv";
        Parameters testResult = csvReader.parseDataCSV(pathToTestCSV);

        // assert
        assertEquals(mockParameters.getTrainChiefInfluence(), testResult.getTrainChiefInfluence());
        assertEquals(mockParameters.getNrDefaultFriendsInterVillage(), testResult.getNrDefaultFriendsInterVillage());
        assertEquals(mockParameters.getStdNrDefaultFriendsInterVillage(), testResult.getStdNrDefaultFriendsInterVillage());
        assertEquals(mockParameters.getAvgIntraVillageInteractionFrequency(), testResult.getAvgIntraVillageInteractionFrequency());
        assertEquals(mockParameters.getStdevIntraVillageInteractionFrequency(), testResult.getStdevIntraVillageInteractionFrequency());
        assertEquals(mockParameters.getAvgInterVillageInteractionFrequency(), testResult.getAvgInterVillageInteractionFrequency());
        assertEquals(mockParameters.getStdevInterVillageInteractionFrequency(), testResult.getStdevInterVillageInteractionFrequency());
        assertEquals(mockParameters.getAvgChiefFarmerMeetingFrequency(), testResult.getAvgChiefFarmerMeetingFrequency());
        assertEquals(mockParameters.getAvgIntraMentionPercentage(), testResult.getAvgIntraMentionPercentage());
        assertEquals(mockParameters.getStdevIntraMentionPercentage(), testResult.getStdevIntraMentionPercentage());
        assertEquals(mockParameters.getAvgInterMentionPercentage(), testResult.getAvgInterMentionPercentage());
        assertEquals(mockParameters.getStdevInterMentionPercentage(), testResult.getStdevInterMentionPercentage());
        assertEquals(mockParameters.getPercentageNegativeWoM(), testResult.getPercentageNegativeWoM());
        assertEquals(mockParameters.getBaseAdoptionProbability(), testResult.getBaseAdoptionProbability());
    }
    
}
