package com.example.automator.helper;

import org.nlogo.headless.HeadlessWorkspace;

public class ABMRunner {

    public static void runABM() {
        HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();
        System.out.println("workspace created");
        try {
            workspace.open("/netlogo-model-goes-here/Fire.nlogo", true);
            workspace.command("set density 62");
            workspace.command("random-seed 0");
            workspace.command("setup");
            workspace.command("repeat 50 [ go ]") ;
            Object result = workspace.report("burned-trees");
            System.out.println(workspace.report("burned-trees"));
            workspace.dispose();
            //return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        //return null;
    }
    
}
