package com.example.automator.helper;

public class UserInput { //UserInput?
    //Optimization parameters:
    private int numberOfTicks = 360;
    private String frequencyDirectAd;
    private String frequencyChiefTraining;
    private String directAdType;
    private String budget;
    private String directAdNrOfVillages;
    private String trainChiefsNr;
    private String optimizationType;


    public UserInput() {
    }

    //GETTER (Optimization Parameters)
        public int getNumberOfTicks() {
        return numberOfTicks;
    }

    public String getFrequencyDirectAd() {
        return frequencyDirectAd;
    }

    public String getDirectAdType() {
        return directAdType;
    }

    public String getFrequencyChiefTraining() {
        return frequencyChiefTraining;
    }

    public String getBudget() {
        return budget;
    }

    public String getDirectAdNrOfVillages() {
        return directAdNrOfVillages;
    }

    public String getTrainChiefsNr() {
        return trainChiefsNr;
    }

    public String getOptimizationType() {
        return optimizationType;
    }


    
    //SETTER (Optimization Parameters)
        public void setNumberOfTicks(int numberOfTicks) {
        this.numberOfTicks = numberOfTicks;
    }

    public void setFrequencyDirectAd(String frequencyDirectAd) {
        this.frequencyDirectAd = frequencyDirectAd;
    }

    public void setDirectAdType(String directAdType) {
        this.directAdType = directAdType;
    }
    
    public void setFrequencyChiefTraining(String frequencyChiefTraining) {
        this.frequencyChiefTraining = frequencyChiefTraining;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setDirectAdNrOfVillages(String directAdNrOfVillages) {
        this.directAdNrOfVillages = directAdNrOfVillages;
    }

    public void setTrainChiefsNr(String trainChiefsNr) {
        this.trainChiefsNr = trainChiefsNr;
    }

    public void setOptimizationType(String optimizationType) {
        this.optimizationType = optimizationType;
    }
}