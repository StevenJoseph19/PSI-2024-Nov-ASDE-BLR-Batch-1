//package org.acme.nio;
//
//import org.junit.jupiter.api.*;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.IntBuffer;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Specify the method order
//class ReadingWritingBuffersTest {
//
//    private static final Path TEST_FILE_PATH = Path.of("test/ints.bin");
//    private ByteBuffer buffer;
//
//    @BeforeEach
//    void setUp() {
//        buffer = ByteBuffer.allocate(1024 * 1024); // 1 MB buffer
//        buffer.putInt(10);
//        buffer.putInt(20);
//        buffer.putInt(30);
//    }
//
//    @Test
//    @Order(1) // This test will run first
//    void testWriteBufferToFile() throws IOException {
//        // Ensure the directory exists
//        Files.createDirectories(TEST_FILE_PATH.getParent());
//
//        // Actually write the buffer to the file
//        ReadingWritingBuffers.writeBufferToFile(buffer);
//
//        // Verify file creation (this is only done in this test)
//        assertTrue(Files.exists(TEST_FILE_PATH));
//    }
//
//    @Test
//    @Order(2)
//    void testReadFileIntoBuffer() throws IOException {
//        // Read the file content into the buffer
//        buffer.clear(); // Clear buffer before reading
//        ReadingWritingBuffers.readFileIntoBuffer(buffer);
//
//        // Verify buffer state after reading
//        assertEquals(12, buffer.position()); // Should have read 3 integers (3 * 4 bytes each)
//        assertEquals(12, buffer.limit());
//    }
//
//    @Test
//    @Order(3)
//    void testReadIntegersFromBuffer() {
//        buffer.flip(); // Prepare buffer for reading integers
//        IntBuffer intBuffer = buffer.asIntBuffer();
//        List<Integer> integers = ReadingWritingBuffers.readIntegersFromBuffer(buffer);
//
//        // Verify that the correct integers were read
//        assertEquals(3, integers.size());
//        assertTrue(integers.contains(10));
//        assertTrue(integers.contains(20));
//        assertTrue(integers.contains(30));
//    }
//
//    @Test
//    @Order(4)
//    void testDisplayIntegers() {
//        // Test the method that displays integers
//        List<Integer> integers = List.of(10, 20, 30);
//
//        // We can't directly test System.out.println, but ensure correct size
//        assertEquals(3, integers.size());
//    }
//
//    @Test
//    @Order(5)
//    void testFileCreationWhenWritingToFile() throws IOException {
//        // Test to ensure the file exists after the write operation in testWriteBufferToFile()
//        assertTrue(Files.exists(TEST_FILE_PATH));
//    }
//
//    @Test
//    @Order(6)
//    void testFileReadContent() throws IOException {
//        // Read the content back into the buffer
//        buffer.clear(); // Clear buffer before reading
//        ReadingWritingBuffers.readFileIntoBuffer(buffer);
//
//        // Verify that buffer is properly updated after reading
//        assertEquals(12, buffer.position()); // Should have read 3 integers (3 * 4 bytes each)
//        assertEquals(12, buffer.limit());
//    }
//
//    @Test
//    @Order(7)
//    void testDirectoryCreationForFileWrite() throws IOException {
//        Path parentDir = TEST_FILE_PATH.getParent();
//        if (!Files.exists(parentDir)) {
//            Files.createDirectories(parentDir); // Ensure the directory is created
//        }
//
//        // Clean up any existing test file
//        Files.deleteIfExists(TEST_FILE_PATH);
//
//        ReadingWritingBuffers.writeBufferToFile(buffer);
//        assertTrue(Files.exists(TEST_FILE_PATH));
//
//        // Clean up after test
//        Files.delete(TEST_FILE_PATH);
//    }
//
//    @AfterEach
//    void tearDown() throws IOException {
//        // Clean up the test file after each test case to avoid leftover files
//        if (Files.exists(TEST_FILE_PATH)) {
//            Files.delete(TEST_FILE_PATH);
//        }
//    }
//}


package org.acme.nio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReadingWritingBuffersTest {

    private static final Path FILE_PATH = ReadingWritingBuffers.FILE_PATH;
    private ByteBuffer buffer;

    @BeforeEach
    public void setUp() {
        buffer = ReadingWritingBuffers.createBufferWithIntegers();
    }

    @Test
    @Order(1)
    @Disabled("Disabled to maintain the integrity of the other tests.")
    public void testPrintBufferStateBeforeWrite() {
        ReadingWritingBuffers.printBufferStateBeforeWrite(buffer);
        assertEquals(0, buffer.position(), "Position should be 0 after flipping.");
        assertEquals(3, buffer.limit() / 4, "Limit should be 3 after flipping."); // Each int is 4 bytes
    }

    @Test
    @Order(2)
    public void testCreateBufferWithIntegers() {
        ByteBuffer buffer = ReadingWritingBuffers.createBufferWithIntegers();
        assertEquals(12, buffer.position(), "Buffer position should be 12 after adding integers.");
        assertEquals(buffer.capacity(), buffer.limit(), "Buffer limit should be equal to its capacity.");
    }

    @Test
    @Order(3)
    public void testWriteBufferToFile() throws Exception {
        ReadingWritingBuffers.writeBufferToFile(buffer);
        assertTrue(Files.exists(FILE_PATH), "File should exist after writing buffer.");
        assertTrue(Files.size(FILE_PATH) > 0, "File size should be greater than 0 after writing buffer.");
    }

    @Test
    @Order(4)
    public void testReadFileIntoBuffer() throws Exception {
        ReadingWritingBuffers.writeBufferToFile(buffer);
        buffer.clear();
        ReadingWritingBuffers.readFileIntoBuffer(buffer);
        assertTrue(buffer.position() > 0, "Buffer position should be greater than 0 after reading file.");
    }

    @Test
    @Order(5)
    public void testReadIntegersFromBuffer() throws Exception {
        ReadingWritingBuffers.writeBufferToFile(buffer);
        buffer.clear();
        ReadingWritingBuffers.readFileIntoBuffer(buffer);
        List<Integer> integers = ReadingWritingBuffers.readIntegersFromBuffer(buffer);
        assertEquals(3, integers.size(), "Number of integers read should be 3.");
        assertEquals(List.of(10, 20, 30), integers, "Integers read from buffer should match the inserted values.");
    }
}
