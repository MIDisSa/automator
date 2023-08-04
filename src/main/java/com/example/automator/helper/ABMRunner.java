package com.example.automator.helper;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static Object runABM(Parameters parameters) {
        // create workspace
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");

        //get parameters
        String parameter1 = parameters.getParameter1();

        try {
            workspace.open("netlogo-model-goes-here/Fire.nlogo", true);
            workspace.command(String.format("set density %s", parameter1));
            workspace.command("random-seed 0");
            workspace.command("setup");
            workspace.command("repeat 50 [ go ]") ;
            Object result = workspace.report("burned-trees");
            workspace.dispose();
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
