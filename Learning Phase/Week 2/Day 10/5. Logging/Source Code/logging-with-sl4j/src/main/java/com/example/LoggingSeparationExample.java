package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSeparationExample {

    // Define a logger for the class
    private static final Logger logger = LoggerFactory.getLogger(LoggingSeparationExample.class);

    public static void main(String[] args) {
        // Info-level log, will go to application.log
        logger.info("This is an application-level log");

        // Error-level log, will go to error.log (based on the configuration)
        try {
            throw new RuntimeException("Something went wrong!");
        } catch (RuntimeException e) {
            logger.error("Error occurred: {}", e.getMessage(), e);
        }
    }
}
