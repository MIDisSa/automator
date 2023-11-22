package com.example.automator.helper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.util.Assert;


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

    public String isModelResultsValid(ModelResults modelResults) { // awareFarmers, adopters, nrOfDirectAds, nrOfChiefTrainings, totalCost, awareFarmersPerTick, adoptersPerTick      
        // no empty strings
        try {
        Assert.hasText(modelResults.getAwareFarmers(), "awareFarmers must not be empty");
        Assert.hasText(modelResults.getAdopters(), "adopters must not be empty");
        Assert.hasText(modelResults.getNrOfDirectAds(), "nrOfdirectAds must not be empty");
        Assert.hasText(modelResults.getNrOfChiefTrainings(), "nrOfChiefTrainings must not be empty");
        Assert.hasText(modelResults.getTotalCost(), "totalCost must not be empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // no empty arrays
        try {
            Assert.isTrue(!modelResults.getAwareFarmersPerTick().isEmpty(), "awareFarmersPerTick must not be empty");
            Assert.isTrue(!modelResults.getAdoptersPerTick().isEmpty(), "adoptersPerTick must not be empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        // all strings contain positive integers
        try {
            Assert.isTrue(modelResults.getAwareFarmers().matches("\\d+(\\.\\d+)?"), "awareFarmers must be a number greater or equal to 0");
            Assert.isTrue(modelResults.getAdopters().matches("\\d+(\\.\\d+)?"), "adopters must be a number greater or equal to 0");
            Assert.isTrue(modelResults.getNrOfDirectAds().matches("\\d+(\\.\\d+)?"), "nrOfDirectAds must be a number greater or equal to 0");
            Assert.isTrue(modelResults.getNrOfChiefTrainings().matches("\\d+(\\.\\d+)?"), "nrOfChiefTrainings must be a number greater or equal to 0");
            Assert.isTrue(modelResults.getTotalCost().matches("\\d+(\\.\\d+)?"), "totalCost must be a number greater or equal to 0");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        try {
            for (Double d : modelResults.getAwareFarmersPerTick()) {
                Assert.isTrue(d >= 0, "every item in awareFarmersPerTick must be a number larger or equal to 0");
            }
            for (Double d : modelResults.getAdoptersPerTick()) {
                Assert.isTrue(d >= 0, "every item in adoptersPerTick must be a number greater or equal to 0");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "ok";
    }
}
