package tainv.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

class InsureLoginTest {
    private ByteArrayOutputStream logCaptor;
    private Handler handler;
    private Logger logger;
    
    @BeforeEach
    void setUp() {
        logCaptor = new ByteArrayOutputStream();
        handler = new StreamHandler(logCaptor, new java.util.logging.SimpleFormatter());
        logger = Logger.getLogger(InsecureLogin.class.getName());
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }
    
    @AfterEach
    void tearDown() {
        logger.removeHandler(handler);
        handler.close();
    }

    @Test
    void testLoginSuccess() {
        // Set environment variable for test
        System.setProperty("ADMIN_PASSWORD", "123456");
        
        InsecureLogin.login("admin", System.getProperty("ADMIN_PASSWORD"));
        handler.flush();
        
        String logOutput = logCaptor.toString();
        assertTrue(logOutput.contains("Login successful"), "Should log successful login");
    }

    @Test
    void testLoginFail() {
        InsecureLogin.login("user", "wrongpassword");
        handler.flush();
        
        String logOutput = logCaptor.toString();
        assertTrue(logOutput.contains("Login failed"), "Should log failed login");
    }

    @Test
    void testPrintUserInfo() {
        InsecureLogin insecureLogin = new InsecureLogin();
        insecureLogin.printUserInfo("John Doe");
        handler.flush();
        
        String logOutput = logCaptor.toString();
        assertTrue(logOutput.contains("User: John Doe"), "Should log user information");
    }
    
    @Test
    void testPrintUserInfoWithNullUser() {
        InsecureLogin insecureLogin = new InsecureLogin();
        insecureLogin.printUserInfo(null);
        handler.flush();
        
        String logOutput = logCaptor.toString();
        assertFalse(logOutput.contains("User:"), "Should not log null user");
    }
    
    @Test
    void testPrintUserInfoWithEmptyUser() {
        InsecureLogin insecureLogin = new InsecureLogin();
        insecureLogin.printUserInfo("");
        handler.flush();
        
        String logOutput = logCaptor.toString();
        assertFalse(logOutput.contains("User:"), "Should not log empty user");
    }
} 