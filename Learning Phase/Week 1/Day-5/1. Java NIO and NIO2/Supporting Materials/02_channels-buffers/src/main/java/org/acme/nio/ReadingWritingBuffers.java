package org.acme.nio;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ReadingWritingBuffers {

//    If the file "files/ints.bin" does not exist, it will be created by the FileChannel.open() method.
//    If it already exists, the file will be opened for writing, and its contents will be overwritten.
//    So, there is no need for the file to exist beforehand. The code will handle its creation.
//    However, ensure that the directory ("files/") exists, or else the code might throw an exception
//    because it cannot create the file in a non-existent directory.

    static final Path FILE_PATH = Paths.get("files/ints.bin");

    public static void main(String[] args) {
        try {
            // Step 1: Create buffer and add integers
            ByteBuffer buffer = createBufferWithIntegers();

            // Step 2: Print the buffer state before writing
//            printBufferStateBeforeWrite(buffer);

            // Step 3: Write buffer data to file
            writeBufferToFile(buffer);

            // Step 4: Read the file back into the buffer
            readFileIntoBuffer(buffer);

            // Step 5: Process and display integers from the buffer
            List<Integer> integers = readIntegersFromBuffer(buffer);
            displayIntegers(integers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create a ByteBuffer and add integers to it
    static ByteBuffer createBufferWithIntegers() {
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024); // 1 MB buffer
        buffer.putInt(10);
        buffer.putInt(20);
        buffer.putInt(30);
        System.out.println("Position after adding integers = " + buffer.position());
        System.out.println("Limit after adding integers = " + buffer.limit());
        return buffer;
    }

    // Method to print the buffer state before writing
    static void printBufferStateBeforeWrite(ByteBuffer buffer) {
        buffer.flip(); // Prepare buffer for reading
        IntBuffer intBuffer = buffer.asIntBuffer();

        // Print the position and limit of the IntBuffer
        System.out.println("Position = " + intBuffer.position());
        System.out.println("Limit    = " + intBuffer.limit());

        // Read and print the first integer in the buffer
        int i = intBuffer.get();
        System.out.println("i = " + i);
    }

    // Method to write the ByteBuffer content to a file
    static void writeBufferToFile(ByteBuffer buffer) throws IOException {
        try (FileChannel fileChannel = FileChannel.open(FILE_PATH, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            buffer.flip(); // Prepare buffer for writing
            fileChannel.write(buffer);
        }
        System.out.println("File size after writing = " + Files.size(FILE_PATH));
    }

    // Method to read file content back into the ByteBuffer
    static void readFileIntoBuffer(ByteBuffer buffer) throws IOException {
        try (FileChannel fileChannel = FileChannel.open(FILE_PATH, StandardOpenOption.READ)) {
            buffer.clear(); // Prepare buffer for reading
            fileChannel.read(buffer);
        }
        System.out.println("Position after reading = " + buffer.position());
        System.out.println("Limit after reading = " + buffer.limit());
    }

    // Method to read integers from the ByteBuffer and store in a list
    static List<Integer> readIntegersFromBuffer(ByteBuffer buffer) {
        buffer.flip(); // Prepare buffer for reading integers
        IntBuffer intBuffer = buffer.asIntBuffer();
        List<Integer> integers = new ArrayList<>();
        try {
            while (true) {
                integers.add(intBuffer.get());
            }
        } catch (BufferUnderflowException e) {
            // End of buffer reached
        }
        return integers;
    }

    // Method to display the integers read from the buffer
    private static void displayIntegers(List<Integer> integers) {
        System.out.println("Number of integers read = " + integers.size());
        integers.forEach(System.out::println);
    }
}
