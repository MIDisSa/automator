package com.example.automator.helper;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

public class ModelInput {
    private int numberOfTicks;
    private String frequencyDirectAd;
    private String frequencyChiefTraining;
    private String kindOfIntervention;
    private String trainChiefInfluence;
    private String nrDefaultFriendsInterVillage;
    private String stdNrDefaultFriendsInterVillage;
    private String avgIntraVillageInteractionFrequency;
    private String stdevIntraVillageInteractionFrequency;
    private String avgInterVillageInteractionFrequency;
    private String stdevInterVillageInteractionFrequency;
    private String avgChiefFarmerMeetingFrequency;
    private String avgIntraMentionPercentage;
    private String stdevIntraMentionPercentage;
    private String avgInterMentionPercentage;
    private String stdevInterMentionPercentage;
    private String percentageNegativeWoM;
    private String baseAdoptionProbability;

    public ModelInput() {
    }

    // getter
    public int getNumberOfTicks() {
        return numberOfTicks;
    }

    public String getFrequencyDirectAd() {
        return frequencyDirectAd;
    }

    public String getFrequencyChiefTraining() {
        return frequencyChiefTraining;
    }

    public String getKindOfIntervention() {
        return kindOfIntervention;
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

    // setter
    public void setNumberOfTicks(int numberOfTicks) {
        this.numberOfTicks = numberOfTicks;
    }

    public void setFrequencyDirectAd(String frequencyDirectAd) {
        this.frequencyDirectAd = frequencyDirectAd;
    }

    public void setKindOfIntervention(String kindOfIntervention) {
        this.kindOfIntervention = kindOfIntervention;
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

    public void setFrequencyChiefTraining(String frequencyChiefTraining) {
        this.frequencyChiefTraining = frequencyChiefTraining;
    }

    public static ResponseEntity<String> assertCorrectParameters(ModelInput modelInput) {
        // some parameters are not set in the model in runABM:
        // - trainChiefInfluence

        // some parameters are not present in the model:
        // - stdNrDefaultFriendsInterVillage
        // - stdevIntraVillageInteractionFrequency
        // - stdevInterVillageInteractionFrequency
        // - stdevIntraMentionPercentage
        // - stdevInterMentionPercentage

        // no differentiation between intra- and inter-mention percentage in model

        
        // nrOfTicks is not null, not negative
        try {
            Assert.notNull(modelInput.getNumberOfTicks(), "numberOfTicks is null");
            Assert.isTrue(modelInput.getNumberOfTicks() > 0, "numberOfTicks is zero or negative");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("numberOfTicks is null or negative");
        }
                
        // no empty strings
        try {
        Assert.hasText(modelInput.getFrequencyDirectAd(), "getFrequencyDirectAd is empty");
        Assert.hasText(modelInput.getFrequencyChiefTraining(), "frequencyChiefTraining is empty");
        Assert.hasText(modelInput.getKindOfIntervention(), "kindOfIntervention is empty");
        Assert.hasText(modelInput.getTrainChiefInfluence(), "trainChiefInfluence is empty");
        Assert.hasText(modelInput.getNrDefaultFriendsInterVillage(), "nrDefaultFriendsInterVillage is empty");
        Assert.hasText(modelInput.getStdNrDefaultFriendsInterVillage(), "stdNrDefaultFriendsInterVillage is empty");
        Assert.hasText(modelInput.getAvgIntraVillageInteractionFrequency(), "avgIntraVillageInteractionFrequency is empty");
        Assert.hasText(modelInput.getStdevIntraVillageInteractionFrequency(), "stdevIntraVillageInteractionFrequency is empty");
        Assert.hasText(modelInput.getAvgInterVillageInteractionFrequency(), "avgInterVillageInteractionFrequency is empty");
        Assert.hasText(modelInput.getStdevInterVillageInteractionFrequency(), "stdevInterVillageInteractionFrequency is empty");
        Assert.hasText(modelInput.getAvgChiefFarmerMeetingFrequency(), "avgChiefFarmerMeetingFrequency is empty");
        Assert.hasText(modelInput.getAvgIntraMentionPercentage(), "avgIntraMentionPercentage is empty");
        Assert.hasText(modelInput.getStdevIntraMentionPercentage(), "stdevIntraMentionPercentage is empty");
        Assert.hasText(modelInput.getAvgInterMentionPercentage(), "avgInterMentionPercentage is empty");
        Assert.hasText(modelInput.getStdevInterMentionPercentage(), "stdevInterMentionPercentage is empty");
        Assert.hasText(modelInput.getPercentageNegativeWoM(), "percentageNegativeWoM is empty");
        Assert.hasText(modelInput.getBaseAdoptionProbability(), "baseAdoptionProbability is empty");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("one or more parameters are empty");
        }

        // all strings are positive integers except for kindOfIntervention and baseAdoptionProbability
        try {
        Assert.isTrue(modelInput.getFrequencyDirectAd().matches("\\d+"), "getFrequencyDirectAd is not a positive integer");
        Assert.isTrue(modelInput.getFrequencyChiefTraining().matches("\\d+"), "frequencyChiefTraining is not a positive integer");
        Assert.isTrue(modelInput.getTrainChiefInfluence().matches("\\d+"), "trainChiefInfluence is not a positive integer");
        Assert.isTrue(modelInput.getNrDefaultFriendsInterVillage().matches("\\d+"), "nrDefaultFriendsInterVillage is not a positive integer");
        Assert.isTrue(modelInput.getStdNrDefaultFriendsInterVillage().matches("\\d+"), "stdNrDefaultFriendsInterVillage is not a positive integer");
        Assert.isTrue(modelInput.getAvgIntraVillageInteractionFrequency().matches("\\d+"), "avgIntraVillageInteractionFrequency is not a positive integer");
        Assert.isTrue(modelInput.getStdevIntraVillageInteractionFrequency().matches("\\d+"), "stdevIntraVillageInteractionFrequency is not a positive integer");
        Assert.isTrue(modelInput.getAvgInterVillageInteractionFrequency().matches("\\d+"), "avgInterVillageInteractionFrequency is not a positive integer");
        Assert.isTrue(modelInput.getStdevInterVillageInteractionFrequency().matches("\\d+"), "stdevInterVillageInteractionFrequency is not a positive integer");
        Assert.isTrue(modelInput.getAvgChiefFarmerMeetingFrequency().matches("\\d+"), "avgChiefFarmerMeetingFrequency is not a positive integer");
        Assert.isTrue(modelInput.getAvgIntraMentionPercentage().matches("\\d+"), "avgIntraMentionPercentage is not a positive integer");
        Assert.isTrue(modelInput.getStdevIntraMentionPercentage().matches("\\d+"), "stdevIntraMentionPercentage is not a positive integer");
        Assert.isTrue(modelInput.getAvgInterMentionPercentage().matches("\\d+"), "avgInterMentionPercentage is not a positive integer");
        Assert.isTrue(modelInput.getStdevInterMentionPercentage().matches("\\d+"), "stdevInterMentionPercentage is not a positive integer");
        Assert.isTrue(modelInput.getPercentageNegativeWoM().matches("\\d+"), "percentageNegativeWoM is not a positive integer");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("one or more parameter is not a positive integer");
        }

        // baseAdoptinoProbability is a double
        try {
            Assert.isTrue(modelInput.getBaseAdoptionProbability().matches("\\d+(\\.\\d+)?"), "baseAdoptionProbability is not a positive double");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("baseAdoptionProbability is not a positive double");
        }

        // kindOfIntervention exactly matches one out of four possible strings
        try {
        ArrayList<String> possible_interventions = new ArrayList<String>();
        possible_interventions.add("\"Direct Ad\"");
        possible_interventions.add("\"Direct Ad + Discount\"");
        possible_interventions.add("\"Direct Ad + Delayed Payment\"");
        possible_interventions.add("\"Direct Ad + Delayed P. + Discount\"");
        Assert.isTrue(possible_interventions.contains(modelInput.getKindOfIntervention()), "kindOfIntervention is not one of the four possible interventions");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("kindOfIntervention is not one of the four possible interventions");
        }

        // numbers are within range
        try {
            // convert strings to integers
            int frequencyDirectAd = Integer.parseInt(modelInput.getFrequencyDirectAd());
            int frequencyChiefTraining = Integer.parseInt(modelInput.getFrequencyChiefTraining());
            int nrDefaultFriendsInterVillage = Integer.parseInt(modelInput.getNrDefaultFriendsInterVillage());
            int avgIntraVillageInteractionFrequency = Integer.parseInt(modelInput.getAvgIntraVillageInteractionFrequency());
            int avgInterVillageInteractionFrequency = Integer.parseInt(modelInput.getAvgInterVillageInteractionFrequency());
            int avgChiefFarmerMeetingFrequency = Integer.parseInt(modelInput.getAvgChiefFarmerMeetingFrequency());
            int percentageNegativeWoM = Integer.parseInt(modelInput.getPercentageNegativeWoM());
            double baseAdoptionProbability = Double.parseDouble(modelInput.getBaseAdoptionProbability());

            // assert that numbers are within range
            Assert.isTrue(frequencyDirectAd >= 0 && frequencyDirectAd <= 365, "frequencyDirectAd is not within range");
            Assert.isTrue(frequencyChiefTraining >= 0 && frequencyChiefTraining <= 365, "frequencyChiefTraining is not within range");
            Assert.isTrue(nrDefaultFriendsInterVillage >= 1 && nrDefaultFriendsInterVillage <= 10, "nrDefaultFriendsInterVillage is not within range");
            Assert.isTrue(avgIntraVillageInteractionFrequency >= 1 && avgIntraVillageInteractionFrequency <= 10, "avgIntraVillageInteractionFrequency is not within range");
            Assert.isTrue(avgInterVillageInteractionFrequency >= 1 && avgInterVillageInteractionFrequency <= 10, "avgInterVillageInteractionFrequency is not within range");
            Assert.isTrue(avgChiefFarmerMeetingFrequency >= 1 && avgChiefFarmerMeetingFrequency <= 50, "avgChiefFarmerMeetingFrequency is not within range");
            Assert.isTrue(percentageNegativeWoM >= 0 && percentageNegativeWoM <= 100, "percentageNegativeWoM is not within range");
            Assert.isTrue(baseAdoptionProbability >= 0.1 && baseAdoptionProbability <= 100.0, "baseAdoptionProbability is not within range");

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("one or more parameters is not an integer or double");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("one or more parameters is not within range");
        }

        System.out.println("parameters are correct");
        return null;
    }
}
