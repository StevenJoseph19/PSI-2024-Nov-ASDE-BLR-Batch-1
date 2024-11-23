//### **Writing with CompletionHandler**
//        1. Opens the file asynchronously for writing, creating it if necessary.
//        2. Wraps data into a `ByteBuffer`.
//        3. Uses `CompletionHandler` to handle write operation outcomes:
//        - Logs the number of bytes written on success.
//        - Logs an error message on failure.
//        4. The main thread continues running without waiting for the write operation to complete.
//
//        **Purpose:** Illustrates a callback mechanism for managing asynchronous writes, providing immediate response handling.

package com.example.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteCompletionHandlerExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.wrap("Hello, Async World!".getBytes());
            channel.write(buffer, 0, null, new CompletionHandler<>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("Bytes written: " + result);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.err.println("Write failed: " + exc.getMessage());
                }
            });

            System.out.println("Continuing with other tasks...");
            Thread.sleep(2000); // Keep the program alive to wait for completion
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
