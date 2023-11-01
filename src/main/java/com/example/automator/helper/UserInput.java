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
    
    private String fixedCostsDirectAd;
    private String fixedCostsTrainChiefs;
    private String variableCostsDirectAd;
    private String variableCostsDiscount; //discount only
    private String variableCostsDelayed; //deferred payment only
    private String variableCostsDelayedDiscount; //discount + deferred payment
    private String variableCostsTrainChiefs; 


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

    public String getFixedCostsDirectAd() {
        return fixedCostsDirectAd;
    }

    public String getFixedCostsTrainChiefs() {
        return fixedCostsTrainChiefs;
    }

    public String getVariableCostsDirectAd() {
        return variableCostsDirectAd;
    }

    public String getVariableCostsDiscount() {
        return variableCostsDiscount;
    }

    public String getVariableCostsDelayed() {
        return variableCostsDelayed;
    }

    public String getVariableCostsDelayedDiscount() {
        return variableCostsDelayedDiscount;
    }

    public String getVariableCostsTrainChiefs() {
        return variableCostsTrainChiefs;
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

    public void setFixedCostsDirectAd(String fixedCostsDirectAd) {
        this.fixedCostsDirectAd = fixedCostsDirectAd;
    }

    public void setFixedCostsTrainChiefs(String fixedCostsTrainChiefs) {
        this.fixedCostsTrainChiefs = fixedCostsTrainChiefs;
    }

    public void setVariableCostsDirectAd(String variableCostsDirectAd) {
        this.variableCostsDirectAd = variableCostsDirectAd;
    }

    public void setVariableCostsDiscount(String variableCostsDiscount) {
        this.variableCostsDiscount = variableCostsDiscount;
    }

    public void setVariableCostsDelayed(String variableCostsDelayed) {
        this.variableCostsDelayed = variableCostsDelayed;
    }

    public void setVariableCostsDelayedDiscount(String variableCostsDelayedDiscount) {
        this.variableCostsDelayedDiscount = variableCostsDelayedDiscount;
    }

    public void setVariableCostsTrainChiefs(String variableCostsTrainChiefs) {
        this.variableCostsTrainChiefs = variableCostsTrainChiefs;
    }
}