package com.example.uuidgen;

import java.util.UUID;

public class FileNameGenerator {
    public static void main(String[] args) {
        String fileName = "user_image_" + UUID.randomUUID().toString() + ".jpg";
        System.out.println("Generated File Name: " + fileName);
    }
}
