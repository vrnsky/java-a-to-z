package async;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.10.2016
 * Demo for show problem with concurrency in java.
 */
public class SharedObjectProblem {

    /**
     * Field which each thread must update.
     */
    private static int counter = 0;

    /**
     * Entry point of application.
     * @param args keys for app.
     */
    public static void main(String[] args) {
        new SharedObjectProblem().start();
    }

    /**
     * All logic at this method.
     */
    public void start() {
        final int threads = 10;
        for (int index = 0; index < threads; index++) {
            Thread thread = new Thread(() -> counter++);
            thread.start();
        }
        System.out.printf("At the finish: %s", counter);
    }
}
