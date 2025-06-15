package tainv.example;

import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger logger = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = args.length > 0 ? args[0] : null;
        if (text != null && !text.isEmpty()) {
            logger.info("Text is not empty");
        }

    }
}
