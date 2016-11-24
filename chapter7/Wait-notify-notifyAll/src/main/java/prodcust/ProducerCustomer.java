package prodcust;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @author evrnsky
 * @version 0.1
 * @since 23.11.2016
 */
public class ProducerCustomer {

    /**
     * Default capacity of the queue, count choosed by suggestions.
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(ProducerCustomer.class);

    /**
     * Blocking queue it what you need for concurrency code.
     */
    private BlockingQueue<String> queue;

    /**
     * It will add to the queue.
     */
    private long time = 1L;

    /**
     * Create a new producer customer template.
     */
    public ProducerCustomer() {
        this.queue = new ArrayBlockingQueue<>(DEFAULT_CAPACITY);
    }

    /**
     * Producer method which produce data to the queue.
     */
    public void add() {
        synchronized (this.queue) {
            this.time = System.currentTimeMillis();
            LOG.log(Level.INFO, String.format("%s put %s at the queue", Thread.currentThread().getName(), this.time));
            this.queue.add(String.format("%s", this.time));
            this.queue.notifyAll();
        }
    }

    /**
     * Customer method which takes data from queue, and wait data if queue is empty.
     */
    public void poll() {
        synchronized (this.queue) {
            while (this.queue.isEmpty()) {
                LOG.log(Level.INFO, String.format("%s %s", Thread.currentThread().getName(), "wait for producer add data"));
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LOG.log(Level.INFO, String.format("%s %s %s", Thread.currentThread().getName(), "take data from queue. That is", queue.poll()));
        }
    }

    /**
     * Entry point of application.
     * @param args keys for start.
     */
    public static void main(String[] args) {
        new ProducerCustomer().demo();
    }

    /**
     * Create all customer and producer threads and start it.
     */
    private void demo() {
        ProducerCustomer template = new ProducerCustomer();
        Thread producer = new Thread() {
            @Override
            public void run() {
                template.add();
            }
        };

        Thread customer = new Thread() {
            @Override
            public void run() {
                template.poll();
            }
        };

        producer.start();
        customer.start();
    }
}

