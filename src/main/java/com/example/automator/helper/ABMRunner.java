package com.example.automator.helper;

import java.util.ArrayList;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static ArrayList<String> runABM(Parameters parameters) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

        // establish return variable
        ArrayList<String> results = new ArrayList<String>();

        try {
            // open model
            System.setProperty("org.nlogo.level", "INFO");
            workspace.open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo");
            System.out.println("model opened");

            // set parameters
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


            workspace.command("random-seed 0");
            workspace.command("setup");
            workspace.command("direct_village_intervention");

            // keep track of number of aware farmers and adopters per tick (needed for graph)
            ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
            ArrayList<Double> adoptersPerTick = new ArrayList<Double>();

            // run model for set number of ticks
            int ticks = 50;
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
