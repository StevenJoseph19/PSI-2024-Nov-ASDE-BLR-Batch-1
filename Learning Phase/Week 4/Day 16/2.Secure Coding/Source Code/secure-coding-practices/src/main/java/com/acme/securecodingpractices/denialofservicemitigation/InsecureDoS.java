package com.acme.securecodingpractices.denialofservicemitigation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsecureDoS {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");
            Statement stmt = connection.createStatement();

            // Insecure SQL query vulnerable to DoS
            String query = "SELECT * FROM users WHERE name = '" + args[0] + "';";
            stmt.executeQuery(query);

            System.out.println("Query executed: " + query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
