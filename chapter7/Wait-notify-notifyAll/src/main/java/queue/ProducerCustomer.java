package queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.11.2016
 * Demo of work thread safe queue.
 */
public class ProducerCustomer {

    /**
     * Instance of logger, show usefully information about program execution.
     */
    private static final Logger LOG = Logger.getLogger(ProducerCustomer.class.getSimpleName());

    /**
     * Instance of blocking queue which provide a thread safe access to the elements.
     */
    private final BlockingQueue<String> queue = new BlockingQueue<>(10);

    /**
     * In this example uses atomic integer as a type of data which hold at the queue.
     */
    private AtomicInteger number = new AtomicInteger(0);

    /**
     * Producer method which put data to the end of the queue.
     */
    public void produce() {
        LOG.info(String.format("%s %s", "Now push to the end of queue is", number.get()));
        queue.add(String.format("%s", number.get()));
        number.incrementAndGet();
    }

    /**
     * Consume method which takes data from the head of the queue.
     */
    public void consume() {
        LOG.info(String.format("%s %s", "Received from producer: ", queue.poll()));
    }

    /**
     * Entry point of app.
     * @param args keys for app.
     * @throws InterruptedException if some problem with threads.
     */
    public static void main(String[] args) throws InterruptedException {
        ProducerCustomer template = new ProducerCustomer();
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                template.produce();
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                template.consume();
            }
        };

        Thread publisher = new Thread(producer);
        Thread subscriber = new Thread(consumer);

        subscriber.start();
        publisher.start();
    }
}
