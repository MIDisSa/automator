package com.example.automator.helper;

import java.util.ArrayList;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static ArrayList<String> runABM(Parameters parameters, ModelInput modelInput) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

        return runABM(parameters, modelInput, workspace);
    }

    public static ArrayList<String> runABM(Parameters parameters, ModelInput modelInput, HeadlessWorkspace workspace) {

        // establish return variable
        ArrayList<String> results = new ArrayList<String>();

        try {
            // OPEN MODEL
            System.setProperty("org.nlogo.level", "INFO");
            workspace.open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo");
            System.out.println("model opened");

            // SET MODEL PARAMETERS
            //workspace.command(String.format("set train_chief_influence %s", parameters.getTrainChiefInfluence()));
            workspace.command(String.format("set nr_default_friends_inter_village %s", parameters.getNrDefaultFriendsInterVillage()));
            //workspace.command(String.format("set std_nr_default_friends_inter_village %s", parameters.getStdNrDefaultFriendsInterVillage()));
            workspace.command(String.format("set avg_intra_village_interaction_frequency %s", parameters.getAvgIntraVillageInteractionFrequency()));
            //workspace.command(String.format("set stdev_intra_village_interaction_frequency %s", parameters.getStdevIntraVillageInteractionFrequency()));
            workspace.command(String.format("set avg_inter_village_interaction_frequency %s", parameters.getAvgInterVillageInteractionFrequency()));
            //workspace.command(String.format("set stdev_inter_village_interaction_frequency %s", parameters.getStdevInterVillageInteractionFrequency()));
            workspace.command(String.format("set avg_chief_farmer_meeting_frequency %s", parameters.getAvgChiefFarmerMeetingFrequency()));
            //workspace.command(String.format("set avg_intra_mention_percentage %s", parameters.getAvgIntraMentionPercentage()));
            //workspace.command(String.format("set stdev_intra_mention_percentage %s", parameters.getStdevIntraMentionPercentage()));
            //workspace.command(String.format("set avg_inter_mention_percentage %s", parameters.getAvgInterMentionPercentage()));
            //workspace.command(String.format("set stdev_inter_mention_percentage %s", parameters.getStdevInterMentionPercentage()));
            workspace.command(String.format("set percentage_negative_WoM %s", parameters.getPercentageNegativeWoM()));
            workspace.command(String.format("set base_adoption_probability %s", parameters.getBaseAdoptionProbability()));

            
            
            // SET INTERVENTION PARAMETERS
            workspace.command("set direct_ad_type \"Direct Ad\"");
            workspace.command("set direct_ad_frequency 365");
            workspace.command("set train_chiefs_frequency 0");
            workspace.command("set max_budget 10000");
            workspace.command("set direct_ad_nr_of_villages 50");
            workspace.command("set percentage_of_villagers_addressed 50");
            workspace.command("set train_chiefs_nr 50");

            // SETUP SIMULATION
            //workspace.command("random-seed 0");
            workspace.command("setup");

            // run intervention
            String kindOfIntervention = modelInput.getKindOfIntervention();
            workspace.command(kindOfIntervention); //TODO: maybe the string from the frontend does not exactly match the needed command --> add smth to convert

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

            workspace.dispose();

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
