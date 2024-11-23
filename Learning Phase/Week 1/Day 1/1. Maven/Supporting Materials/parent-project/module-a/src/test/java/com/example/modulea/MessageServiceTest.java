// src/test/java/com/example/modulea/MessageServiceTest.java
package com.example.modulea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MessageServiceTest {
    @Test
    public void testGetMessage() {
        com.example.modulea.MessageService service = new com.example.modulea.MessageService();
        assertEquals("Hello from Module A!", service.getMessage());
    }
}
