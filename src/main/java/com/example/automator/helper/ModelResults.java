package com.example.automator.helper;

public class ModelResults {
    private String awareFarmers;
    private String adopters;
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

    public String getAwareFarmersPerTick() {
        return awareFarmersPerTick;
    }

    public String getAdoptersPerTick() {
        return adoptersPerTick;
    }
}