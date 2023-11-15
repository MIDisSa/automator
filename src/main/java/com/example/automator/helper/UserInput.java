package com.example.automator.helper;

import java.util.ArrayList;

import org.springframework.util.Assert;

public class UserInput { //UserInput?
    //Optimization parameters:
    private int numberOfTicks = 360;
    private String budget = "100000";
    private String fixedCostsDirectAd = "6000";
    private String fixedCostsTrainChiefs = "5000";
    private String variableCostsDirectAd = "400";
    private String variableCostsDiscount = "500"; //discount only
    private String variableCostsDelayed = "700"; //deferred payment only
    private String variableCostsDelayedDiscount = "800"; //discount + deferred payment
    private String variableCostsTrainChiefs = "400";

    private String frequencyDirectAd;
    private String frequencyChiefTraining;
    private String directAdType;
    private String directAdCoverage = "50";
    private String trainChiefsCoverage = "50";
    private String optimizationType = "test";
    private String percentageOfVillagersAddressed = "50";
    
    private String farmersPerVillage = "10";
    private String nrOfVillages = "100";
    private String nrOfNeighborhoods = "20";
    private String percentageOfNumbersInFarmgroup = "50";

    public String getFarmersPerVillage() {
        return farmersPerVillage;
    }

    public void setFarmersPerVillage(String farmersPerVillage) {
        this.farmersPerVillage = farmersPerVillage;
    }

    public String getNrOfVillages() {
        return nrOfVillages;
    }

    public void setNrOfVillages(String nrOfVillages) {
        this.nrOfVillages = nrOfVillages;
    }

    public String getNrOfNeighborhoods() {
        return nrOfNeighborhoods;
    }

    public void setNrOfNeighborhoods(String nrOfNeighborhoods) {
        this.nrOfNeighborhoods = nrOfNeighborhoods;
    }

    public String getPercentageOfNumbersInFarmgroup() {
        return percentageOfNumbersInFarmgroup;
    }

    public void setPercentageOfNumbersInFarmgroup(String percentageOfNumbersInFarmgroup) {
        this.percentageOfNumbersInFarmgroup = percentageOfNumbersInFarmgroup;
    }


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

    public String getDirectAdCoverage() {
        return directAdCoverage;
    }

    public String getTrainChiefsCoverage() {
        return trainChiefsCoverage;
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

    public String getPercentageOfVillagersAddressed() {
        return percentageOfVillagersAddressed;
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

    public void setDirectAdCoverage(String directAdCoverage) {
        this.directAdCoverage = directAdCoverage;
    }

    public void setTrainChiefsCoverage(String trainChiefsCoverage) {
        this.trainChiefsCoverage = trainChiefsCoverage;
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

    public void setPercentageOfVillagersAddressed(String percentageOfVillagersAddressed) {
        this.percentageOfVillagersAddressed = percentageOfVillagersAddressed;
    }

    public String isModelInputValid(UserInput userInput) { // numberOfTicks, frequencyDirectAd, frequencyChiefTraining, typeDirectAd
        // nrOfTicks is not zero, not negative
        try {
            Assert.isTrue(userInput.getNumberOfTicks() > 0, "numberOfTicks is zero or negative");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // frequencyDirectAd is not empty, integer, not negative
        try {
            Assert.hasText(userInput.getFrequencyDirectAd(), "frequencyDirectAd is empty");
            Assert.isTrue(userInput.getFrequencyDirectAd().matches("\\d+"), "getFrequencyDirectAd is not a positive integer");
            int frequencyDirectAd = Integer.parseInt(userInput.getFrequencyDirectAd());
            Assert.isTrue(frequencyDirectAd >= 0 && frequencyDirectAd <= 365, "frequencyDirectAd is not within range");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // frequencyChiefTraining is not empty, integer, not negative
        try {
            Assert.hasText(userInput.getFrequencyChiefTraining(), "frequencyChiefTraining is empty");
            Assert.isTrue(userInput.getFrequencyChiefTraining().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            int tempFrequencyChiefTraining = Integer.parseInt(userInput.getFrequencyChiefTraining());
            Assert.isTrue(tempFrequencyChiefTraining >= 0 && tempFrequencyChiefTraining <= 365, "frequencyChiefTraining is not within range");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // directAdType is not empty and matches one of four possible string
        try {
            Assert.hasText(userInput.getDirectAdType(), "directAdType is empty");
            
            ArrayList<String> possible_interventions = new ArrayList<String>();
            possible_interventions.add("\"Direct Ad\"");
            possible_interventions.add("\"Direct Ad + Discount\"");
            possible_interventions.add("\"Direct Ad + Delayed Payment\"");
            possible_interventions.add("\"Direct Ad + Delayed P. + Discount\"");
            Assert.isTrue(possible_interventions.contains(userInput.getDirectAdType()), "directAdType is not one of the four possible interventions");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        System.out.println("parameters are correct");
        return "ok";
    }

    public String isOptimizationInputValid(UserInput userInput) { // optimizationType, budget, fixedCostsDirectAd, fixedCostsTrainChiefs, variableCostsDirectAd, variableCostsDiscount, variableCostsDelayed, variableCostsDelayedDiscount, variableCostsTrainChiefs
        // optimizationType matches one of four possible string
        try {            
            ArrayList<String> possible_optimizations = new ArrayList<String>();
            possible_optimizations.add("maxAdopters");
            possible_optimizations.add("maxKnowledge");
            possible_optimizations.add("minCost");
            possible_optimizations.add("test");
            Assert.isTrue(possible_optimizations.contains(userInput.getOptimizationType()), "optimizationType is not one of the four possible types");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        
        // parameters are not empty, not negative
        try {
            Assert.hasText(userInput.getOptimizationType(), "optimizationType is empty");
            Assert.hasText(userInput.getBudget(), "budget is empty");
            Assert.hasText(userInput.getFixedCostsDirectAd(), "fixedCostsDirectAd is empty");
            Assert.hasText(userInput.getFixedCostsTrainChiefs(), "fixedCostsTrainChiefs is empty");
            Assert.hasText(userInput.getVariableCostsDirectAd(), "variableCostsDirectAd is empty");
            Assert.hasText(userInput.getVariableCostsDiscount(), "variableCostsDiscount is empty");
            Assert.hasText(userInput.getVariableCostsDelayed(), "variableCostsDelayed is empty");
            Assert.hasText(userInput.getVariableCostsDelayedDiscount(), "variableCostsDelayedDiscount is empty");
            Assert.hasText(userInput.getVariableCostsTrainChiefs(), "variableCostsTrainChiefs is empty");

            Assert.isTrue(userInput.getBudget().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getFixedCostsDirectAd().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getFixedCostsTrainChiefs().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getVariableCostsDirectAd().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getVariableCostsDiscount().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getVariableCostsDelayed().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getVariableCostsDelayedDiscount().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
            Assert.isTrue(userInput.getVariableCostsTrainChiefs().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "ok";
    }
}