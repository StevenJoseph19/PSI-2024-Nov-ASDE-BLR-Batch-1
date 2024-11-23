package com.mycompany.regex;

public class ValidateAlphaNumericText {

    public static void main(String[] args) {

        String regex = "[A-Z][a-z]*[0-9][a-z]+";

        String text1 = "Palindr0me";
        String text2 = "Palindrome";

        System.out.println("Is " + text1 + " valid text? ");
        System.out.println(text1.matches(regex));

        System.out.println("Is " + text2 + " valid text? ");
        System.out.println(text2.matches(regex));


    }
}
