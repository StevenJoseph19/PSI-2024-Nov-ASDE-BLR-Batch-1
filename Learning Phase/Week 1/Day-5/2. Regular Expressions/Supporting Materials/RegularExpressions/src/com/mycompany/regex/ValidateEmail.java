package com.mycompany.regex;

public class ValidateEmail {

    public static void main(String[] args) {

//        String regex = "[a-zA-Z0-9_-.]+[@][a-z]+[.][a-z]{2,3}";
          String regex = "[a-zA-Z0-9._-]+[@][a-z]+[.][a-z]{2,3}";

        String email1 = "stevesam.5674@gmail.com";
        String email2 = "steve#sam.5674@gmail.com";

        System.out.println("Is " + email1 + " a valid email? ");
        System.out.println(email1.matches(regex));

        System.out.println("Is " + email2 + " a valid email? ");
        System.out.println(email2.matches(regex));

    }
}
