package tainv.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());
    public static final int NUMBER = 42;

    public static void main(String[] args) {
        logger.info("Number: {0}", NUMBER);
    }
}
