package com.example.automator.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVBuilder {

    public static String[] buildCsvHeaderForModelResults() {
        String[] newHeader = {"Timestamp","Adopters","Aware Agents","Total Cost","Days","Number of Villages","Number of Neighborhoods","Avg. Number of Farmers per Village","% of Farmers in Farmgoup","Budget","Fixed Costs Direct Ad","Fixed Costs ToT","Variable Costs Direct Ad","Variable Costs Direct Ad + Discount","Variable Costs for Direct Ad + Deferred Payment","Variable Costs for Direct Ad + Deferred Payment + Discount","Variable Costs ToT","Treatment Frequency","Treatment Arm","ToT Frequency","Treatment Coverage","ToT Coverage","Percentage of Villagers addressed","Mention Probability","Negative WoM","Adoption Probability","Friends Inter Village","Inter Village Interaction Frequency","Intra Village Interaction Frequency","Farmgroup Meeting Frequency","ToT Influence"
    };
        return newHeader;
    }

    public static String[] buildCsvHeaderForOptimizationResults() {
        String[] newHeader = {"Timestamp","Optimization Type","Best Fitness","Treatment Arm*","Treatment Frequency*","ToT Frequency*","Treatment Coverage*","ToT Coverage*","Percentage of Villagers addressed","Number of Treatments*","Number of ToTs*","Total Cost","Days","Number of Villages","Number of Neighborhoods","Avg. Number of Farmers per Village","% of Farmers in Farmgoup","Budget","Fixed Costs Direct Ad","Fixed Costs ToT","Variable Costs Direct Ad","Variable Costs Direct Ad + Discount","Variable Costs for Direct Ad + Deferred Payment","Variable Costs for Direct Ad + Deferred Payment + Discount","Variable Costs ToT","Mention Probability","Negative WoM","Adoption Probability","Friends Inter Village","Inter Village Interaction Frequency","Intra Village Interaction Frequency","Farmgroup Meeting Frequency","ToT Influence"
    };
        return newHeader;
    }

    public static String[] buildCsvEntryForModelResults(ModelResults modelResults, DataInput workingDataInput, UserInput workingUserInput) {
        String[] newRow = {};
        List<String> row = new ArrayList<String>(Arrays.asList(newRow));

        row.add(String.format("%s", LocalDateTime.now().plusHours(1).truncatedTo(ChronoUnit.MINUTES).toString()));
        
        Double adopters = Double.valueOf(modelResults.getAdopters());
        Double awareFarmers = Double.valueOf(modelResults.getAwareFarmers());
        Double totalAwareAgents = adopters + awareFarmers;

        row.add(String.valueOf(adopters));
        row.add(String.valueOf(totalAwareAgents));
        row.add(modelResults.getTotalCost());
        row.add(workingUserInput.getNumberOfTicks());
        row.add(workingUserInput.getNrOfVillages());
        row.add(workingUserInput.getNrOfNeighborhoods());
        row.add(workingUserInput.getFarmersPerVillage());
        row.add(workingUserInput.getPercentageOfFarmersInFarmgroup());
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
        row.add(type.substring(1, type.length() - 1)); //removes " at the start and end of the string for better legibility
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

    public static String[] buildCSVEntryForOptimizationResults(OptimizationOutput optimizationOutput, DataInput workingDataInput, UserInput workingUserInput) {
        String[] newRow = {};
        List<String> row = new ArrayList<String>(Arrays.asList(newRow));

        row.add(String.format("%s", LocalDateTime.now().plusHours(1).truncatedTo(ChronoUnit.MINUTES).toString()));
        row.add(optimizationOutput.getOptimizationType());
        row.add(optimizationOutput.getBestFitness());
        row.add(optimizationOutput.getDirectAdType());
        row.add(optimizationOutput.getDirectAdFrequency());
        row.add(optimizationOutput.getTrainChiefsFrequency());
        row.add(optimizationOutput.getDirectAdNrOfVillages());
        row.add(optimizationOutput.getTrainChiefsNumber());
        row.add(workingUserInput.getPercentageOfVillagersAddressed());
        row.add(optimizationOutput.getNrOfDirectAds());
        row.add(optimizationOutput.getNrOfChiefTrainings());
        row.add(optimizationOutput.getTotalCost());
        row.add(workingUserInput.getNumberOfTicks());
        row.add(workingUserInput.getNrOfVillages());
        row.add(workingUserInput.getNrOfNeighborhoods());
        row.add(workingUserInput.getFarmersPerVillage());
        row.add(workingUserInput.getPercentageOfFarmersInFarmgroup());
        row.add(workingUserInput.getBudget());
        row.add(workingUserInput.getFixedCostsDirectAd());
        row.add(workingUserInput.getFixedCostsTrainChiefs());
        row.add(workingUserInput.getVariableCostsDirectAd());
        row.add(workingUserInput.getVariableCostsDiscount());
        row.add(workingUserInput.getVariableCostsDelayed());
        row.add(workingUserInput.getVariableCostsDelayedDiscount());
        row.add(workingUserInput.getVariableCostsTrainChiefs());
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
