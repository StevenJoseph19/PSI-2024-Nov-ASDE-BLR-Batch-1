package com.acme.securecodingpractices.serialization;

import java.io.*;
import java.util.Base64;

public class SecureUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password; // Mark sensitive field as transient

    public SecureUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Custom serialization logic
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        // Encrypt password before serialization
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        oos.writeObject(encryptedPassword);
    }

    // Custom deserialization logic
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Decrypt password after deserialization
        String encryptedPassword = (String) ois.readObject();
        password = new String(Base64.getDecoder().decode(encryptedPassword));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SecureUser user = new SecureUser("john_doe", "secure_password");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secure_user.ser"))) {
            oos.writeObject(user);
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secure_user.ser"))) {
            SecureUser deserializedUser = (SecureUser) ois.readObject();
            System.out.println("Deserialized Username: " + deserializedUser.getUsername());
            System.out.println("Deserialized Password: " + deserializedUser.getPassword()); // Sensitive data secured
        }
    }
}
