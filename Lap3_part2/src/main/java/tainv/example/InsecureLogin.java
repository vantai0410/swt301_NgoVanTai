package tainv.example;

import java.util.logging.Logger;

public class InsecureLogin {
    private static final Logger logger = Logger.getLogger(InsecureLogin.class.getName());

    public static void login(String username, String password) {
        String adminPassword = System.getenv("ADMIN_PASSWORD");
        if (adminPassword == null) {
            adminPassword = System.getProperty("ADMIN_PASSWORD");
        }
        
        if (username.equals("admin") && password.equals(adminPassword)) {
            logger.info("Login successful");
        } else {
            logger.warning("Login failed");
        }
    }

    public void printUserInfo(String user) {
        if (user != null && !user.isEmpty()) {
            logger.info("User: " + user);
        }
    }

}
