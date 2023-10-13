package com.example.automator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.nlogo.headless.HeadlessWorkspace;

import com.example.automator.helper.ModelInput;
import com.example.automator.helper.Parameters;
import com.example.automator.helper.ABMRunner;

public class ABMRunnerTest {

    private ModelInput mockModelInput;

    @BeforeEach
    public void setUpInputParameters() {

        // mock modelInput for input
        mockModelInput = new ModelInput();
        mockModelInput.setNumberOfTicks(360);
        mockModelInput.setFrequencyDirectAd("50");
        mockModelInput.setFrequencyChiefTraining("1");
        mockModelInput.setKindOfIntervention("\"Direct Ad\"");
        mockModelInput.setTrainChiefInfluence("2");
        mockModelInput.setNrDefaultFriendsInterVillage("2");
        mockModelInput.setStdNrDefaultFriendsInterVillage("2");
        mockModelInput.setAvgIntraVillageInteractionFrequency("2");
        mockModelInput.setStdevIntraVillageInteractionFrequency("2");
        mockModelInput.setAvgInterVillageInteractionFrequency("2");
        mockModelInput.setStdevInterVillageInteractionFrequency("2");
        mockModelInput.setAvgChiefFarmerMeetingFrequency("2");
        mockModelInput.setAvgIntraMentionPercentage("2");
        mockModelInput.setStdevIntraMentionPercentage("2");
        mockModelInput.setAvgInterMentionPercentage("2");
        mockModelInput.setStdevInterMentionPercentage("2");
        mockModelInput.setPercentageNegativeWoM("2");
        mockModelInput.setBaseAdoptionProbability("2");
    }
    
    @Test
    public void testRunABM() {
        // call runABM
        ArrayList<String> result = ABMRunner.runABM(mockModelInput);

        // assert
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void testRunABMWithMockedWorkspace() {
        // mock worksapce
        HeadlessWorkspace workspace = mock(HeadlessWorkspace.class);
        when(workspace.report(anyString())).thenReturn(64.0);
        when(workspace.report("count turtles with [adoption_state = 1]")).thenReturn(1.0);
        when(workspace.report("count turtles with [adoption_state = 2]")).thenReturn(2.0);

        // mock result
        ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
        ArrayList<Double> adoptersPerTick = new ArrayList<Double>();
        for (int i = 0; i < mockModelInput.getNumberOfTicks(); i++) {
            awareFarmersPerTick.add(1.0);
            adoptersPerTick.add(2.0);
        }

        // call runABM with mocked workspace
        ArrayList<String> result = ABMRunner.runABM(mockModelInput, workspace);

        // assert
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals("1.0", result.get(0));
        assertEquals("2.0", result.get(1));
        assertEquals(awareFarmersPerTick.toString(), result.get(2));
        assertEquals(adoptersPerTick.toString(), result.get(3));
    }
}