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
    public static int counter = 0;

    /**
     * Entry point of application.
     *
     * @param args
     */
    public static void main(String[] args) {
        new SharedObjectProblem().start();
    }

    /**
     * All logic at this method.
     */
    public void start() {
        for (int index = 0; index < 10; index++) {
            Thread thread = new Thread(() -> counter++);
            thread.start();
        }
        System.out.printf("At the finish: %s", counter);
    }
}
