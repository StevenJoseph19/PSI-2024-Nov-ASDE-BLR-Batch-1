package com.acme.securecodingpractices.injectionandinclusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecureCommandExecution {

    public static void main(String[] args) {
        String userInput = "admin";  // Secure user input (no shell metacharacters)
        try {
            // Use only trusted commands and validate input
            if (userInput.matches("^[a-zA-Z0-9_]+$")) {  // Only allow alphanumeric input
                String command = "echo " + userInput;
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Invalid input detected!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
