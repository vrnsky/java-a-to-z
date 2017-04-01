package collection;

/**
 * Contract for containers.
 * @param <T> specify which type may store container.
 */
public interface SimpleContainer<T> extends Iterable<T> {

    /**
     * Return element from collection.
     * @param position number of wished element.
     * @return element from collection.
     */
    T get(int position);

    /**
     * Add new element to collection.
     * @param value for adding.
     * @return true if added.
     */
    boolean add(T value);

    /**
     * Remove from collection.
     * @param position of removed element.
     * @return true if removed, otherwise false.
     */
    T remove(int position);

    /**
     * Check that given object contains at the collection.
     * @param o object for checking.
     * @return true if object already in collection, otherwise false.
     */
    boolean contains(Object o);

    /**
     * Return size of collection.
     * @return size of collection.
     */
    int size();
}
