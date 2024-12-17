package com.acme.securecodingpractices.inputvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    // Method to validate email
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate number within a range
    public static boolean isValidNumber(int number, int minValue, int maxValue) {
        return (number >= minValue && number <= maxValue);
    }

    public static void main(String[] args) {
        // Test email validation
        String email = "test@example.com";
        if (isValidEmail(email)) {
            System.out.println("Valid email address.");
        } else {
            System.out.println("Invalid email address. Please enter a valid one.");
        }

        // Test number validation
        int number = 5;
        if (isValidNumber(number, 1, 10)) {
            System.out.println("Valid number.");
        } else {
            System.out.println("Invalid number. Please enter a number between 1 and 10.");
        }
    }
}
