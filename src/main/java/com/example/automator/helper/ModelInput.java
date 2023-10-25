package com.example.automator.helper;

public class ModelInput {
    //Model parameters:
    private int numberOfTicks = 360;
    private String trainChiefInfluence = "175";
    private String nrDefaultFriendsInterVillage = "5";
    private String stdNrDefaultFriendsInterVillage = "1";
    private String avgIntraVillageInteractionFrequency = "4";
    private String stdevIntraVillageInteractionFrequency = "1";
    private String avgInterVillageInteractionFrequency = "5";
    private String stdevInterVillageInteractionFrequency = "1";
    private String avgChiefFarmerMeetingFrequency = "30";
    private String avgIntraMentionPercentage = "1";
    private String stdevIntraMentionPercentage = "1";
    private String avgInterMentionPercentage = "1";
    private String stdevInterMentionPercentage = "1";
    private String percentageNegativeWoM = "10";
    private String baseAdoptionProbability = "1";

    //Optimization parameters:
    private String frequencyDirectAd;
    private String frequencyChiefTraining;
    private String directAdType;
    private String budget;
    private String directAdNrOfVillages;
    private String trainChiefsNr;

    public ModelInput() {
    }

    // GETTER (Model Parameters)
    public int getNumberOfTicks() {
        return numberOfTicks;
    }

    public String getTrainChiefInfluence() {
        return trainChiefInfluence;
    }

    public String getNrDefaultFriendsInterVillage() {
        return nrDefaultFriendsInterVillage;
    }

    public String getStdNrDefaultFriendsInterVillage() {
        return stdNrDefaultFriendsInterVillage;
    }

    public String getAvgIntraVillageInteractionFrequency() {
        return avgIntraVillageInteractionFrequency;
    }

    public String getStdevIntraVillageInteractionFrequency() {
        return stdevIntraVillageInteractionFrequency;
    }

    public String getAvgInterVillageInteractionFrequency() {
        return avgInterVillageInteractionFrequency;
    }

    public String getStdevInterVillageInteractionFrequency() {
        return stdevInterVillageInteractionFrequency;
    }

    public String getAvgChiefFarmerMeetingFrequency() {
        return avgChiefFarmerMeetingFrequency;
    }

    public String getAvgIntraMentionPercentage() {
        return avgIntraMentionPercentage;
    }

    public String getStdevIntraMentionPercentage() {
        return stdevIntraMentionPercentage;
    }

    public String getAvgInterMentionPercentage() {
        return avgInterMentionPercentage;
    }

    public String getStdevInterMentionPercentage() {
        return stdevInterMentionPercentage;
    }

    public String getPercentageNegativeWoM() {
        return percentageNegativeWoM;
    }

    public String getBaseAdoptionProbability() {
        return baseAdoptionProbability;
    }


    //GETTER (Optimization Parameters)
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

    // SETTER (Model Parameters)
    public void setNumberOfTicks(int numberOfTicks) {
        this.numberOfTicks = numberOfTicks;
    }

    public void setTrainChiefInfluence(String trainChiefInfluence) {
        this.trainChiefInfluence = trainChiefInfluence;
    }

    public void setNrDefaultFriendsInterVillage(String nrDefaultFriendsInterVillage) {
        this.nrDefaultFriendsInterVillage = nrDefaultFriendsInterVillage;
    }

    public void setStdNrDefaultFriendsInterVillage(String stdNrDefaultFriendsInterVillage) {
        this.stdNrDefaultFriendsInterVillage = stdNrDefaultFriendsInterVillage;
    }

    public void setAvgIntraVillageInteractionFrequency(String avgIntraVillageInteractionFrequency) {
        this.avgIntraVillageInteractionFrequency = avgIntraVillageInteractionFrequency;
    }

    public void setStdevIntraVillageInteractionFrequency(String stdevIntraVillageInteractionFrequency) {
        this.stdevIntraVillageInteractionFrequency = stdevIntraVillageInteractionFrequency;
    }

    public void setAvgInterVillageInteractionFrequency(String avgInterVillageInteractionFrequency) {
        this.avgInterVillageInteractionFrequency = avgInterVillageInteractionFrequency;
    }

    public void setStdevInterVillageInteractionFrequency(String stdevInterVillageInteractionFrequency) {
        this.stdevInterVillageInteractionFrequency = stdevInterVillageInteractionFrequency;
    }

    public void setAvgChiefFarmerMeetingFrequency(String avgChiefFarmerMeetingFrequency) {
        this.avgChiefFarmerMeetingFrequency = avgChiefFarmerMeetingFrequency;
    }

    public void setAvgIntraMentionPercentage(String avgIntraMentionPercentage) {
        this.avgIntraMentionPercentage = avgIntraMentionPercentage;
    }

    public void setStdevIntraMentionPercentage(String stdevIntraMentionPercentage) {
        this.stdevIntraMentionPercentage = stdevIntraMentionPercentage;
    }

    public void setAvgInterMentionPercentage(String avgInterMentionPercentage) {
        this.avgInterMentionPercentage = avgInterMentionPercentage;
    }

    public void setStdevInterMentionPercentage(String stdevInterMentionPercentage) {
        this.stdevInterMentionPercentage = stdevInterMentionPercentage;
    }

    public void setPercentageNegativeWoM(String percentageNegativeWoM) {
        this.percentageNegativeWoM = percentageNegativeWoM;
    }

    public void setBaseAdoptionProbability(String baseAdoptionProbability) {
        this.baseAdoptionProbability = baseAdoptionProbability;
    }

    
    //SETTER (Optimization Parameters)
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

    public void setTrainChiefInfluence(String trainChiefInfluence) {
        this.trainChiefInfluence = trainChiefInfluence;
    }

    public void setNrDefaultFriendsInterVillage(String nrDefaultFriendsInterVillage) {
        this.nrDefaultFriendsInterVillage = nrDefaultFriendsInterVillage;
    }

    public void setStdNrDefaultFriendsInterVillage(String stdNrDefaultFriendsInterVillage) {
        this.stdNrDefaultFriendsInterVillage = stdNrDefaultFriendsInterVillage;
    }

    public void setAvgIntraVillageInteractionFrequency(String avgIntraVillageInteractionFrequency) {
        this.avgIntraVillageInteractionFrequency = avgIntraVillageInteractionFrequency;
    }

    public void setStdevIntraVillageInteractionFrequency(String stdevIntraVillageInteractionFrequency) {
        this.stdevIntraVillageInteractionFrequency = stdevIntraVillageInteractionFrequency;
    }

    public void setAvgInterVillageInteractionFrequency(String avgInterVillageInteractionFrequency) {
        this.avgInterVillageInteractionFrequency = avgInterVillageInteractionFrequency;
    }

    public void setStdevInterVillageInteractionFrequency(String stdevInterVillageInteractionFrequency) {
        this.stdevInterVillageInteractionFrequency = stdevInterVillageInteractionFrequency;
    }

    public void setAvgChiefFarmerMeetingFrequency(String avgChiefFarmerMeetingFrequency) {
        this.avgChiefFarmerMeetingFrequency = avgChiefFarmerMeetingFrequency;
    }

    public void setAvgIntraMentionPercentage(String avgIntraMentionPercentage) {
        this.avgIntraMentionPercentage = avgIntraMentionPercentage;
    }
}