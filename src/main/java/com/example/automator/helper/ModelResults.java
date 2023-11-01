package com.example.automator.helper;
import java.util.ArrayList;


public class ModelResults {
    private String awareFarmers;
    private String adopters;
    private String nrOfDirectAds;
    private String nrOfChiefTrainings;
    private String totalCost;
    private String awareFarmersPerTick;
    private String adoptersPerTick;

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

    public void setAwareFarmersPerTick(String awareFarmersPerTick) {
        this.awareFarmersPerTick = awareFarmersPerTick;
    }

    public void setAdoptersPerTick(String adoptersPerTick) {
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

    public String getAwareFarmersPerTick() {
        return awareFarmersPerTick;
    }

    public String getAdoptersPerTick() {
        return adoptersPerTick;
    }

    public ModelResults saveABMRunnerOutput(ArrayList<String> list) {
        this.awareFarmers = list.get(0);
        this.adopters = list.get(1);
        this.nrOfDirectAds = list.get(2);
        this.nrOfChiefTrainings = list.get(3);
        this.totalCost = list.get(4);
        this.awareFarmersPerTick = list.get(5);
        this.adoptersPerTick = list.get(6);

        return this;
    }
}
