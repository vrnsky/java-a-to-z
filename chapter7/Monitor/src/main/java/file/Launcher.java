package file;

import java.io.File;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.11.2016
 * Launcher for searching text at the file system.
 */
public class Launcher {

    /**
     * Entry point of application.
     * @param args text for search.
     */
    public static void main(String[] args) {
        new Launcher().start(args);
    }

    /**
     * Start main loop of program.
     * @param args text for search.
     */
    public void start(String[] args) {
        StringBuffer buffer = new StringBuffer();
        for(String arg : args) {
            buffer.append(String.format("%s ", arg));
        }
        Application app = new Application(buffer.toString().trim());
        app.start();
    }
}
