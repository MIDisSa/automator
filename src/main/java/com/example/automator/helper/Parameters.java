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
}
