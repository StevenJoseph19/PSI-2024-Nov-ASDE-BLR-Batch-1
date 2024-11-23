//### **Reading with Future**
//        1. Opens the file asynchronously for reading.
//        2. Allocates a `ByteBuffer` to store the data being read.
//        3. Initiates a non-blocking read operation that returns a `Future`.
//        4. Uses a loop to perform other tasks while the read is in progress.
//        5. Once the read completes, retrieves the result and processes the data.
//
//        **Purpose:** Demonstrates how `Future` can be used to track the progress of an
//        asynchronous read operation without blocking the main thread.

package com.example.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FileReadFutureExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> result = channel.read(buffer, 0);

            while (!result.isDone()) {
                System.out.println("Doing other work...");
            }

            int bytesRead = result.get();
            buffer.flip();
            System.out.println("Bytes read: " + bytesRead);
            System.out.println("Data: " + new String(buffer.array(), 0, bytesRead));
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
