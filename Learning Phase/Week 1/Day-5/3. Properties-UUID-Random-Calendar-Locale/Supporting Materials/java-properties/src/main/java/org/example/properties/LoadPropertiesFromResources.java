/*      The getResourceAsStream() method loads files from the classpath, which includes src/main/resources.
        InputStream reads the file from the resources folder.
        If the file is missing, the program safely informs the user with a null check.*/
package org.example.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropertiesFromResources {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // Load the properties file from the resources directory
        try (InputStream input = LoadPropertiesFromResources.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);

            // Retrieve properties
            System.out.println("Database URL: " + properties.getProperty("db.url"));
            System.out.println("Username: " + properties.getProperty("db.username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
