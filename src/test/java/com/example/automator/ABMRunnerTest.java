package com.example.automator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.nlogo.headless.HeadlessWorkspace;

import com.example.automator.helper.DataInput;
import com.example.automator.helper.UserInput;
import com.example.automator.helper.Parameters;
import com.example.automator.helper.ABMRunner;

public class ABMRunnerTest {

    private DataInput mockDataInput;
    private UserInput mockUserInput;

    @BeforeEach
    public void setUpDataInputParameters() {

        // mock modelInput for input
        mockDataInput = new DataInput();
        
        mockDataInput.setTrainChiefInfluence("2");
        mockDataInput.setNrDefaultFriendsInterVillage("2");
        mockDataInput.setStdNrDefaultFriendsInterVillage("2");
        mockDataInput.setAvgIntraVillageInteractionFrequency("2");
        mockDataInput.setStdevIntraVillageInteractionFrequency("2");
        mockDataInput.setAvgInterVillageInteractionFrequency("2");
        mockDataInput.setStdevInterVillageInteractionFrequency("2");
        mockDataInput.setAvgChiefFarmerMeetingFrequency("2");
        mockDataInput.setAvgIntraMentionPercentage("2");
        mockDataInput.setStdevIntraMentionPercentage("2");
        mockDataInput.setAvgInterMentionPercentage("2");
        mockDataInput.setStdevInterMentionPercentage("2");
        mockDataInput.setPercentageNegativeWoM("2");
        mockDataInput.setBaseAdoptionProbability("2");
    }

    @BeforeEach
    public void setUpUserInputParameters() {
        mockUserInput = new UserInput();
    }
    
    @Test
    public void testRunABMWithMockedWorkspace() {
        // mock workspace
        HeadlessWorkspace workspace = mock(HeadlessWorkspace.class);
        when(workspace.report(anyString())).thenReturn(64.0);
        when(workspace.report("count turtles with [adoption_state = 1]")).thenReturn(1.0);
        when(workspace.report("count turtles with [adoption_state = 2]")).thenReturn(2.0);

        // mock result
        ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
        ArrayList<Double> adoptersPerTick = new ArrayList<Double>();
        for (int i = 0; i < mockUserInput.getNumberOfTicks(); i++) {
            awareFarmersPerTick.add(1.0);
            adoptersPerTick.add(2.0);
        }

        // call runABM with mocked workspace
        ArrayList<String> result = ABMRunner.runABM(mockDataInput, mockUserInput, workspace);

        // assert
        assertNotNull(result);
        assertEquals(7, result.size());
        assertEquals("1.0", result.get(0));
        assertEquals("2.0", result.get(1));
        assertEquals(awareFarmersPerTick.toString(), result.get(5));
        assertEquals(adoptersPerTick.toString(), result.get(6));
    }
}