package tainv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        String s = null;
        try {
            logger.info("String length: {0}"); // This will throw NullPointerException
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "NullPointerException occurred: {0}", e.getMessage());
        }
    }
}
