package async;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 * Simple thread which increment value at the counter object.
 */
public class CounterThread extends Thread {

    /**
     * Instance of counter object.
     */
    public Counter counter;

    /**
     * Default constructor.
     * @param counter reference to counter object.
     */
    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    /**
     * Async task.
     */
    public void run() {
        counter.increment();
    }
}
