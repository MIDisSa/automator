package com.example.automator.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLIRunner {
    ProcessBuilder processBuilder = new ProcessBuilder();
    
    public void runCommand(String cmd) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("\"C:\\Program Files\\NetLogo 6.2.2\\app\\behaviorsearch\\behaviorsearch_headless.bat\" " + cmd); //Currently needs a local installation of BehaviorSearch


            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line=input.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
