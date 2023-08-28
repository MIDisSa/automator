package com.example.automator.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import org.apache.commons.lang3.SystemUtils;

public class CLIRunner {
    public void runCommand(String cmd) {
        if (SystemUtils.IS_OS_WINDOWS) {
            try {
                System.out.println("Building process for Windows...");
                ProcessBuilder pb = new ProcessBuilder();
                //System.out.println(System.getenv()); //Prints SYSTEMPATH, enables manual check if NetLogo is part of it.
                pb.command("cmd.exe", "/c", "behaviorsearch_headless.bat " + cmd);
                
                Process process = pb.start();
                //StringBuilder output = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                //System.out.println(output);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (SystemUtils.IS_OS_UNIX) {
            try {
                System.out.println("Building process for UNIX-System...");
                ProcessBuilder pb = new ProcessBuilder();
                //System.out.println(System.getenv()); //Prints SYSTEMPATH, enables manual check if NetLogo is part of it.
                pb.command("/bin/bash", "-c", "behaviorsearch_headless.sh " + cmd);
                //pb.command("sh", "-c", "behaviorsearch_headless.sh " + cmd); //TRY THIS LINE ALTERNATIVELY
                
                Process process = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("OS not compatible.");
        }

    }
}
