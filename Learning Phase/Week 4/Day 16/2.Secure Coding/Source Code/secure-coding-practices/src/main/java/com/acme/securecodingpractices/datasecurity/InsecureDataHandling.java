package com.acme.securecodingpractices.datasecurity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsecureDataHandling {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");

            String name = "user123";
            String password = "plaintextpassword";  // Insecurely storing plaintext password
            String email = "user123@example.com";
            String phone = "123-456-7890";

            String query = "INSERT INTO users (name, encrypted_password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, password);  // Storing plaintext password (insecure)
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.executeUpdate();
            System.out.println("User added with insecure password storage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
