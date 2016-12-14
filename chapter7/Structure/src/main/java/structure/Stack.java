package structure;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.12.2016
 */
public class Stack<T> {

    private final AtomicReference<Element<T>> head = new AtomicReference<>(null);

    public void push(T value) {
        Element newHead = new Element();
        newHead.value = value;
        Element oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

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

        return (T)oldHead.value;
    }

    private static class Element<T> {
        private T value;
        private Element next;
    }
}
