package model;

import collection.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementation of set based on linked list.
 * @param <T> specify type.
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
        if (!this.contains(t)) {
            this.list.add(t);
            added = true;
        }
        this.innerIterator = this.list.iterator();
        return added;
    }

    /**
     * Check that given object already in collection.
     * @param o object for checking.
     * @return true if already in collection, otherwise false.
     */
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    /**
     * Return a capacity of list.
     * @return capacity of list.
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Remove object from collection.
     * @param object for removing.
     * @return object which was removed.
     */
    public T remove(Object object) {
        Optional<T> removed = Optional.empty();
        if (!this.contains(object)) {
            throw new NoSuchElementException("Element not exist at the set");
        } else {
            for (int index = 0; index < this.list.size(); index++) {
                if (this.list.get(index).equals(object)) {
                    removed = Optional.of(this.list.remove(index));
                    break;
                }
            }
        }

        if (!removed.isPresent())  {
            throw new NoSuchElementException("Element not exist at the set");
        }
        return removed.get();
    }

    /**
     * Return true if iterator have yet object.
     * @return true if iterator have yet object otherwise false.
     */
    @Override
    public boolean hasNext() {
        return (this.innerIterator != null) && (this.innerIterator.hasNext());
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
