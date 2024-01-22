package com.example.automator.helper;

import java.util.ArrayList;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static ArrayList<String> runABM(DataInput dataInput, UserInput userInput) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

        return runABM(dataInput, userInput, workspace);
    }

    public static ArrayList<String> runABM(DataInput dataInput, UserInput userInput, HeadlessWorkspace workspace) {

        // establish return variable
        ArrayList<String> results = new ArrayList<String>();

        try {
            // OPEN MODEL
            System.setProperty("org.nlogo.level", "INFO");
            workspace.open("netlogo-model-goes-here/ABM_innovation_diffusion_tanzania.nlogo");
            System.out.println("model opened");
   
            // SETUP SIMULATION
            //workspace.command("random-seed 0");

            // SET VILLAGE PARAMETERS
            workspace.command(String.format("set avg_nr_of_farmers_per_village %s", userInput.getFarmersPerVillage()));
            workspace.command(String.format("set nr_of_villages %s", userInput.getNrOfVillages()));
            workspace.command(String.format("set nr_of_neighborhoods %s", userInput.getNrOfNeighborhoods()));
            workspace.command(String.format("set percentage_of_farmers_in_farmgroup %s", userInput.getPercentageOfFarmersInFarmgroup()));
            workspace.command(String.format("set nr_default_friends_inter_village %s", dataInput.getNrDefaultFriendsInterVillage()));
            workspace.command(String.format("set direct_ad_nr_of_villages %s", userInput.getDirectAdCoverage()));
            workspace.command(String.format("set train_chiefs_nr %s", userInput.getTrainChiefsCoverage()));
            workspace.command("setup");


            // SET MODEL PARAMETERS
            workspace.command(String.format("set train_chiefs_influence_adoption %s", dataInput.getTrainChiefInfluence()));
            workspace.command(String.format("set avg_intra_village_interaction_frequency %s", dataInput.getAvgIntraVillageInteractionFrequency()));
            workspace.command(String.format("set avg_inter_village_interaction_frequency %s", dataInput.getAvgInterVillageInteractionFrequency()));
            workspace.command(String.format("set avg_chief_farmer_meeting_frequency %s", dataInput.getAvgChiefFarmerMeetingFrequency()));
            workspace.command(String.format("set percentage_negative_WoM %s", dataInput.getPercentageNegativeWoM()));
            workspace.command(String.format("set base_adoption_probability %s", dataInput.getBaseAdoptionProbability()));
            workspace.command(String.format("set avg_inter_mention_percentage %s", dataInput.getAvgInterMentionPercentage()));
            workspace.command(String.format("set avg_intra_mention_percentage %s", dataInput.getAvgIntraMentionPercentage()));

            // SET INTERVENTION PARAMETERS
            workspace.command(String.format("set run_until_day_x %s", userInput.getNumberOfTicks()));
            workspace.command(String.format("set direct_ad_type %s", userInput.getDirectAdType()));
            workspace.command(String.format("set direct_ad_frequency %s", userInput.getFrequencyDirectAd()));
            workspace.command(String.format("set train_chiefs_frequency %s", userInput.getFrequencyChiefTraining()));
            workspace.command(String.format("set max_budget %s", userInput.getBudget()));
            workspace.command(String.format("set percentage_of_villagers_addressed %s", userInput.getPercentageOfVillagersAddressed()));

            // SET FIXED AND VARIABLE COST
            workspace.command(String.format("set fixed_costs_direct_ad %s", userInput.getFixedCostsDirectAd()));
            workspace.command(String.format("set fixed_costs_train_chiefs %s", userInput.getFixedCostsTrainChiefs()));
            workspace.command(String.format("set variable_costs_direct_ad %s", userInput.getVariableCostsDirectAd()));
            workspace.command(String.format("set variable_costs_discount %s", userInput.getVariableCostsDiscount()));
            workspace.command(String.format("set variable_costs_delayed %s", userInput.getVariableCostsDelayed()));
            workspace.command(String.format("set variable_costs_delayed_discount %s", userInput.getVariableCostsDelayedDiscount()));
            workspace.command(String.format("set variable_costs_train_chiefs %s", userInput.getVariableCostsTrainChiefs()));

            // keep track of number of aware farmers and adopters per tick (needed for graph)
            ArrayList<Double> awareFarmersPerTick = new ArrayList<Double>();
            ArrayList<Double> adoptersPerTick = new ArrayList<Double>();

            // run model for set number of ticks
            int ticks = Integer.valueOf(userInput.getNumberOfTicks());
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
            String totalCost = String.valueOf(workspace.report("current_cost"));
            Double roundedTotalCost = Math.floor(Double.valueOf(totalCost));
            totalCost = String.valueOf(roundedTotalCost);


            workspace.dispose();

            // cast awareFarmersPerTick and adoptersPerTick to string to add to return array
            String awareFarmersPerTickString = awareFarmersPerTick.toString();
            String adoptersPerTickString = adoptersPerTick.toString();

            // add results to return array
            results.add(awareFarmers);
            results.add(adopters);
            results.add(nrOfDirectAds);
            results.add(nrOfChiefTrainings);
            results.add(totalCost);
            results.add(awareFarmersPerTickString);
            results.add(adoptersPerTickString);

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("model ended");
        return results;

    }
    
}