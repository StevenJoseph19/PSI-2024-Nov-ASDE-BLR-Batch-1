package com.acme.securecodingpractices.injectionandinclusion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureInputHandling {

    public static void main(String[] args) {
        String username = "John Doe";  // Secure user input
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");

            // Use PreparedStatement to avoid SQL injection
            String query = "SELECT * FROM users WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);  // Safely bind the user input
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
