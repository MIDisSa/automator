package com.example.automator.helper;

import org.nlogo.headless.HeadlessWorkspace;

public class ResultsInterpreter {
    private double nr_of_direct_ads;
    private double nr_of_chief_trainings;

    public ResultsInterpreter() {
        try {
            HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
            workspace.open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo");
            workspace.command("setup");

            this.nr_of_direct_ads = (Double) workspace.report("nr_of_direct_ads");
            this.nr_of_chief_trainings = (Double) workspace.report("nr_of_chief_trainings");
            workspace.dispose();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public double getNrOfDirectAds() {
        return nr_of_direct_ads;
    }

    public double getNrOfChiefTrainings() {
        return nr_of_chief_trainings;
    }






}   
