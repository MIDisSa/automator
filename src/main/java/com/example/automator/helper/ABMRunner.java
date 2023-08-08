package com.example.automator.helper;

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
            //workspace.command(String.format("set base_adoption_probability %s", parameters.getBaseAdoptionProbability()));


            //workspace.command("random-seed 0");
            //workspace.command("setup");
            //workspace.command("repeat 50 [ go ]") ;
            //Object result = workspace.report("count turtles with [adoption_state = 1]");
            //workspace.dispose();
            //return result;
            return null;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
