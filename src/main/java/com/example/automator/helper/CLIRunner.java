package com.example.automator.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import org.apache.commons.lang3.SystemUtils;

public class CLIRunner {
    public void runCommand(String cmd) {
        try {
            ProcessBuilder pb = new ProcessBuilder();
            //System.out.println(System.getenv()); //Prints SYSTEMPATH, enables manual check if NetLogo is part of it.
            if (SystemUtils.IS_OS_WINDOWS) {
                System.out.println("Building process for Windows...");
                pb.command("cmd.exe", "/c", "behaviorsearch_headless.bat " + cmd);
            } else if (SystemUtils.IS_OS_UNIX) {
                System.out.println("Building process for UNIX-System...");
                pb.command("/bin/bash", "-c", "behaviorsearch_headless.sh " + cmd);
            } else {
                throw new IOException("OS not compatible.");
            }

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
