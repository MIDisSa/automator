package com.example.automator.helper;

import java.util.ArrayList;

import org.springframework.util.Assert;

public class OptimizationOutput {
    private String optimizationType;
    private String directAdType;
    private String directAdFrequency;
    private String trainChiefsFrequency;
    private String directAdNrOfVillages;
    private String trainChiefsNumber;
    private String bestFitness;

    private String nrOfDirectAds;
    private String nrOfChiefTrainings;
    private String totalCost;


    public OptimizationOutput(OptimizationResults optRes, UserInput userInput) {
            this.directAdType = optRes.getDirectAdType();
            this.directAdFrequency = optRes.getDirectAdFrequency();
            this.trainChiefsFrequency = optRes.getTrainChiefsFrequency();
            this.directAdNrOfVillages = optRes.getDirectAdNrOfVillages();
            this.trainChiefsNumber = optRes.getTrainChiefsNumber();

            Double fitness = Double.valueOf(optRes.getBestFitness());
            this.bestFitness = String.valueOf(Math.floor(fitness * 10) / 10);

            ArrayList<String> nrOfInterventions = userInput.calculateNrOfInterventions();
            this.nrOfDirectAds = nrOfInterventions.get(0);
            this.nrOfChiefTrainings = nrOfInterventions.get(1);
            this.totalCost = userInput.calculateTotalCost();
    }
    

    public String getOptimizationType() {
        return optimizationType;
    }

    public String getDirectAdType() {
        return directAdType;
    }

    public String getDirectAdFrequency() {
        return directAdFrequency;
    }

    public String getTrainChiefsFrequency() {
        return trainChiefsFrequency;
    }

    public String getDirectAdNrOfVillages() {
        return directAdNrOfVillages;
    }

    public String getTrainChiefsNumber() {
        return trainChiefsNumber;
    }

    public String getBestFitness() {
        return bestFitness;
    }

    public String getNrOfDirectAds() {
        return nrOfDirectAds;
    }

    public String getNrOfChiefTrainings() {
        return nrOfChiefTrainings;
    }

    public String getTotalCost() {
        return totalCost;
    }

    
    public void setOptimizationType(String optimizationType) {
        this.optimizationType = optimizationType;
    }

    public void setDirectAdType(String directAdType) {
        this.directAdType = directAdType;
    }

    public void setDirectAdFrequency(String directAdFrequency) {
        this.directAdFrequency = directAdFrequency;
    }

    public void setTrainChiefsFrequency(String trainChiefsFrequency) {
        this.trainChiefsFrequency = trainChiefsFrequency;
    }

    public void setDirectAdNrOfVillages(String directAdNrOfVillages) {
        this.directAdNrOfVillages = directAdNrOfVillages;
    }

    public void setTrainChiefsNumber(String trainChiefsNumber) {
        this.trainChiefsNumber = trainChiefsNumber;
    }

    public void setBestFitness(String bestFitness) {
        this.bestFitness = bestFitness;
    }

    public void setNrOfDirectAds(String nrOfDirectAds) {
        this.nrOfDirectAds = nrOfDirectAds;
    }

