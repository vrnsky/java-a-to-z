package start;

import model.Parser;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 *
 * User interface starter.
 */
public class Start {

    /**
     * Star a new app with ui.
     * @param args keys for app.
     * @throws InterruptedException if problem with concurrency.
     * @throws IOException if problem with io.
     * @throws ExecutionException if problem with pool.
     */
    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
        new Parser().load();
    }
}