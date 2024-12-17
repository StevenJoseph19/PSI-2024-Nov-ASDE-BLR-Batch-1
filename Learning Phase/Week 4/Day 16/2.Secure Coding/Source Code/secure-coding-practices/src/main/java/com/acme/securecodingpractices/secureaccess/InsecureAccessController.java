package com.acme.securecodingpractices.secureaccess;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsecureAccessController {

    @GetMapping("/insecureadmin")
    public String getAdminInfo() {
        // Insecure: No checks, anyone can access this
        return "Admin Information";
    }

    @GetMapping("/insecureuser")
    public String getUserInfo() {
        // Insecure: No checks, anyone can access this
        return "User Information";
    }
}
