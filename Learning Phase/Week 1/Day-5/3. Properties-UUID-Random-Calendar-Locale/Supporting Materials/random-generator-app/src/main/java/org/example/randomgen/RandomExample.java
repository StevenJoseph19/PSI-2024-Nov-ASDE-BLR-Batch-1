package org.example.randomgen;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate random integers
        int randomInt = random.nextInt(100); // Between 0 and 99
        System.out.println("Random Integer: " + randomInt);

        // Generate random double
        double randomDouble = random.nextDouble(); // Between 0.0 and 1.0
        System.out.println("Random Double: " + randomDouble);

        // Generate random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random Boolean: " + randomBoolean);
    }
}
