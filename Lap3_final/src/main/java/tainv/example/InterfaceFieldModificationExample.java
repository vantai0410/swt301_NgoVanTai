package tainv.example;

import java.util.logging.Logger;

final class Constants {
    public static final int MAX_USERS = 100;

    private Constants() {
        // Prevent instantiation
    }
}

public class InterfaceFieldModificationExample {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(InterfaceFieldModificationExample.class.getName());
        // Usage:
        // Constants.MAX_USERS = 200; // Still a compile-time error (as it should be)
        logger.info("MAX_USERS: {0}");

    }
}
