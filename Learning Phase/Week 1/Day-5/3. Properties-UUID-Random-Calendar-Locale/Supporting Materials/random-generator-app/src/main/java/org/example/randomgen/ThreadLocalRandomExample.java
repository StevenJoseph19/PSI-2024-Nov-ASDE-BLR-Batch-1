package org.example.randomgen;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {
    public static void main(String[] args) {
        // Generate random numbers
        int randomInt = ThreadLocalRandom.current().nextInt(1, 101); // 1 to 100
        System.out.println("Random Integer: " + randomInt);

        double randomDouble = ThreadLocalRandom.current().nextDouble(1.0, 5.0); // 1.0 to 5.0
        System.out.println("Random Double: " + randomDouble);
    }
}
