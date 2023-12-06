package com.example.automator.helper;

import org.springframework.util.Assert;

public class DataInput {
    private String trainChiefInfluence = "1.75";
    private String nrDefaultFriendsInterVillage = "5";
    private String stdNrDefaultFriendsInterVillage = "1";
    private String avgIntraVillageInteractionFrequency = "4";
    private String stdevIntraVillageInteractionFrequency = "1";
    private String avgInterVillageInteractionFrequency = "5";
    private String stdevInterVillageInteractionFrequency = "1";
    private String avgChiefFarmerMeetingFrequency = "30";
    private String avgIntraMentionPercentage = "2";
    private String stdevIntraMentionPercentage = "1";
    private String avgInterMentionPercentage = "1";
    private String stdevInterMentionPercentage = "1";
    private String percentageNegativeWoM = "10";
    private String baseAdoptionProbability = "1";
    

    //GETTER:
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

    //SETTER:
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

    public String isDataInputValid(DataInput dataInput) { // avgIntraMentionPercentage, percentageNegativeWoM, baseAdoptionProbability, nrDefaultFriendsInterVillage, avgIntraVillageInteractionFrequency, avgInterVillageInteractionFrequency, avgChiefFarmerMeetingFrequency

        // no empty strings
        try {
        Assert.hasText(dataInput.getNrDefaultFriendsInterVillage(), "nrDefaultFriendsInterVillage must not be empty");
        Assert.hasText(dataInput.getAvgIntraVillageInteractionFrequency(), "avgIntraVillageInteractionFrequency must not be empty");
        Assert.hasText(dataInput.getAvgInterVillageInteractionFrequency(), "avgInterVillageInteractionFrequency must not be empty");
        Assert.hasText(dataInput.getAvgChiefFarmerMeetingFrequency(), "avgChiefFarmerMeetingFrequency must not be empty");
        Assert.hasText(dataInput.getAvgIntraMentionPercentage(), "avgIntraMentionPercentage must not be empty");
        Assert.hasText(dataInput.getPercentageNegativeWoM(), "percentageNegativeWoM must not be empty");
        Assert.hasText(dataInput.getBaseAdoptionProbability(), "baseAdoptionProbability must not be empty");
        Assert.hasText(dataInput.getTrainChiefInfluence(), "trainChiefInfluence must not be empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // numbers are positive doubles
        try {
        Assert.isTrue(dataInput.getNrDefaultFriendsInterVillage().matches("\\d+(\\.\\d+)?"), "nrDefaultFriendsInterVillage must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getAvgIntraVillageInteractionFrequency().matches("\\d+(\\.\\d+)?"), "avgIntraVillageInteractionFrequency must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getAvgInterVillageInteractionFrequency().matches("\\d+(\\.\\d+)?"), "avgInterVillageInteractionFrequency must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getAvgChiefFarmerMeetingFrequency().matches("\\d+(\\.\\d+)?"), "avgChiefFarmerMeetingFrequency must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getPercentageNegativeWoM().matches("\\d+(\\.\\d+)?"), "percentageNegativeWoM must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getBaseAdoptionProbability().matches("\\d+(\\.\\d+)?"), "baseAdoptionProbability must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getBaseAdoptionProbability().matches("\\d+(\\.\\d+)?"), "baseAdoptionProbability must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getAvgIntraMentionPercentage().matches("\\d+(\\.\\d+)?"), "avgIntraMentionPercentage must be a number greater or equal to 0. Please use a dot as decimal separator.");
        Assert.isTrue(dataInput.getTrainChiefInfluence().matches("\\d+(\\.\\d+)?"), "trainChiefInfluence must be a number greater or equal to 0. Please use a dot as decimal separator.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // numbers are within range
        try {
            // convert strings to integers
            //double nrDefaultFriendsInterVillage = Double.parseDouble(dataInput.getNrDefaultFriendsInterVillage());
            //double avgIntraVillageInteractionFrequency = Double.parseDouble(dataInput.getAvgIntraVillageInteractionFrequency());
            //double avgInterVillageInteractionFrequency = Double.parseDouble(dataInput.getAvgInterVillageInteractionFrequency());
            //double avgChiefFarmerMeetingFrequency = Double.parseDouble(dataInput.getAvgChiefFarmerMeetingFrequency());
            double percentageNegativeWoM = Double.parseDouble(dataInput.getPercentageNegativeWoM());
            double avgIntraMentionPercentage = Double.parseDouble(dataInput.getAvgIntraMentionPercentage());
            double baseAdoptionProbability = Double.parseDouble(dataInput.getBaseAdoptionProbability());

            // assert that numbers are within range
            //Assert.isTrue(nrDefaultFriendsInterVillage >= 1.0 && nrDefaultFriendsInterVillage <= 10.0, "nrDefaultFriendsInterVillage is not within range");
            //Assert.isTrue(avgIntraVillageInteractionFrequency >= 1.0 && avgIntraVillageInteractionFrequency <= 10.0, "avgIntraVillageInteractionFrequency is not within range");
            //Assert.isTrue(avgInterVillageInteractionFrequency >= 1.0 && avgInterVillageInteractionFrequency <= 10.0, "avgInterVillageInteractionFrequency is not within range");
            //Assert.isTrue(avgChiefFarmerMeetingFrequency >= 1.0 && avgChiefFarmerMeetingFrequency <= 50.0, "avgChiefFarmerMeetingFrequency is not within range");
            Assert.isTrue(percentageNegativeWoM >= 0.0 && percentageNegativeWoM <= 100.0, "percentageNegativeWoM must be a number between 0 and 100");
            Assert.isTrue(avgIntraMentionPercentage >= 0.0 && avgIntraMentionPercentage <= 100.0, "avgIntraMentionPercentage must be a number between 0 and 100");
            Assert.isTrue(baseAdoptionProbability >= 0.001 && baseAdoptionProbability <= 100.0, "baseAdoptionProbability must be a number between 0.1 and 100");
        
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "ok";
    }
}
