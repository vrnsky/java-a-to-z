package list;

import collection.SimpleContainer;

import java.util.Iterator;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.11.2016
 * @param <T> type of holding object.
 * ThreadSafe list.
 */
public class SynchronizedList<T> {

    /**
     * Instance of simple container interface.
     */
    private SimpleContainer<T> list;

    /**
     * Create a new synchronized list by accept simple container interface.
     * @param container instance of simple container interface.
     */
    public SynchronizedList(SimpleContainer<T> container) {
        this.list = container;
    }

    /**
     * Add value to the end of list.
     * @param value object for adding.
     * @return true if all success, otherwise false.
     */
    public synchronized boolean add(T value) {
        return this.list.add(value);
    }

    /**
     * Return object from list.
     * @param index position of object.
     * @return object from list.
     */
    public synchronized T get(int index) {
        return this.list.get(index);
    }

    /**
     * Remove object which position is equals index.
     *
     * @param index position of removing object.
     * @return removed object.
     */
    public synchronized T remove(int index) {
        return this.list.remove(index);
    }

    /**
     * Check that given object in already in list.
     * @param object for checking.
     * @return true if object already in list.
     */
    public synchronized boolean contains(T object) {
        return this.list.contains(object);
    }

    /**
     * Return size of list.
     * @return size of list.
     */
    public synchronized int size() {
        return this.list.size();
    }

    /**
     * Return iterator from list.
     * @return iterator object.
     */
    public synchronized Iterator<T> iterator() {
        return this.list.iterator();
    }
}
