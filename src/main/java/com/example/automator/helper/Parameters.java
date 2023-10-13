package com.example.automator.helper;

import com.opencsv.bean.CsvBindByName;

public class Parameters {

    @CsvBindByName
    private String train_chief_influence;

    @CsvBindByName
    private String nr_default_friends_inter_village;

    @CsvBindByName
    private String std_nr_default_friends_inter_village;

    @CsvBindByName
    private String avg_intra_village_interaction_frequency;

    @CsvBindByName
    private String stdev_intra_village_interaction_frequency;

    @CsvBindByName
    private String avg_inter_village_interaction_frequency;

    @CsvBindByName
    private String stdev_inter_village_interaction_frequency;

    @CsvBindByName
    private String avg_chief_farmer_meeting_frequency;

    @CsvBindByName
    private String avg_intra_mention_percentage;

    @CsvBindByName
    private String stdev_intra_mention_percentage;

    @CsvBindByName
    private String avg_inter_mention_percentage;

    @CsvBindByName
    private String stdev_inter_mention_percentage;

    @CsvBindByName
    private String percentage_negative_WoM;

    @CsvBindByName
    private String base_adoption_probability;

    /*
    Parameters(
        String train_chief_influence,
        String nr_default_friends_inter_village,
        String std_nr_default_friends_inter_village,
        String avg_intra_village_interaction_frequency,
        String stdev_intra_village_interaction_frequency,
        String avg_inter_village_interaction_frequency,
        String stdev_inter_village_interaction_frequency,
        String avg_chief_farmer_meeting_frequency,
        String avg_intra_mention_percentage,
        String stdev_intra_mention_percentage,
        String avg_inter_mention_percentage,
        String stdev_inter_mention_percentage,
        String percentage_negative_WoM,
        String base_adoption_probability) {
            this.train_chief_influence = train_chief_influence;
            this.nr_default_friends_inter_village = nr_default_friends_inter_village;
            this.std_nr_default_friends_inter_village = std_nr_default_friends_inter_village;
            this.avg_intra_village_interaction_frequency = avg_intra_village_interaction_frequency;
            this.stdev_intra_village_interaction_frequency = stdev_intra_village_interaction_frequency;
            this.avg_inter_village_interaction_frequency = avg_inter_village_interaction_frequency;
            this.stdev_inter_village_interaction_frequency = stdev_inter_village_interaction_frequency;
            this.avg_chief_farmer_meeting_frequency = avg_chief_farmer_meeting_frequency;
            this.avg_intra_mention_percentage = avg_intra_mention_percentage;
            this.stdev_intra_mention_percentage = stdev_intra_mention_percentage;
            this.avg_inter_mention_percentage = avg_inter_mention_percentage;
            this.stdev_inter_mention_percentage = stdev_inter_mention_percentage;
            this.percentage_negative_WoM = percentage_negative_WoM;
            this.base_adoption_probability = base_adoption_probability;
        } */

    // getters
    public String getTrainChiefInfluence() {
        return train_chief_influence;
    }

    public String getNrDefaultFriendsInterVillage() {
        return nr_default_friends_inter_village;
    }

    public String getStdNrDefaultFriendsInterVillage() {
        return std_nr_default_friends_inter_village;
    }

    public String getAvgIntraVillageInteractionFrequency() {
        return avg_intra_village_interaction_frequency;
    }

    public String getStdevIntraVillageInteractionFrequency() {
        return stdev_intra_village_interaction_frequency;
    }

    public String getAvgInterVillageInteractionFrequency() {
        return avg_inter_village_interaction_frequency;
    }

    public String getStdevInterVillageInteractionFrequency() {
        return stdev_inter_village_interaction_frequency;
    }

    public String getAvgChiefFarmerMeetingFrequency() {
        return avg_chief_farmer_meeting_frequency;
    }

    public String getAvgIntraMentionPercentage() {
        return avg_intra_mention_percentage;
    }

    public String getStdevIntraMentionPercentage() {
        return stdev_intra_mention_percentage;
    }

    public String getAvgInterMentionPercentage() {
        return avg_inter_mention_percentage;
    }

    public String getStdevInterMentionPercentage() {
        return stdev_inter_mention_percentage;
    }

    public String getPercentageNegativeWoM() {
        return percentage_negative_WoM;
    }

    public String getBaseAdoptionProbability() {
        return base_adoption_probability;
    }

    // setters
    public void setTrainChiefInfluence(String train_chief_influence) {
        this.train_chief_influence = train_chief_influence;
    }

    public void setNrDefaultFriendsInterVillage(String nr_default_friends_inter_village) {
        this.nr_default_friends_inter_village = nr_default_friends_inter_village;
    }

    public void setStdNrDefaultFriendsInterVillage(String std_nr_default_friends_inter_village) {
        this.std_nr_default_friends_inter_village = std_nr_default_friends_inter_village;
    }

    public void setAvgIntraVillageInteractionFrequency(String avg_intra_village_interaction_frequency) {
        this.avg_intra_village_interaction_frequency = avg_intra_village_interaction_frequency;
    }

    public void setStdevIntraVillageInteractionFrequency(String stdev_intra_village_interaction_frequency) {
        this.stdev_intra_village_interaction_frequency = stdev_intra_village_interaction_frequency;
    }

    public void setAvgInterVillageInteractionFrequency(String avg_inter_village_interaction_frequency) {
        this.avg_inter_village_interaction_frequency = avg_inter_village_interaction_frequency;
    }

    public void setStdevInterVillageInteractionFrequency(String stdev_inter_village_interaction_frequency) {
        this.stdev_inter_village_interaction_frequency = stdev_inter_village_interaction_frequency;
    }

    public void setAvgChiefFarmerMeetingFrequency(String avg_chief_farmer_meeting_frequency) {
        this.avg_chief_farmer_meeting_frequency = avg_chief_farmer_meeting_frequency;
    }

    public void setAvgIntraMentionPercentage(String avg_intra_mention_percentage) {
        this.avg_intra_mention_percentage = avg_intra_mention_percentage;
    }

    public void setStdevIntraMentionPercentage(String stdev_intra_mention_percentage) {
        this.stdev_intra_mention_percentage = stdev_intra_mention_percentage;
    }

    public void setAvgInterMentionPercentage(String avg_inter_mention_percentage) {
        this.avg_inter_mention_percentage = avg_inter_mention_percentage;
    }

    public void setStdevInterMentionPercentage(String stdev_inter_mention_percentage) {
        this.stdev_inter_mention_percentage = stdev_inter_mention_percentage;
    }

    public void setPercentageNegativeWoM(String percentage_negative_WoM) {
        this.percentage_negative_WoM = percentage_negative_WoM;
    }

    public void setBaseAdoptionProbability(String base_adoption_probability) {
        this.base_adoption_probability = base_adoption_probability;
    }
}
