package com.example.automator.helper;

public class ModelInput {
    private int numberOfTicks;
    private int frequencyDirectAd;
    private int frequencyChiefTraining;
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

    public int getFrequencyChiefTraining() {return frequencyChiefTraining;}

    public void setFrequencyChiefTraining(int frequencyChiefTraining) {this.frequencyChiefTraining = frequencyChiefTraining;}
}
