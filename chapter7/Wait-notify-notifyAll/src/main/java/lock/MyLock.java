package lock;

/**
 * @author evrnsky
 * @version 0.1
 * @since 29.11.2016
 * It is a simple lock for concurrent access to the some resource.
 */
public class MyLock {

    /**
     * Inner lock uses for wait and notifyAll.
     */
    private final Object lock = new Object();

    /**
     * Flag which signal about thread must wait.
     */
    private boolean wait = false;

    /**
     * Lock access to some resource.
     */
    public void lock() {
        synchronized (this.lock) {
            while (this.wait) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.wait = true;
        }
    }

    /**
     * Unlock access to some resources.
     */
    public void unlock() {
        synchronized (lock) {
            this.wait = false;
            this.lock.notifyAll();
        }
    }
}
