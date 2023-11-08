package com.example.automator.helper;

import com.opencsv.bean.CsvBindByName;

public class OptimizationResults { 

    @CsvBindByName(column = "direct_ad_type*")
    private String direct_ad_type;

    @CsvBindByName(column = "direct_ad_frequency*")
    private String direct_ad_frequency;

    @CsvBindByName(column = "train_chiefs_frequency*")
    private String train_chiefs_frequency;

    @CsvBindByName(column = "direct_ad_nr_of_villages*")
    private String direct_ad_nr_of_villages;

    @CsvBindByName(column = "train_chiefs_nr*")
    private String train_chiefs_number;
    
    @CsvBindByName(column = "best-fitness-rechecked")
    private String best_fitness_rechecked;

    public String getDirectAdType() {
        return direct_ad_type.substring(1, direct_ad_type.length() - 1);
    }

    public String getDirectAdFrequency() {
        return direct_ad_frequency;
    }

    public String getTrainChiefsFrequency() {
        return train_chiefs_frequency;
    }

    public String getDirectAdNrOfVillages() {
        return direct_ad_nr_of_villages;
    }

    public String getTrainChiefsNumber() {
        return train_chiefs_number;
    }

    public String getBestFitness() {
        return best_fitness_rechecked;
    }
}
