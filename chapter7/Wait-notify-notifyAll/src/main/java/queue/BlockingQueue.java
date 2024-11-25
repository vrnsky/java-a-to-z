package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author evrnsky
 * @version 0.1
 * @since 23.11.2016
 * @param <T> type of data which may contain this queue.
 * This is thread safe queue. It blocks access to the storage of objects.
 * Thread safe provide by synchronize blocks on the inner lock.
 */
public class BlockingQueue<T> {

    /**
     * Instance of logger.
     */
    private static final Logger log = LoggerFactory.getLogger(BlockingQueue.class);

    /**
     * Head of the queue.
     */
    private static final int HEAD_OF_THE_QUEUE = 0;

    /**
     * List of objects.
     */
    private ArrayList<T> objects;

    /**
     * Lock for concurrent access to the objects in the queue.
     */
    private final Object lock = new Object();

    /**
     * Tail of the objects.
     */
    private int tail;

    /**
     * Create a new queue with given capacity.
     * @param capacity count of elements which may store queue.
     */
    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Count of queue must be big that zero");
        }
        this.objects = new ArrayList<>(capacity);
        this.tail = capacity;
    }

    /**
     * Add element to the tail of the queue.
     * @param data object for adding.
     */
    public void add(T data) {
        synchronized (lock) {
            if (this.tail == 0) {
                this.tail++;
                this.objects.add(data);
                log.info("Now all threads get signal about resource is free.");
                lock.notifyAll();
            } else if (this.tail != this.objects.size()) {
                this.objects.add(data);
                log.info("Now all threads get signal about resource is free.");
                this.lock.notifyAll();
            } else {
                throw new IllegalStateException("Queue is full.");
            }
        }
    }

    /**
     * Return head of the queue.
     * @return element at the head of the queue.
     */
    public T poll() {
        T data = null;
        synchronized (lock) {
            while (this.isEmpty()) {
                try {
                    log.info("Wait until producer put data to the queue.");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data = this.objects.get(HEAD_OF_THE_QUEUE);
            this.objects.remove(HEAD_OF_THE_QUEUE);
            this.objects.trimToSize();
            tail = this.objects.size();
            return data;
        }
    }


    /**
     * Return size of this object.
     * @return count of elements in the queue.
     */
    public int size() {
        synchronized (this.lock) {
            return this.objects.size();
        }
    }

    /**
     * Return true if the queue is empty, otherwise false.
     *
     * @return true if the queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        synchronized (this.lock) {
            return this.objects.isEmpty();
        }
    }


}

