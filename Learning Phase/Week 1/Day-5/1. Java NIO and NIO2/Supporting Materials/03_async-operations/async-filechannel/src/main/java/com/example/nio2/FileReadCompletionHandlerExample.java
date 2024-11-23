//### **Reading with CompletionHandler**
//        1. Opens the file asynchronously for reading.
//        2. Allocates a `ByteBuffer` for storing the data.
//        3. Uses `CompletionHandler` to handle the read operation’s success or failure:
//        - On success, processes the data from the buffer.
//        - On failure, logs an error message.
//        4. The main thread can perform other tasks while the read operation completes in the background.
//
//        **Purpose:** Showcases a callback-based approach for handling asynchronous read operations,
//        which is more efficient for handling multiple I/O tasks.
//


package com.example.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadCompletionHandlerExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer, 0, null, new CompletionHandler<>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    buffer.flip();
                    System.out.println("Bytes read: " + result);
                    System.out.println("Data: " + new String(buffer.array(), 0, result));
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.err.println("Read failed: " + exc.getMessage());
                }
            });

            System.out.println("Continuing with other tasks...");
            Thread.sleep(2000); // Keep the program alive to wait for completion
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
