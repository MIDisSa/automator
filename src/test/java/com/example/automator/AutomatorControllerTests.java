package com.example.automator;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.print.attribute.standard.Media;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class AutomatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        .get("/")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Greetings from Spring Boot!"));
    }

    @Test
    public void testModelResults() throws Exception {
        // Create a sample ModelInput object as JSON
        String inputJson = "{\"numberOfTicks\": \"360\", \"frequencyDirectAd\": \"50\", \"kindOfIntervention\": \"direct_village_intervention\"}";

        mockMvc.perform(MockMvcRequestBuilders
            .post("/results")
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.awareFarmers").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.adopters").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.awareFarmersPerTick").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.adoptersPerTick").exists());
    }

    @Test
    public void testOptimizer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        .get("/testOptimizer"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.directAdType").exists())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.directAdFrequency").exists())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.trainChiefsFrequency").exists())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.directAdNrOfVillages").exists())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.trainChiefsNumber").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.bestFitness").exists());

        final String PATH = "optimization-results-go-here/";
        Files.deleteIfExists(Paths.get(PATH + "Test.bestHistory.csv"));
        Files.deleteIfExists(Paths.get(PATH + "Test.finalBests.csv"));
        Files.deleteIfExists(Paths.get(PATH + "Test.finalCheckedBests.csv"));
        Files.deleteIfExists(Paths.get(PATH + "Test.modelRunHistory.csv"));
        Files.deleteIfExists(Paths.get(PATH + "Test.objectiveFunctionHistory.csv"));
        Files.deleteIfExists(Paths.get(PATH + "Test.searchConfig.xml"));
    }
}