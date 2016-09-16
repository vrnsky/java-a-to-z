package start;

import model.Parser;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 */
public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
        new Parser().load();
    }
}