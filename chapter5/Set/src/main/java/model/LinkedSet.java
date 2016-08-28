package model;

import collection.LinkedList;
import java.util.Iterator;

/**
 * Implementation of set based on linked list.
 */
public class LinkedSet<T> implements Iterator<T> {

    /**
     * Storage for objects.
     */
    private LinkedList<T> list;

    /**
     * Inner iterator for correct moving across set.
     */
    private Iterator<T> innerIterator;

    /**
     * Default constructor.
     */
    public LinkedSet() {
        this.list = new LinkedList<>();
    }

    /**
     * Add value to the set. Only unique value. Update reference to th iterator.
     * @param t value which will add
     * @return true if value was added, otherwise false.
     */
    public boolean add(T t) {
        boolean added = false;
        if(!this.list.contains(t)) {
            this.list.add(t);
            added = true;
        }
        this.innerIterator = this.list.iterator();
        return added;
    }

    /**
     * Return true if iterator have yet object.
     * @return true if iterator have yet object otherwise false.
     */
    @Override
    public boolean hasNext() {
        return this.innerIterator.hasNext();
    }

    /**
     * Return value from set.
     * @return if iterator have yet element return value from set.
     */
    @Override
    public T next() {
        return this.innerIterator.next();
    }
}
