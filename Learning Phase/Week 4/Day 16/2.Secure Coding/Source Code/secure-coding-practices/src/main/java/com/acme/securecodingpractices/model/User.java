package com.acme.securecodingpractices.model;

public class User {
    private String username;
    private String password;  // Stored in plain text for simplicity, but we should encode in real-world scenarios

    // Constructor, getters, and setters
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
