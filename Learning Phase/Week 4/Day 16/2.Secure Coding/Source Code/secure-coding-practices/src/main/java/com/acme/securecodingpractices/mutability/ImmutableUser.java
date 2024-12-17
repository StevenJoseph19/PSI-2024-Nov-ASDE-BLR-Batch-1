package com.acme.securecodingpractices.mutability;

// After: Immutable User class
public final class ImmutableUser {
    private final String username;
    private final String password;

    public ImmutableUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters (no setters)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        // Usage example
        ImmutableUser user = new ImmutableUser("john_doe", "123456");
        // user.setPassword("newPassword"); // Compilation error: No setter method exists.
    }
}


