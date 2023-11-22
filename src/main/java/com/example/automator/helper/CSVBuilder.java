package com.example.automator.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVBuilder {

    public static String[] buildCsvEntryForModelResults(ModelResults modelResults, DataInput workingDataInput, UserInput workingUserInput) {
            String[] newRow = {};
            List<String> row = new ArrayList<String>(Arrays.asList(newRow));
            row.add(String.format("%s", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
            row.add(modelResults.getAdopters());
            row.add(modelResults.getAwareFarmers());
            row.add(modelResults.getTotalCost());
            row.add(String.valueOf(workingUserInput.getNumberOfTicks()));
            row.add(workingUserInput.getBudget());
            row.add(workingUserInput.getFixedCostsDirectAd());
            row.add(workingUserInput.getFixedCostsTrainChiefs());
            row.add(workingUserInput.getVariableCostsDirectAd());
            row.add(workingUserInput.getVariableCostsDiscount());
            row.add(workingUserInput.getVariableCostsDelayed());
            row.add(workingUserInput.getVariableCostsDelayedDiscount());
            row.add(workingUserInput.getVariableCostsTrainChiefs());
            row.add(workingUserInput.getFrequencyDirectAd());
            String type = workingUserInput.getDirectAdType();
            row.add(type.substring(2, type.length() - 2));
            row.add(workingUserInput.getFrequencyChiefTraining());
            row.add(workingUserInput.getDirectAdCoverage());
            row.add(workingUserInput.getTrainChiefsCoverage());
            row.add(workingUserInput.getPercentageOfVillagersAddressed());
            row.add(workingDataInput.getAvgIntraMentionPercentage());
            row.add(workingDataInput.getPercentageNegativeWoM());
            row.add(workingDataInput.getBaseAdoptionProbability());
            row.add(workingDataInput.getNrDefaultFriendsInterVillage());
            row.add(workingDataInput.getAvgInterVillageInteractionFrequency());
            row.add(workingDataInput.getAvgIntraVillageInteractionFrequency());
            row.add(workingDataInput.getAvgChiefFarmerMeetingFrequency());
            row.add(workingDataInput.getTrainChiefInfluence());

            newRow = row.toArray(newRow);
            return newRow;
    }
}
