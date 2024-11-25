package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

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
    private static final Logger log = LoggerFactory.getLogger(ProducerCustomer.class.getSimpleName());

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
        log.info("{} {}", "Now push to the end of queue is", number.get());
        queue.add(String.format("%s", number.get()));
        number.incrementAndGet();
    }

    /**
     * Consume method which takes data from the head of the queue.
     */
    public void consume() {
        String item = queue.poll();
        if (item != null) {
            log.info("Received from producer: {}", item);
        } else {
            log.warn("Received a null from queue");
        }
    }

    /**
     * Entry point of app.
     *
     * @param args keys for app.
     */
    public static void main(String[] args) {
        ProducerCustomer template = new ProducerCustomer();
        Runnable producer = template::produce;

        Runnable consumer = template::consume;

        Thread publisher = new Thread(producer);
        Thread subscriber = new Thread(consumer);

        subscriber.start();
        publisher.start();
    }
}
