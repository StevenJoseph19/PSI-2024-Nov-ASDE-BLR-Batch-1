package com.mycompany.regex;

public class ValidateMobile {

    public static void main(String[] args) {

        String regex = "[89][0-9]{9}";

        String mobile1 = "8824574739";
        String mobile2 = "8824a74739";

        System.out.println("Is " + mobile1 + " a valid mobile number? ");
        System.out.println(mobile1.matches(regex));

        System.out.println("Is " + mobile2 + " a valid mobile number? ");
        System.out.println(mobile2.matches(regex));

    }
}
