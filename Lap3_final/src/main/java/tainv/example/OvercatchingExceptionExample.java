package tainv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            logger.info("Array value: {0}", arr[10]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Array index out of bounds: {0}", e.getMessage());
        }
    }
}
