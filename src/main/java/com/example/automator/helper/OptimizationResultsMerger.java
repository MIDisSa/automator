package com.example.automator.helper;

import ch.qos.logback.core.model.Model;

//Merges OptimizationResults into ModelInput class to run the model with optimized parameters
public class OptimizationResultsMerger {

    public static ModelInput mergeResults(OptimizationResults optRes, int budget, ModelInput modelInput) {
        modelInput.setFrequencyDirectAd(optRes.getDirectAdFrequency());
        modelInput.setFrequencyChiefTraining(optRes.getTrainChiefsFrequency());
        modelInput.setDirectAdType(optRes.getDirectAdType());
        modelInput.setBudget(String.valueOf(budget));
        modelInput.setDirectAdNrOfVillages(optRes.getDirectAdNrOfVillages());
        modelInput.setTrainChiefsNr(optRes.getTrainChiefsNumber());

        return modelInput;
    }
}
