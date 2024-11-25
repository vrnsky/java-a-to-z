package pool;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * @author evrnsky
 * @version 0.1
 * @since 23.11.2016
 * Pool of thread is some thread is free it start.
 * Init with count of available processors.
 */
public class ThreadPool {

    /**
     * Instance of logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ThreadPool.class);

    /**
     * Boundary for count of thread which may accept this queue.
     */
    private static final int CPU = Runtime.getRuntime().availableProcessors();

    /**
     * Array ot THREADS.
     */
    private static final Thread[] THREADS = new Thread[CPU];

    /**
     * Queue of thread. At this place store runnable of async task.
     */
    private final LinkedList<Runnable> queue = new LinkedList<>();

    /**
     * Create default thread queue.
     */
    public ThreadPool() {
        for (int index = 0; index < CPU; index++) {
            THREADS[index] = new Worker();
            THREADS[index].start();
        }
    }

    /**
     * Add to the end of the list new task.
     * @param runnable new async task.
     */
    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            if (this.queue.size() < CPU) {
                this.queue.addLast(runnable);
                queue.notify();
            }
        }
    }

    /**
     * Worker it execute run method at the endless loop.
     */
    private class Worker extends Thread {
        @Override
        public void run() {
            Runnable r;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            log.info("Pool at this moment is empty and wait task");
                            queue.wait();
                        } catch (InterruptedException e) {
                            log.warn("Thread interrupted while waiting for tasks: {}", e.getMessage());
                            Thread.currentThread().interrupt();
                        }
                    }
                    log.info("Pool going execute head of the list async task.");
                    r = queue.removeFirst();
                }

                try {
                    r.run();
                } catch (RuntimeException ex) { //I know that is bad style, but it needs for check leak THREADS.
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Show demo.
     * @param args key for app.
     */
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        Runnable timer = () -> log.info("Current time: {}", System.currentTimeMillis());
        pool.execute(timer);
    }
}

