package com.example.automator.helper;

public class UserInput { //UserInput?
    //Optimization parameters:
    private int numberOfTicks = 360;
    private String frequencyDirectAd;
    private String frequencyChiefTraining;
    private String directAdType;
    private String budget = "100000";
    private String directAdNrOfVillages = "50";
    private String trainChiefsNr = "50";
    private String optimizationType = "test";
    
    private String fixedCostsDirectAd = "6000";
    private String fixedCostsTrainChiefs = "5000";
    private String variableCostsDirectAd = "400";
    private String variableCostsDiscount = "500"; //discount only
    private String variableCostsDelayed = "700"; //deferred payment only
    private String variableCostsDelayedDiscount = "800"; //discount + deferred payment
    private String variableCostsTrainChiefs = "400";


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
        this.directAdType = String.format("\"%s\"", directAdType ) ;
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