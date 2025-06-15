package tainv.example;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLInjectionExample {
    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR 1=1";
        String query = "SELECT username, email FROM users WHERE username = ?";
        String dbUser = System.getenv("DB_USER");
        String dbPass = System.getenv("DB_PASS");

        try (Connection conn = DriverManager.getConnection("jdbc:yourdb", dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userInput);
            logger.log(Level.INFO, "Executing query: {0}", stmt);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error", e);
        }
    }
}
