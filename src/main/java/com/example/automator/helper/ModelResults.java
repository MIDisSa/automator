package com.example.automator.helper;
import java.util.ArrayList;
import java.util.Arrays;


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
}
