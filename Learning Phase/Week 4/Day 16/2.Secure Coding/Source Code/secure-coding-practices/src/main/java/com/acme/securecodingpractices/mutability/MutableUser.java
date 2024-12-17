package com.acme.securecodingpractices.mutability;

// Before: Mutable User class
public class MutableUser {
    private String username;
    private String password;

    public MutableUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        // Usage example
        MutableUser user = new MutableUser("john_doe", "123456");
        user.setPassword("newPassword"); // Password can be changed, potentially exposing security risks.
    }
}


