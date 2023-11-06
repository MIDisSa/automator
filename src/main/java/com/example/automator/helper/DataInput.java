package com.example.automator.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

public class DataInput {
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

    public boolean isDataInputValid(DataInput dataInput) { // trainChiefInfluence, avgIntraMentionPercentage, percentageNegativeWoM, baseAdoptionProbability, nrDefaultFriendsInterVillage, avgIntraVillageInteractionFrequency, avgInterVillageInteractionFrequency, avgChiefFarmerMeetingFrequency
        
        // no empty strings
        try {
        Assert.hasText(dataInput.getTrainChiefInfluence(), "trainChiefInfluence is empty");
        Assert.hasText(dataInput.getNrDefaultFriendsInterVillage(), "nrDefaultFriendsInterVillage is empty");
        Assert.hasText(dataInput.getAvgIntraVillageInteractionFrequency(), "avgIntraVillageInteractionFrequency is empty");
        Assert.hasText(dataInput.getAvgInterVillageInteractionFrequency(), "avgInterVillageInteractionFrequency is empty");
        Assert.hasText(dataInput.getAvgChiefFarmerMeetingFrequency(), "avgChiefFarmerMeetingFrequency is empty");
        Assert.hasText(dataInput.getAvgIntraMentionPercentage(), "avgIntraMentionPercentage is empty");
        Assert.hasText(dataInput.getPercentageNegativeWoM(), "percentageNegativeWoM is empty");
        Assert.hasText(dataInput.getBaseAdoptionProbability(), "baseAdoptionProbability is empty");
        } catch (IllegalArgumentException e) {
            return false;
        }

        // no negative numbers except for baseAdoptionProbability
        try {
        Assert.isTrue(dataInput.getTrainChiefInfluence().matches("\\d+"), "trainChiefInfluence is not a positive integer");
        Assert.isTrue(dataInput.getNrDefaultFriendsInterVillage().matches("\\d+"), "nrDefaultFriendsInterVillage is is not a positive integer");
        Assert.isTrue(dataInput.getAvgIntraVillageInteractionFrequency().matches("\\d+"), "avgIntraVillageInteractionFrequency is is not a positive integer");
        Assert.isTrue(dataInput.getAvgInterVillageInteractionFrequency().matches("\\d+"), "avgInterVillageInteractionFrequency is is not a positive integer");
        Assert.isTrue(dataInput.getAvgChiefFarmerMeetingFrequency().matches("\\d+"), "avgChiefFarmerMeetingFrequency is is not a positive integer");
        Assert.isTrue(dataInput.getAvgIntraMentionPercentage().matches("\\d+"), "avgIntraMentionPercentage is is not a positive integer");
        Assert.isTrue(dataInput.getPercentageNegativeWoM().matches("\\d+"), "percentageNegativeWoM is is not a positive integer");
        Assert.isTrue(dataInput.getBaseAdoptionProbability().matches("\\d+"), "baseAdoptionProbability is is not a positive integer");
        } catch (IllegalArgumentException e) {
            return false;
        }

        // baseAdoptinoProbability is a double
        try {
            Assert.isTrue(dataInput.getBaseAdoptionProbability().matches("\\d+(\\.\\d+)?"), "baseAdoptionProbability is not a positive double");
        } catch (IllegalArgumentException e) {
            return false;
        }

        // numbers are within range
        try {
            // convert strings to integers
            int nrDefaultFriendsInterVillage = Integer.parseInt(dataInput.getNrDefaultFriendsInterVillage());
            int avgIntraVillageInteractionFrequency = Integer.parseInt(dataInput.getAvgIntraVillageInteractionFrequency());
            int avgInterVillageInteractionFrequency = Integer.parseInt(dataInput.getAvgInterVillageInteractionFrequency());
            int avgChiefFarmerMeetingFrequency = Integer.parseInt(dataInput.getAvgChiefFarmerMeetingFrequency());
            int percentageNegativeWoM = Integer.parseInt(dataInput.getPercentageNegativeWoM());
            int trainChiefInfluence = Integer.parseInt(dataInput.getTrainChiefInfluence());
            int avgIntraMentionPercentage = Integer.parseInt(dataInput.getAvgIntraMentionPercentage());
            double baseAdoptionProbability = Double.parseDouble(dataInput.getBaseAdoptionProbability());

            // assert that numbers are within range
            Assert.isTrue(nrDefaultFriendsInterVillage >= 1 && nrDefaultFriendsInterVillage <= 10, "nrDefaultFriendsInterVillage is not within range");
            Assert.isTrue(avgIntraVillageInteractionFrequency >= 1 && avgIntraVillageInteractionFrequency <= 10, "avgIntraVillageInteractionFrequency is not within range");
            Assert.isTrue(avgInterVillageInteractionFrequency >= 1 && avgInterVillageInteractionFrequency <= 10, "avgInterVillageInteractionFrequency is not within range");
            Assert.isTrue(avgChiefFarmerMeetingFrequency >= 1 && avgChiefFarmerMeetingFrequency <= 50, "avgChiefFarmerMeetingFrequency is not within range");
            Assert.isTrue(percentageNegativeWoM >= 0 && percentageNegativeWoM <= 100, "percentageNegativeWoM is not within range");
            //TODO: trainChiefInfluence and avgIntraMentionPercentage
            Assert.isTrue(baseAdoptionProbability >= 0.1 && baseAdoptionProbability <= 100.0, "baseAdoptionProbability is not within range");

        } catch (NumberFormatException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }
}
