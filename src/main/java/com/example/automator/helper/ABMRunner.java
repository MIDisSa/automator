package com.example.automator.helper;

import java.util.ArrayList;

import org.nlogo.app.App;
import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static ArrayList<String> runABM(ModelInput modelInput) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

        return runABM(modelInput, workspace);
    }

    public static ArrayList<String> runABM(ModelInput modelInput, HeadlessWorkspace workspace) {

        // establish return variable
        ArrayList<String> results = new ArrayList<String>();

        try {
            // OPEN MODEL
            System.setProperty("org.nlogo.level", "INFO");
            workspace.open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo");
            System.out.println("model opened");
   
            // SET MODEL PARAMETERS
            workspace.command(String.format("set nr_default_friends_inter_village %s", modelInput.getNrDefaultFriendsInterVillage()));
            workspace.command(String.format("set avg_intra_village_interaction_frequency %s", modelInput.getAvgIntraVillageInteractionFrequency()));
            workspace.command(String.format("set avg_inter_village_interaction_frequency %s", modelInput.getAvgInterVillageInteractionFrequency()));
            workspace.command(String.format("set avg_chief_farmer_meeting_frequency %s", modelInput.getAvgChiefFarmerMeetingFrequency()));
            workspace.command(String.format("set percentage_negative_WoM %s", modelInput.getPercentageNegativeWoM()));
            workspace.command(String.format("set base_adoption_probability %s", modelInput.getBaseAdoptionProbability()));

            // SET INTERVENTION PARAMETERS
            workspace.command(String.format("set direct_ad_type %s",modelInput.getDirectAdType()));
            workspace.command(String.format("set direct_ad_frequency %s", modelInput.getFrequencyDirectAd()));
            workspace.command(String.format("set train_chiefs_frequency %s", modelInput.getFrequencyChiefTraining()));
            workspace.command(String.format("set max_budget %s", modelInput.getBudget()));
            workspace.command(String.format("set direct_ad_nr_of_villages %s", modelInput.getDirectAdNrOfVillages()));
            workspace.command("set percentage_of_villagers_addressed 50"); //not part of optimization atm
            workspace.command(String.format("set train_chiefs_nr %s", modelInput.getTrainChiefsNr())); 

            // SETUP SIMULATION
            //workspace.command("random-seed 0");
            workspace.command("setup");

            // keep track of number of aware farmers and adopters per tick (needed for graph)
            ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
            ArrayList<Double> adoptersPerTick = new ArrayList<Double>();

            // run model for set number of ticks
            int ticks = modelInput.getNumberOfTicks();
            int counter = 0;
            while (counter < ticks) {
                workspace.command("go");
                counter += 1;
                awareFarmersPerTick.add((Double) workspace.report("count turtles with [adoption_state = 1]"));
                adoptersPerTick.add((Double) workspace.report("count turtles with [adoption_state = 2]"));
            }

            // get results
            String awareFarmers = String.valueOf(workspace.report("count turtles with [adoption_state = 1]"));
            String adopters = String.valueOf(workspace.report("count turtles with [adoption_state = 2]"));
            String nrOfDirectAds = String.valueOf(workspace.report("nr_of_direct_ads"));
            String nrOfChiefTrainings = String.valueOf(workspace.report("nr_of_chief_trainings"));

            workspace.dispose();

            // cast awareFarmersPerTick and adoptersPerTick to string to add to return array
            String awareFarmersPerTickString = awareFarmersPerTick.toString();
            String adoptersPerTickString = adoptersPerTick.toString();

            // add results to return array
            results.add(awareFarmers);
            results.add(adopters);
            results.add(nrOfDirectAds);
            results.add(nrOfChiefTrainings);
            results.add(awareFarmersPerTickString);
            results.add(adoptersPerTickString);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return results;
    }

     public static ArrayList<String> runABMWithGUI(ModelInput modelInput) {

        // establish return variable
        ArrayList<String> results = new ArrayList<String>();

        try {
            // OPEN MODEL
            java.awt.EventQueue.invokeAndWait(
                new Runnable() {
                    public void run() {
                        try {
                            App.app().open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo", false);;
                            System.out.println("model opened");
                        } catch(java.io.IOException e) {
                            System.out.println("some error here");
                            //e.printStackTrace(null);
                        }
                    }
                }
            );

            // SET MODEL PARAMETERS
            App.app().command(String.format("set nr_default_friends_inter_village %s", modelInput.getNrDefaultFriendsInterVillage()));
            App.app().command(String.format("set avg_intra_village_interaction_frequency %s", modelInput.getAvgIntraVillageInteractionFrequency()));
            App.app().command(String.format("set avg_inter_village_interaction_frequency %s", modelInput.getAvgInterVillageInteractionFrequency()));
            App.app().command(String.format("set avg_chief_farmer_meeting_frequency %s", modelInput.getAvgChiefFarmerMeetingFrequency()));
            App.app().command(String.format("set percentage_negative_WoM %s", modelInput.getPercentageNegativeWoM()));
            App.app().command(String.format("set base_adoption_probability %s", modelInput.getBaseAdoptionProbability()));

            // SET INTERVENTION PARAMETERS
            App.app().command(String.format("set direct_ad_type %s",modelInput.getDirectAdType()));
            App.app().command(String.format("set direct_ad_frequency %s", modelInput.getFrequencyDirectAd()));
            App.app().command(String.format("set train_chiefs_frequency %s", modelInput.getFrequencyChiefTraining()));
            App.app().command(String.format("set max_budget %s", modelInput.getBudget()));
            App.app().command(String.format("set direct_ad_nr_of_villages %s", modelInput.getDirectAdNrOfVillages()));
            App.app().command("set percentage_of_villagers_addressed 50"); //not part of optimization atm
            App.app().command(String.format("set train_chiefs_nr %s", modelInput.getTrainChiefsNr())); 

            // SETUP SIMULATION
            //workspace.command("random-seed 0");
            App.app().command("setup");
            App.app().command("set is_visible_update_activated true");
            App.app().command("set check_finished_condition true");

            // keep track of number of aware farmers and adopters per tick (needed for graph)
            ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
            ArrayList<Double> adoptersPerTick = new ArrayList<Double>();

            // run model for set number of ticks
            int ticks = modelInput.getNumberOfTicks();
            int counter = 0;
            while (counter < ticks) {
                App.app().command("go");
                counter += 1;
                awareFarmersPerTick.add((Double) App.app().report("count turtles with [adoption_state = 1]"));
                adoptersPerTick.add((Double) App.app().report("count turtles with [adoption_state = 2]"));
            }

            // get results
            String awareFarmers = String.valueOf(App.app().report("count turtles with [adoption_state = 1]"));
            String adopters = String.valueOf(App.app().report("count turtles with [adoption_state = 2]"));

            // cast awareFarmersPerTick and adoptersPerTick to string to add to return array
            String awareFarmersPerTickString = awareFarmersPerTick.toString();
            String adoptersPerTickString = adoptersPerTick.toString();

            // add results to return array
            results.add(awareFarmers);
            results.add(adopters);
            results.add(awareFarmersPerTickString);
            results.add(adoptersPerTickString);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    
}