package com.acme.securecodingpractices.injectionandinclusion;

//In an insecure scenario, an application might execute system commands using user input without proper validation,
// leaving it open to command injection.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsecureCommandExecution {

    public static void main(String[] args) {
        String userInput = "John Doe; rm -rf /";  // Dangerous user input (Command injection attack)
        try {
            // Insecure approach to executing system commands
            String command = "echo " + userInput;  // Directly using user input in a command
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}