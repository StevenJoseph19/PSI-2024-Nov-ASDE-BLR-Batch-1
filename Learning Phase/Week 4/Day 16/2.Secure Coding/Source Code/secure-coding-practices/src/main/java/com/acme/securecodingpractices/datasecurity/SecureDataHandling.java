package com.acme.securecodingpractices.datasecurity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecureDataHandling {
    public static void main(String[] args) {
        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securecoding", "postgres", "password");

            // User input data
            String name = "user123";
            String password = "plaintextpassword";  // Plaintext password
            String email = "user123@example.com";
            String phone = "123-456-7890";

            // Encrypt the password using PBKDF2
            byte[] salt = generateSalt();
            byte[] encryptedPassword = encryptPassword(password, salt);

            // Prepare SQL query to insert the encrypted password
            String query = "INSERT INTO users (name, encrypted_password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setBytes(2, encryptedPassword);  // Storing the encrypted password
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.executeUpdate();

            System.out.println("User added with encrypted password storage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to generate a random salt
    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Method to encrypt the password using PBKDF2WithHmacSHA256
    public static byte[] encryptPassword(String password, byte[] salt) throws Exception {
        int iterations = 10000;  // Number of iterations for PBKDF2
        int keyLength = 256;  // Length of the derived key in bits

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return skf.generateSecret(spec).getEncoded();
    }
}
