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

    private String frequencyDirectAd = "360";
    private String frequencyChiefTraining = "360";
    private String directAdType = "Direct Ad";
    private String directAdCoverage = "50";
    private String trainChiefsCoverage = "50";
    private String percentageOfVillagersAddressed = "50";
    private String optimizationType = "test";

    
    private String farmersPerVillage = "10";
    private String nrOfVillages = "100";
    private String nrOfNeighborhoods = "20";
    private String percentageOfFarmersInFarmgroup = "50";

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

    public String getPercentageOfFarmersInFarmgroup() {
        return percentageOfFarmersInFarmgroup;
    }

    public void setPercentageOfFarmersInFarmgroup(String percentageOfNumbersInFarmgroup) {
        this.percentageOfFarmersInFarmgroup = percentageOfNumbersInFarmgroup;
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

    public int calculateDirAdCost() {
        int result = 0;
        switch(directAdType) {
            case "\"Direct Ad\"":
                result = Integer.valueOf(fixedCostsDirectAd) + (Integer.valueOf(variableCostsDirectAd) * Integer.valueOf(directAdCoverage));
                break;
            case "\"Direct Ad + Discount\"":
                result = Integer.valueOf(fixedCostsDirectAd) + (Integer.valueOf(variableCostsDiscount) * Integer.valueOf(directAdCoverage));
                break;
            case "\"Direct Ad + Deferred Payment\"":
                result = Integer.valueOf(fixedCostsDirectAd) + (Integer.valueOf(variableCostsDelayed) * Integer.valueOf(directAdCoverage));
                break;
            case "\"Direct Ad + Deferred P. + Discount\"":
                result = Integer.valueOf(fixedCostsDirectAd) + (Integer.valueOf(variableCostsDelayedDiscount) * Integer.valueOf(directAdCoverage));
                break; 
            }
        return result;
    }

    public int calculateToTCost() {
        int result = Integer.valueOf(fixedCostsTrainChiefs) + (Integer.valueOf(variableCostsTrainChiefs) * Integer.valueOf(trainChiefsCoverage));
        return result;
    }

    public ArrayList<String> calculateNrOfInterventions() {
        ArrayList<String> results = new ArrayList<String>();
        int i = 0;
        int tmpBudget = Integer.valueOf(budget);
        int dirAdCounter = 0;
        int ToTCounter = 0;
        int dirAdCost = calculateDirAdCost();
        int ToTCost = calculateToTCost();


        while (i <= numberOfTicks) {
            if (Integer.valueOf(frequencyDirectAd) > 0 && i != numberOfTicks && i % Integer.valueOf(frequencyDirectAd) == 0) {
                if (dirAdCost <= tmpBudget) {
                    tmpBudget = tmpBudget - dirAdCost;
                    dirAdCounter++;
                }
            }

            if (Integer.valueOf(frequencyChiefTraining) > 0 && i != numberOfTicks && i % Integer.valueOf(frequencyChiefTraining) == 0) {
                if (ToTCost <= tmpBudget) {
                    tmpBudget = tmpBudget - ToTCost;
                    ToTCounter++;
                }

            if (dirAdCost > tmpBudget && ToTCost > tmpBudget) {
                break;
                }
            }
            i++;
        }
        results.add(String.valueOf(dirAdCounter));
        results.add(String.valueOf(ToTCounter));

        return results;
    }


    public String calculateTotalCost() {
        ArrayList<String> nrOfInterventions = calculateNrOfInterventions();
        int nrDirAds = Integer.valueOf(nrOfInterventions.get(0));
        int nrToT = Integer.valueOf(nrOfInterventions.get(1));
        int dirAdCost = calculateDirAdCost();
        int ToTCost= calculateToTCost();

        int totalCost = (nrDirAds * dirAdCost) + (nrToT * ToTCost);
        return Integer.toString(totalCost);
    }

    public String isModelInputValid(UserInput userInput) { // numberOfTicks, frequencyDirectAd, frequencyChiefTraining, typeDirectAd

        // frequencyDirectAd is not empty, integer, not negative
        try {
            Assert.hasText(userInput.getFrequencyDirectAd(), "frequencyDirectAd must not be empty");
            Assert.isTrue(userInput.getFrequencyDirectAd().matches("\\d+"), "getFrequencyDirectAd  must be a number greater or equal to 0. This number can't be a decimal.");
            int frequencyDirectAd = Integer.parseInt(userInput.getFrequencyDirectAd());
            Assert.isTrue(frequencyDirectAd >= 0 && frequencyDirectAd <= 365, "frequencyDirectAd must be larger or equal to 0 and smaller or equal to 365");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // frequencyChiefTraining is not empty, integer, not negative
        try {
            Assert.hasText(userInput.getFrequencyChiefTraining(), "frequencyChiefTraining must not be empty");
            Assert.isTrue(userInput.getFrequencyChiefTraining().matches("\\d+"), "frequencyChiefTraining must be a number greater or equal to 0. This number can't be a decimal.");
            int tempFrequencyChiefTraining = Integer.parseInt(userInput.getFrequencyChiefTraining());
            Assert.isTrue(tempFrequencyChiefTraining >= 0 && tempFrequencyChiefTraining <= 365, "frequencyChiefTraining must be larger or equal to 0 and smaller or equal to 365.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // directAdType is not empty and matches one of four possible string
        try {
            Assert.hasText(userInput.getDirectAdType(), "directAdType must not be empty");
            
            ArrayList<String> possible_interventions = new ArrayList<String>();
            possible_interventions.add("\"Direct Ad\"");
            possible_interventions.add("\"Direct Ad + Discount\"");
            possible_interventions.add("\"Direct Ad + Deferred Payment\"");
            possible_interventions.add("\"Direct Ad + Deferred P. + Discount\"");
            Assert.isTrue(possible_interventions.contains(userInput.getDirectAdType()), "directAdType must match one of the four possible interventions");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        System.out.println("parameters are correct");
        return "ok";
    }

    public String isGlobalInputValid(UserInput userInput) { //  budget, fixedCostsDirectAd, fixedCostsTrainChiefs, variableCostsDirectAd, variableCostsDiscount, variableCostsDelayed, variableCostsDelayedDiscount, variableCostsTrainChiefs

        // parameters are not empty, not negative
        try {
            Assert.hasText(userInput.getBudget(), "budget must not be empty");
            Assert.hasText(userInput.getFixedCostsDirectAd(), "fixedCostsDirectAd must not be empty");
            Assert.hasText(userInput.getFixedCostsTrainChiefs(), "fixedCostsTrainChiefs must not be empty");
            Assert.hasText(userInput.getVariableCostsDirectAd(), "variableCostsDirectAd must not be empty");
            Assert.hasText(userInput.getVariableCostsDiscount(), "variableCostsDiscount must not be empty");
            Assert.hasText(userInput.getVariableCostsDelayed(), "variableCostsDelayed imust not bes empty");
            Assert.hasText(userInput.getVariableCostsDelayedDiscount(), "variableCostsDelayedDiscount must not be empty");
            Assert.hasText(userInput.getVariableCostsTrainChiefs(), "variableCostsTrainChiefs must not be empty");
            Assert.hasText(userInput.getFarmersPerVillage(), "farmersPerVillage must not be empty");
            Assert.hasText(userInput.getNrOfVillages(), "nrOfVillages must not be empty");
            Assert.hasText(userInput.getNrOfNeighborhoods(), "nrOfNeighborhoods must not be empty");
            Assert.hasText(userInput.getPercentageOfFarmersInFarmgroup(), "percentageOfFarmersInFarmgroup must not be empty");

            Assert.isTrue(userInput.getNumberOfTicks() > 0, "numberOfTicks must be larger than 0");
            Assert.isTrue(userInput.getBudget().matches("\\d+(\\.\\d+)?"), "budget must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getFixedCostsDirectAd().matches("\\d+(\\.\\d+)?"), "fixedCostsDirectAd must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getFixedCostsTrainChiefs().matches("\\d+(\\.\\d+)?"), "fixedCostsTrainChiefs must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getVariableCostsDirectAd().matches("\\d+(\\.\\d+)?"), "variableCostsDirectAd must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getVariableCostsDiscount().matches("\\d+(\\.\\d+)?"), "variableCostsDiscount must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getVariableCostsDelayed().matches("\\d+(\\.\\d+)?"), "variableCostsDelayed must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getVariableCostsDelayedDiscount().matches("\\d+(\\.\\d+)?"), "variableCostsDelayedDiscount must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getVariableCostsTrainChiefs().matches("\\d+(\\.\\d+)?"), "variableCostsTrainChiefs  must be a number greater or equal to 0. Please use a dot as decimal separator.");
            Assert.isTrue(userInput.getFarmersPerVillage().matches("\\d+"), "farmersPerVillage must be a number greater or equal to 0. This number can't be a decimal.");
            Assert.isTrue(userInput.getNrOfVillages().matches("\\d+"), "nrOfVillages must be a number greater or equal to 0. This number can't be a decimal.");
            Assert.isTrue(userInput.getNrOfNeighborhoods().matches("\\d+"), "nrOfNeighborhoods must be a number greater or equal to 0. This number can't be a decimal.");
            Assert.isTrue(userInput.getPercentageOfFarmersInFarmgroup().matches("\\d+"), "frequencyChiefTraining must be a number greater or equal to 0. This number can't be a decimal.");
            
            int farmersInFarmgroup = Integer.parseInt(userInput.getPercentageOfFarmersInFarmgroup());
            Assert.isTrue(farmersInFarmgroup >= 0 && farmersInFarmgroup <= 100, "farmersInFarmgroup must lie between 0 and 100");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        
        return "ok";
    }

    public String isOptimizationInputValid(String optimizationInput) { // optimizationType
        
        // optimizationType is not empty and matches one of four possible string
        try {       
            Assert.hasText(optimizationInput, "optimizationType must not be empty");     
            ArrayList<String> possible_optimizations = new ArrayList<String>();
            possible_optimizations.add("maxAdopters");
            possible_optimizations.add("maxKnowledge");
            possible_optimizations.add("minCost");
            possible_optimizations.add("test");
            Assert.isTrue(possible_optimizations.contains(optimizationInput), "optimizationType must match one of the four possible types");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "ok";
    }
}
