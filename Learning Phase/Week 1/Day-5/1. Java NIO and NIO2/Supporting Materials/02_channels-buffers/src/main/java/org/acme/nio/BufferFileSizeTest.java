package org.acme.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class BufferFileSizeTest {

    static final Path FILE_PATH = Paths.get("files/ints.bin");

    public static void main(String[] args) {
        try {
            ByteBuffer buffer = createBufferWithIntegers();
            writeBufferToFile(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ByteBuffer createBufferWithIntegers() {
        // Create a 1 MB buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        buffer.putInt(10);
        buffer.putInt(20);
        buffer.putInt(30);

        System.out.println("Position after adding integers = " + buffer.position());
        System.out.println("Limit after adding integers = " + buffer.limit());

        // Prepare the buffer for reading/writing
        buffer.flip();
        System.out.println("Buffer ready for writing to file:");
        System.out.println("Position = " + buffer.position());
        System.out.println("Limit = " + buffer.limit());
        return buffer;
    }

    static void writeBufferToFile(ByteBuffer buffer) throws IOException {
        System.out.println("Buffer limit before writing to file = " + buffer.limit());

        // Ensure the directory exists
        Files.createDirectories(FILE_PATH.getParent());

        // Open the file channel and write the buffer
        try (FileChannel fileChannel = FileChannel.open(
                FILE_PATH, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            int bytesWritten = fileChannel.write(buffer);
            System.out.println("Bytes actually written = " + bytesWritten);

            // Optional: truncate the file to the actual data size to avoid extra bytes
            fileChannel.truncate(bytesWritten);
        }

        // Check and print the final file size
        System.out.println("File size after writing = " + Files.size(FILE_PATH));
    }
}
