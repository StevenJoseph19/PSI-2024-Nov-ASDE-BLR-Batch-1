package com.acme.securecodingpractices.serialization;
//In this example, sensitive data (password) is serialized without proper handling,
//        exposing it during serialization and transfer.
import java.io.*;

public class InsecureUser implements Serializable {
    private String username;
    private String password; // Sensitive data

    public InsecureUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InsecureUser user = new InsecureUser("john_doe", "12345");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            InsecureUser deserializedUser = (InsecureUser) ois.readObject();
            System.out.println("Deserialized Username: " + deserializedUser.getUsername());
            System.out.println("Deserialized Password: " + deserializedUser.getPassword()); // Sensitive data exposed
        }
    }
}
