package com.example.automator;

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
}
