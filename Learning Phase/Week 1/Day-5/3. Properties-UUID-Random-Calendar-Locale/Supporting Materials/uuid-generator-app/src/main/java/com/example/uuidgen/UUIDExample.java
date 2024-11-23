/*UUID.randomUUID(): Generates a random UUID (Version 4) which is based on random numbers.
        UUID.nameUUIDFromBytes(): Generates a UUID based on a name, ensuring that the same
        name always generates the same UUID.*/

package com.example.uuidgen;

import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        // Generate a random UUID (Version 4)
        UUID randomUUID = UUID.randomUUID();
        System.out.println("Random UUID: " + randomUUID);

        // Generate a UUID from a name (Version 3 or 5)
        UUID nameBasedUUID = UUID.nameUUIDFromBytes("Steve".getBytes());
        System.out.println("Name-based UUID: " + nameBasedUUID);
    }
}
