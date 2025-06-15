package tainv.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger logger = Logger.getLogger(PathTraversalExample.class.getName());

    public static void main(String[] args) throws IOException {
        String baseDir = "/your/base/directory/"; // Set the allowed directory
        String userInput = "../secret.txt"; // This should come from a safe source

        File base = new File(baseDir);
        File file = new File(base, userInput);
        String canonicalBase = base.getCanonicalPath();
        String canonicalFile = file.getCanonicalPath();

        // Validate that the file is within the base directory
        if (!canonicalFile.startsWith(canonicalBase + File.separator)) {
            logger.log(Level.WARNING, "Path traversal attempt detected: {0}", userInput);
            return;
        }

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                logger.log(Level.INFO, "Reading file: {0}", file.getPath());
                // Read file content if needed
            }
        } else {
            logger.warning("File does not exist: " + file.getPath());
        }
    }
}
