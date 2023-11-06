package com.example.automator.helper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.util.Assert;

import ch.qos.logback.core.model.Model;


public class ModelResults {
    private String awareFarmers;
    private String adopters;
    private String nrOfDirectAds;
    private String nrOfChiefTrainings;
    private String totalCost;
    private ArrayList<Double> awareFarmersPerTick;
    private ArrayList<Double> adoptersPerTick;

    public ModelResults() {
    }

    public void setAwareFarmers(String awareFarmers) {
        this.awareFarmers = awareFarmers;
    }

    public void setAdopters(String adopters) {
        this.adopters = adopters;
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

    public void setAwareFarmersPerTick(ArrayList<Double> awareFarmersPerTick) {
        this.awareFarmersPerTick = awareFarmersPerTick;
    }

    public void setAdoptersPerTick(ArrayList<Double> adoptersPerTick) {
        this.adoptersPerTick = adoptersPerTick;
    }

    public String getAwareFarmers() {
        return awareFarmers;
    }

    public String getAdopters() {
        return adopters;
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

    public ArrayList<Double> getAwareFarmersPerTick() {
        return awareFarmersPerTick;
    }

    public ArrayList<Double> getAdoptersPerTick() {
        return adoptersPerTick;
    }

    public ModelResults saveABMRunnerOutput(ArrayList<String> list) {
        this.awareFarmers = list.get(0);
        this.adopters = list.get(1);
        this.nrOfDirectAds = list.get(2);
        this.nrOfChiefTrainings = list.get(3);
        this.totalCost = list.get(4);

        ArrayList<Double> awareFarmersPerTickArray = convertToArrayList(list.get(5));
        this.awareFarmersPerTick = awareFarmersPerTickArray;

        ArrayList<Double> adoptersPerTickArray = convertToArrayList(list.get(6));
        this.adoptersPerTick = adoptersPerTickArray;

        return this;
    }

    public ArrayList<Double> convertToArrayList(String string) {
        ArrayList<Double> list = new ArrayList<Double>();

        // replace brackets in string
        String replace = string.replace("[", "");
        String replaceAgain = replace.replace("]", "");

        // split string on comma
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(replaceAgain.split(",")));

        // convert string to double and add to list
        for (String s : stringList) {
            list.add(Double.parseDouble(s));
        }
        
        return list;
    }

    public boolean isModelResultsValid(ModelResults modelResults) { // awareFarmers, adopters, nrOfDirectAds, nrOfChiefTrainings, totalCost, awareFarmersPerTick, adoptersPerTick      
        // no empty strings
        try {
        Assert.hasText(modelResults.getAwareFarmers(), "awareFarmers is empty");
        Assert.hasText(modelResults.getAdopters(), "adopters is empty");
        Assert.hasText(modelResults.getNrOfDirectAds(), "nrOfdirectAds is empty");
        Assert.hasText(modelResults.getNrOfChiefTrainings(), "nrOfChiefTrainings is empty");
        Assert.hasText(modelResults.getTotalCost(), "totalCost is empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // no empty arrays
        try {
            Assert.isTrue(!modelResults.getAwareFarmersPerTick().isEmpty(), "awareFarmersPerTick is empty");
            Assert.isTrue(!modelResults.getAdoptersPerTick().isEmpty(), "adoptersPerTick is empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // all strings contain positive integers
        try {
            Assert.isTrue(modelResults.getAwareFarmers().matches("\\d+(\\.\\d+)?"), "awareFarmers is not a positive double");
            Assert.isTrue(modelResults.getAdopters().matches("\\d+(\\.\\d+)?"), "adopters is not a positive double");
            Assert.isTrue(modelResults.getNrOfDirectAds().matches("\\d+(\\.\\d+)?"), "nrOfDirectAds is not a positive double");
            Assert.isTrue(modelResults.getNrOfChiefTrainings().matches("\\d+(\\.\\d+)?"), "nrOfChiefTrainings is not a positive double");
            Assert.isTrue(modelResults.getTotalCost().matches("\\d+(\\.\\d+)?"), "totalCost is not a positive double");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        try {
            for (Double d : modelResults.getAwareFarmersPerTick()) {
                Assert.isTrue(d >= 0, "awareFarmersPerTick contains negative numbers");
            }
            for (Double d : modelResults.getAdoptersPerTick()) {
                Assert.isTrue(d >= 0, "adoptersPerTick contains negative numbers");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
