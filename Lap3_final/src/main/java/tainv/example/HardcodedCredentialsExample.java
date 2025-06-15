package tainv.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {
    private static final Logger logger = Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        // Read username and password from environment variables or configuration file (simple example)
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (authenticate(username, password)) {
            logger.info("Access granted");
        } else {
            logger.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        // This is just an example; in practice, validation should be done via a database or a secure authentication system
        String validUser = System.getenv("APP_USERNAME");
        String validPass = System.getenv("APP_PASSWORD");
        return user != null && pass != null && user.equals(validUser) && pass.equals(validPass);
    }
}
