package com.acme.securecodingpractices.secureaccess;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

public class SimpleUserDetailsService implements UserDetailsService {

    // Simulating a database with a hardcoded user
    private static final User user = new User("john", "password123",
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("john".equals(username)) {
            return user;  // Return the hardcoded user if username matches
        }
        throw new UsernameNotFoundException("User not found");
    }
}
