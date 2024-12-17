package com.acme.securecodingpractices.accesscontrol;
//You’re developing a web-based system for managing resources such as files, user profiles, or administrative settings.
// Each user has a role (Admin, User, or Guest),
//and access to specific actions depends on the role.
public class ResourceService {
    public void accessResource(String role, String resourceName) {
        System.out.println(role + " is accessing the resource: " + resourceName);
        // No access control checks
    }

    public static void main(String[] args) {
        ResourceService service = new ResourceService();

        // Any role can access any resource
        service.accessResource("Guest", "AdminSettings");
        service.accessResource("User", "SensitiveData");
    }
}
