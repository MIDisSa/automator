package com.example.automator.helper;

//Merges OptimizationResults into ModelInput class to run the model with optimized parameters
public class OptimizationResultsConverter {

    public static UserInput convertResultsToUserInput(OptimizationResults optRes, UserInput userInput) {
        userInput.setFrequencyDirectAd(optRes.getDirectAdFrequency());
        userInput.setFrequencyChiefTraining(optRes.getTrainChiefsFrequency());
        userInput.setDirectAdType(optRes.getDirectAdType());
        userInput.setDirectAdCoverage(optRes.getDirectAdNrOfVillages());
        userInput.setTrainChiefsCoverage(optRes.getTrainChiefsNumber());

        return userInput;
    }
}
