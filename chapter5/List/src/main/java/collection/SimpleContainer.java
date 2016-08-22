package collection;

/**
 * Contract for containers.
 */
public interface SimpleContainer<T> extends Iterable<T> {

    T get(int position);
    boolean add(T value);
    T remove(int position);
    boolean contains(Object o);
}
