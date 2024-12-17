package com.acme.securecodingpractices.denialofservicemitigation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureDoS {
    public static void main(String[] args) {
        try {
            // Establish a connection to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");

            // Secure coding by using PreparedStatement to avoid DoS vulnerabilities
            String query = "SELECT * FROM users WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "Jane Smith"); // Parameterized query
            ResultSet rs = stmt.executeQuery();

            // Output the results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
