import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Create a Logger instance using SLF4J
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Test different log levels
        logger.trace("This is a TRACE level message");
        logger.debug("This is a DEBUG level message");
        logger.info("This is an INFO level message");
        logger.warn("This is a WARN level message");
        logger.error("This is an ERROR level message");

        // Simulate an exception log
        try {
            throw new RuntimeException("Test exception");
        } catch (Exception e) {
            logger.error("Exception occurred: ", e);
        }
    }
}
