package org.acme.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleData {

    public static List<User> getUsers() {
        // Replace this with your actual user data creation logic
        // You can follow the same pattern used for Products

        // Example User with basic info
        User user1 = new User();
        user1.setId(1);
        user1.setName("John Doe");
        user1.setRole("Customer");
        user1.setEmployee(false);
        user1.setTags(null); // Or create a list of tags for this user
        user1.setInfo(null); // Or create a map with additional user details

        // Example User with additional information in info map
        User user2 = new User();
        user2.setId(2);
        user2.setName("Jane Smith");
        user2.setRole("Admin");
        user2.setEmployee(true);
        user2.setTags(List.of("admin", "manager"));
        user2.setInfo(new HashMap<String, Object>() {{
            put("department", "IT");
            put("location", "New York");
        }});

        // Additional Users
        User user3 = new User();
        user3.setId(3);
        user3.setName("Michael Johnson");
        user3.setRole("Salesperson");
        user3.setEmployee(true);
        user3.setTags(List.of("sales", "customer-service"));
        user3.setInfo(new HashMap<String, Object>() {{
            put("team", "North");
            put("target", 100000);
        }});

        User user4 = new User();
        user4.setId(4);
        user4.setName("Emily Brown");
        user4.setRole("Marketing Manager");
        user4.setEmployee(true);
        user4.setTags(List.of("marketing", "social-media"));
        user4.setInfo(new HashMap<String, Object>() {{
            put("campaign", "Spring Campaign");
            put("budget", 50000);
        }});

        User user5 = new User();
        user5.setId(5);
        user5.setName("David Lee");
        user5.setRole("Software Engineer");
        user5.setEmployee(true);
        user5.setTags(List.of("java", "python", "devops"));
        user5.setInfo(new HashMap<String, Object>() {{
            put("project", "Project Alpha");
            put("skills", "Full-stack");
        }});

        User user6 = new User();
        user6.setId(6);
        user6.setName("Sarah Kim");
        user6.setRole("HR Manager");
        user6.setEmployee(true);
        user6.setTags(List.of("hr", "recruitment"));
        user6.setInfo(new HashMap<String, Object>() {{
            put("department", "HR");
            put("team_size", 20);
        }});

        User user7 = new User();
        user7.setId(7);
        user7.setName("Alex Turner");
        user7.setRole("Finance Analyst");
        user7.setEmployee(true);
        user7.setTags(List.of("finance", "accounting"));
        user7.setInfo(new HashMap<String, Object>() {{
            put("department", "Finance");
            put("specialization", "Tax");
        }});

        return List.of(user1, user2, user3, user4, user5, user6, user7);
    }
}