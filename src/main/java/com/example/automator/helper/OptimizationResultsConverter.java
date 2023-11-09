package com.example.automator.helper;

//Merges OptimizationResults into ModelInput class to run the model with optimized parameters
public class OptimizationResultsConverter {

    public static ModelInput convertResultsToModelInput(OptimizationResults optRes, ModelInput modelInput) {
        modelInput.setFrequencyDirectAd(optRes.getDirectAdFrequency());
        modelInput.setFrequencyChiefTraining(optRes.getTrainChiefsFrequency());
        modelInput.setDirectAdType(optRes.getDirectAdType());
        modelInput.setDirectAdNrOfVillages(optRes.getDirectAdNrOfVillages());
        modelInput.setTrainChiefsNr(optRes.getTrainChiefsNumber());

        return modelInput;
    }
}
