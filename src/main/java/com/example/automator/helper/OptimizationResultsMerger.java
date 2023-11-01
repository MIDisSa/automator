package com.example.automator.helper;

//Merges OptimizationResults into ModelInput class to run the model with optimized parameters
public class OptimizationResultsMerger {

    public static UserInput mergeResults(OptimizationResults optRes, int budget, UserInput userInput) {
        userInput.setFrequencyDirectAd(optRes.getDirectAdFrequency());
        userInput.setFrequencyChiefTraining(optRes.getTrainChiefsFrequency());
        userInput.setDirectAdType(optRes.getDirectAdType());
        userInput.setBudget(String.valueOf(budget));
        userInput.setDirectAdNrOfVillages(optRes.getDirectAdNrOfVillages());
        userInput.setTrainChiefsNr(optRes.getTrainChiefsNumber());

        return userInput;
    }
}
