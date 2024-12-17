package com.acme.securecodingpractices.accesscontrol;

import java.util.*;

public class SecureResourceService {
    // Role-based permissions
    private static final Map<String, List<String>> ROLE_PERMISSIONS = Map.of(
            "Admin", List.of("AdminSettings", "SensitiveData", "UserData"),
            "User", List.of("UserData"),
            "Guest", List.of()
    );

    public void accessResource(String role, String resourceName) {
        // Check if the role has permission to access the resource
        List<String> allowedResources = ROLE_PERMISSIONS.getOrDefault(role, Collections.emptyList());
        if (allowedResources.contains(resourceName)) {
            System.out.println(role + " successfully accessed the resource: " + resourceName);
        } else {
            System.out.println("Access Denied! Role '" + role + "' cannot access resource: " + resourceName);
        }
    }

    public static void main(String[] args) {
        SecureResourceService service = new SecureResourceService();

        // Access attempts
        service.accessResource("Admin", "AdminSettings"); // Allowed
        service.accessResource("User", "AdminSettings");  // Denied
        service.accessResource("Guest", "UserData");      // Denied
    }
}
