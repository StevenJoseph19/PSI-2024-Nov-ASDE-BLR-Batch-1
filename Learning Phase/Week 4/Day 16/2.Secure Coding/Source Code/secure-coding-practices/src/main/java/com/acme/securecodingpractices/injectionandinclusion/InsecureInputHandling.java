package com.acme.securecodingpractices.injectionandinclusion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsecureInputHandling {

    public static void main(String[] args) {
        String username = "John Doe' --";  // Insecure user input (SQL injection attack)
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");
            Statement stmt = connection.createStatement();

            // Vulnerable to SQL injection
            String query = "SELECT * FROM users WHERE name = '" + username + "'";  // Directly concatenating user input into the SQL query
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
