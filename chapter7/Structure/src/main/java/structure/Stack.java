package structure;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.12.2016
 * @param <T> specify which type may store this class.
 */
public class Stack<T> {

    /**
     * Reference to the head.
     */
    private final AtomicReference<Element<T>> head = new AtomicReference<>(null);

    /**
     * Add new element to the end.
     * @param value for adding.
     */
    public void push(T value) {
        Element newHead = new Element();
        newHead.value = value;
        Element oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    /**
     * Pop element from start.
     * @return first element.
     */
    public T pop() {
        Element oldHead = null;
        Element newHead = null;
        T result = null;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                result = null;
            } else {
                newHead = oldHead.next;
            }
        } while (!head.compareAndSet(oldHead, newHead));

        return (T) oldHead.value;
    }

    /**
     * Describe element for coherence between elements.
     * @param <T> specify which type may store element.
     */
    private static class Element<T> {
        /**
         * Value.
         */
        private T value;

        /**
         * Reference to the next element.
         */
        private Element next;
    }
}
