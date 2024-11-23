package org.example.randomgen;

import java.util.Random;

public class RandomStringExample {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        // Generate a random string of length 10
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(index));
        }

        System.out.println("Random String: " + randomString);
    }
}
