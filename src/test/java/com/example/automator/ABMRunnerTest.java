package com.example.automator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.automator.helper.ModelInput;
import com.example.automator.helper.Parameters;
import com.example.automator.helper.ABMRunner;

public class ABMRunnerTest {

    private Parameters mockParameters;
    private ModelInput mockModelInput;

    @BeforeEach
    public void setUpInputParameters() {
        // mock parameters for input
        mockParameters = new Parameters();
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

        // mock modelInput for input
        mockModelInput = new ModelInput();
        mockModelInput.setNumberOfTicks(360);
        mockModelInput.setFrequencyDirectAd(50);
        mockModelInput.setKindOfIntervention("direct_village_intervention");
    }
    
    @Test
    public void testRunABM() {
        // call runABM
        ArrayList<String> result = ABMRunner.runABM(mockParameters, mockModelInput);

        // assert
        assertNotNull(result);
        assertEquals(4, result.size());
        
    }
}
