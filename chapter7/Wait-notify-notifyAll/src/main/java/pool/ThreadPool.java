package pool;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author evrnsky
 * @version 0.1
 * @since 23.11.2016
 * Pool of thread is some thread is free it start.
 * Init with count of available processors.
 */
public class ThreadPool {

    /**
     * Count of CPU in system.
     */
    private static final int CPU = Runtime.getRuntime().availableProcessors();

    /**
     * Logger. Use it if behing System.out.
     */
    private static final Logger LOG = Logger.getLogger(ThreadPool.class);

    /**
     * Pool of threads.
     */
    private final Queue<Work> pool;

    /**
     * Init a new pool with given capacity.
     */
    public ThreadPool() {
        this.pool = new ArrayBlockingQueue<>(CPU);
    }

    /**
     * Add new instance of work class to the end of the pool.
     * @param work instance of work class. It should execute async task.
     */
    public void addWork(Work work) {
        synchronized (this.pool) {
            LOG.log(Level.INFO, String.format("%s add data to the pool.", Thread.currentThread().getName()));
            this.pool.add(work);
            this.pool.notifyAll();
        }
    }

    /**
     * Execute threads from pool. If poll is empty wait before it became
     * not empty and signal about that all right. Otherwise if poll is not empty,
     * take all not null threads from the pool and start it.
     */
    public void execute() {
        synchronized (this.pool) {
            while (this.pool.isEmpty()) {
                try {
                    LOG.log(Level.INFO, String.format("%s wait data from the pool.", Thread.currentThread().getName()));
                    this.pool.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }

            Work work = null;
            while ((work = this.pool.poll()) != null) {
                LOG.log(Level.INFO, String.format("%s start execute async task.", Thread.currentThread().getName()));
                new Thread(work).start();
            }
        }
    }

    /**
     * Entry point of application.
     * @param args key for start.
     */
    public static void main(String[] args) {
        new ThreadPool().start();
    }

    /**
     * Main loop of program.
     */
    private void start() {
        ThreadPool simplePool = new ThreadPool();

        /**
         * Publish our async task to the thread pool.
         */
        Thread publisher = new Thread() {
            @Override
            public void run() {
                simplePool.addWork(new Work());
                simplePool.addWork(new Work());
            }
        };

        /**
         * It takes from the pool async task and start it.
         */
        Thread starter = new Thread() {
            @Override
            public void run() {
                simplePool.execute();
            }
        };

        publisher.start();
        starter.start();
    }

}

