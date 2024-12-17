package com.acme.securecodingpractices.secureaccess;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class Main {
    public static void main(String[] args) {
        // Create the user details service
        SimpleUserDetailsService userDetailsService = new SimpleUserDetailsService();

        // Create the authentication manager
        SimpleAuthenticationManager authenticationManager = new SimpleAuthenticationManager(userDetailsService);

        try {
            // Try authenticating with the username and password
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken("john", "password123")
            );

            // If authentication is successful
            System.out.println("Authentication successful! User: " + auth.getName());
        } catch (BadCredentialsException e) {
            // If authentication fails
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}
