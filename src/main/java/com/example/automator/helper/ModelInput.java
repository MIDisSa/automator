package com.example.automator.helper;

public class ModelInput {

    private int numberOfTicks;
    private int frequencyDirectAd;
    private String kindOfIntervention;

    public int getNumberOfTicks() {
        return numberOfTicks;
    }

    public int getFrequencyDirectAd() {
        return frequencyDirectAd;
    }

    public String getKindOfIntervention() {
        return kindOfIntervention;
    }
    
    public void setNumberOfTicks(int numberOfTicks) {
        this.numberOfTicks = numberOfTicks;
    }

    public void setFrequencyDirectAd(int frequencyDirectAd) {
        this.frequencyDirectAd = frequencyDirectAd;
    }

    public void setKindOfIntervention(String kindOfIntervention) {
        this.kindOfIntervention = kindOfIntervention;
    }
}
