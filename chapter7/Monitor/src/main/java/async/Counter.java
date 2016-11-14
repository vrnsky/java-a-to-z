package async;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 * Simple thread safe counter.
 */
public class Counter {

    /**
     * Count.
     */
    private AtomicInteger amount;

    /**
     * Default constructor.
     */
    public Counter() {
        this.amount = new AtomicInteger(0);
    }

    /**
     * Increment amount.
     */
    public void increment() {
        synchronized (this) {
            this.amount.incrementAndGet();
        }
    }

    /**
     * Return value save at amount field.
     * @return value.
     */
    public int getAmount() {
        return this.amount.get();
    }
}
