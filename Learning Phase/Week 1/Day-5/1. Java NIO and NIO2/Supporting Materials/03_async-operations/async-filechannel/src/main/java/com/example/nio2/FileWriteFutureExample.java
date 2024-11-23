//### **Writing with Future**
//        1. Opens the file asynchronously for writing, creating it if it doesn't exist.
//        2. Wraps data into a `ByteBuffer` for writing.
//        3. Initiates a non-blocking write operation, returning a `Future`.
//        4. Checks the `Future` periodically until the write completes.
//        5. Retrieves the result and logs the number of bytes written.
//
//        **Purpose:** Demonstrates how `Future` can be used to manage asynchronous file writes,
//        allowing other tasks to execute while waiting for the operation to finish.


package com.example.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FileWriteFutureExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.wrap("Hello, Async World!".getBytes());
            Future<Integer> result = channel.write(buffer, 0);

            while (!result.isDone()) {
                System.out.println("Writing in progress...");
            }

            System.out.println("Bytes written: " + result.get());
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
