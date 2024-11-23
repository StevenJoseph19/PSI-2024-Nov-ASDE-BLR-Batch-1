// src/main/java/com/example/moduleb/MessagePrinter.java
package com.example.moduleb;
import com.example.modulea.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MessagePrinter {
    private static final Logger logger = LoggerFactory.getLogger(MessagePrinter.class);
    public static void main(String[] args) {
        MessageService service = new MessageService();
        String message = service.getMessage();
        logger.info("Received message: {}", message);
        System.out.println(message);
    }
}