    public void setNrOfChiefTrainings(String nrOfChiefTrainings) {
        this.nrOfChiefTrainings = nrOfChiefTrainings;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String isOptimizationResultValid(OptimizationOutput optimizationOutput) { // directAdType, directAdFrequency, trainChiefsFrequency, directAdNrOfVillages, trainChiefsNumber, avgAdopters, nrOfDirectAds, nrOfChiefTrainings, totalCost

        // directAdType is not empty and matches one of four possible string
        try {
            Assert.hasText(optimizationOutput.getDirectAdType(), "directAdType must not be empty");
            
            ArrayList<String> possible_interventions = new ArrayList<String>();
            possible_interventions.add("Direct Ad");
            possible_interventions.add("Direct Ad + Discount");
            possible_interventions.add("Direct Ad + Deferred Payment");
            possible_interventions.add("Direct Ad + Deferred P. + Discount");
            Assert.isTrue(possible_interventions.contains(optimizationOutput.getDirectAdType()), "directAdType must be one of the four possible interventions");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // directAdFrequency is not empty, integer, not negative
        try {
            Assert.hasText(optimizationOutput.getDirectAdFrequency(), "directAdFrequency must not be empty");
            Assert.isTrue(optimizationOutput.getDirectAdFrequency().matches("\\d+"), "directAdFrequency must be a whole number greater than or equal to 0");
            int directAdFrequency = Integer.parseInt(optimizationOutput.getDirectAdFrequency());
            Assert.isTrue(directAdFrequency >= 0 && directAdFrequency <= 365, "directAdFrequency must lie between 0 and 365");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // trainChiefsFrequency is not empty, integer, not negative
        try {
            Assert.hasText(optimizationOutput.getTrainChiefsFrequency(), "trainChiefsFrequency must not be empty");
            Assert.isTrue(optimizationOutput.getTrainChiefsFrequency().matches("\\d+"), "trainChiefsFrequency must be a whole number greater than or equal to 0");
            int tempTrainChiefsFrequency = Integer.parseInt(optimizationOutput.getTrainChiefsFrequency());
            Assert.isTrue(tempTrainChiefsFrequency >= 0 && tempTrainChiefsFrequency <= 365, "trainChiefsFrequency must lie between 0 and 365");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // directAdNrOfVillages is not empty, integer, not negative
        try {
            Assert.hasText(optimizationOutput.getDirectAdNrOfVillages(), "directAdNrOfVillages must not be empty");
            Assert.isTrue(optimizationOutput.getDirectAdNrOfVillages().matches("\\d+"), "directAdNrOfVillages must be a whole number greater than or equal to 0");
            int tempDirectAdNrOfVillages = Integer.parseInt(optimizationOutput.getDirectAdNrOfVillages());
            Assert.isTrue(tempDirectAdNrOfVillages >= 0 && tempDirectAdNrOfVillages <= 100, "directAdNrOfVillages must lie between 0 and 100");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // trainChiefsNumber is not empty, integer, not negative
        try {
            Assert.hasText(optimizationOutput.getTrainChiefsNumber(), "trainChiefsNumber must not be empty");
            Assert.isTrue(optimizationOutput.getTrainChiefsNumber().matches("\\d+"), "trainChiefsNumber must be a whole number greater than or equal to 0");
            int tempTrainChiefsNumber = Integer.parseInt(optimizationOutput.getTrainChiefsNumber());
            Assert.isTrue(tempTrainChiefsNumber >= 0 && tempTrainChiefsNumber <= 100, "trainChiefsNumber must lie between 0 and 100");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // avgAdopters is not empty, double, not negative
        try {
            Assert.hasText(optimizationOutput.getBestFitness(), "avgAdopters must not be empty");
            Assert.isTrue(optimizationOutput.getBestFitness().matches("\\d+(\\.\\d+)?"), "avgAdopters must be a number greater than or equal to 0");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // nrOfDirectAds is not empty, double, not negative
        try {
            Assert.hasText(optimizationOutput.getNrOfDirectAds(), "nrOfDirectAds must not be empty");
            Assert.isTrue(optimizationOutput.getNrOfDirectAds().matches("\\d+(\\.\\d+)?"), "nrOfDirectAds must be a number greater than or equal to 0");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // nrOfChiefTrainings is not empty, double, not negative
        try {
            Assert.hasText(optimizationOutput.getNrOfChiefTrainings(), "nrOfChiefTrainings must not be empty");
            Assert.isTrue(optimizationOutput.getNrOfChiefTrainings().matches("\\d+(\\.\\d+)?"), "nrOfChiefTrainings must be a number greater than or equal to 0");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // totalCost is not empty, double, not negative
        try {
            Assert.hasText(optimizationOutput.getTotalCost(), "totalCost must not be empty");
            Assert.isTrue(optimizationOutput.getTotalCost().matches("\\d+(\\.\\d+)?"), "totalCost must be a number greater than or equal to 0");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "ok";
    }
}
