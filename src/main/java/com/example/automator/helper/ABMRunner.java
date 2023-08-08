package com.example.automator.helper;

import java.util.ArrayList;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static Object runABM(Parameters parameters) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

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
            workspace.command("repeat 50 [ go ]") ;

            // get result
            Object awareFarmers = workspace.report("count turtles with [adoption_state = 1]");
            Object adopters = workspace.report("count turtles with [adoption_state = 2]");
            ArrayList<Object> results = new ArrayList<Object>();
            results.add(awareFarmers);
            results.add(adopters);
            workspace.dispose();
            return results;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
