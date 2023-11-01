package com.example.automator.helper;

public class OptimizationOutput {
    private String directAdType;
    private String directAdFrequency;
    private String trainChiefsFrequency;
    private String directAdNrOfVillages;
    private String trainChiefsNumber;
    private String avgAdopters;

    private String nrOfDirectAds;
    private String nrOfChiefTrainings;
    private String totalCost;


    public OptimizationOutput(OptimizationResults optRes, ModelResults modRes) {
            this.directAdType = optRes.getDirectAdType();
            this.directAdFrequency = optRes.getDirectAdFrequency();
            this.trainChiefsFrequency = optRes.getTrainChiefsFrequency();
            this.directAdNrOfVillages = optRes.getDirectAdNrOfVillages();
            this.trainChiefsNumber = optRes.getTrainChiefsNumber();
            this.avgAdopters = optRes.getBestFitness();
            this.nrOfDirectAds = modRes.getNrOfDirectAds();
            this.nrOfChiefTrainings = modRes.getNrOfChiefTrainings();
            this.totalCost = modRes.getTotalCost();
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

    public String getAvgAdopters() {
        return avgAdopters;
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

    public void setAvgAdopters(String avgAdopters) {
        this.avgAdopters = avgAdopters;
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
}
