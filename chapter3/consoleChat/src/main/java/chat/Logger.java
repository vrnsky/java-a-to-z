package chat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logger - simple logger object which write data in file.
 */
public class Logger {

    /**
     * For write in file.
     */
    private BufferedWriter logger;

    /**
     * Construct new logger by give it name of file.
     * @param fileName - name of file, in which write data.
     * @throws IOException if file was not found.
     */
    public Logger(String fileName) throws IOException {
        this.logger = new BufferedWriter(new FileWriter(new File(fileName)));
    }

    /**
     * Write data in file.
     * @param log message for writing.
     * @throws IOException if file was not found.
     */
    public void log(String log) throws IOException {
        logger.write(log);
        logger.newLine();
        logger.flush();
    }

    /**
     * Close thread.
     */
    public void close() {
        try {
            logger.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
