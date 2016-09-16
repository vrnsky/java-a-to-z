package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 */
public class Splitter {

    /**
     * Pool of fixed thread - count of thread determine at the runtime.
     */
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Orders book.
     */
    private Map<String, HashMap<Integer, Order>> orders;

    /**
     * Construct new splitter by give it order book.
     * @param orders storage which determine as order book.
     */
    public Splitter(Map<String, HashMap<Integer, Order>> orders) {
        this.orders = orders;
    }

    /**
     * Parallel calculation for right position order in books.
     * @throws ExecutionException if some problem with pool of thread.
     * @throws InterruptedException if some problem with pool of thread.
     */
    public void match() throws ExecutionException, InterruptedException {
        List<Future<Book>> futures = new ArrayList<>(orders.size());
        for(HashMap<Integer, Order> list : orders.values()) {
            futures.add(EXECUTOR.submit(() -> {
                Book book = new Book(list.values());
                book.calculate();
                return book;
            }));
        }
        for(Future<Book> future : futures) {
            future.get();
        }
        EXECUTOR.shutdown();
    }
}