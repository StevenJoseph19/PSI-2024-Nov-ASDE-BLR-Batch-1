/*      The Paths.get() method defines a relative path to src/main/resources.
        FileOutputStream writes to this path, creating the file if it doesn’t exist.
        The store() method saves the key-value pairs to the specified file.

        The resources folder is packaged into the JAR file during build. Writing to resources is mainly useful during development.
        For runtime configuration changes, store the properties in an external directory and load it dynamically.
        This ensures clean separation of static resources and runtime configurations.
        */
package org.example.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class StorePropertiesToResources {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("app.name", "MyApp");
        properties.setProperty("app.version", "1.0");
        properties.setProperty("app.author", "John Doe");

        // Define the path to store the file in the resources directory
        String filePath = Paths.get("src/main/resources/app.properties").toString();

        try (FileOutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, "App Configuration");
            System.out.println("Properties saved successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
