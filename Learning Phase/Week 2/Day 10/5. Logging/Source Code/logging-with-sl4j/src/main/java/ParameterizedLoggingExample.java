import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "JohnDoe";
        int userId = 12345;

        // Traditional string concatenation (not recommended for performance reasons)
        logger.info("User {} with ID {} has logged in.", userName, userId);

        // Parameterized logging (efficient and preferred)
        logger.info("User {} with ID {} has logged in.", userName, userId);

        // More complex example: Logging an exception
        try {
            throw new RuntimeException("Something went wrong");
        } catch (RuntimeException e) {
            // Parameterized logging with exception
            logger.error("Error occurred for user {} with ID {}: {}", userName, userId, e.getMessage(), e);
        }
    }
}
