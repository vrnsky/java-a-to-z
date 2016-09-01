package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of set based on array.
 */
public class ArraySet<T> implements Iterator<T> {

    /**
     * At this place contains all values.
     */
    private Object[] values;

    /**
     * For correct insert new values.
     */
    private int index = 0;

    /**
     * For moving across array using iterator.
     */
    private int cursor = 0;

    /**
     * Default constructor.
     */
    public ArraySet() {
        this(100);
    }

    /**
     * Create a set with given capacity.
     * @param capacity count of numbers which set may hold.
     */
    public ArraySet(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Adding new value to the object array.
     * @param value it is what will add to the array.
     * @return true if object was added, otherwise false.
     */
    public boolean add(T value) {
        boolean added = false;
        if(!contains(value)) {
            this.values[index++] = value;
            added = true;
        }

        return added;
    }

    /**
     * Check that given object contains at the set.
     * @param value object for checking.
     * @return true if object already at the set.
     */
    public boolean contains(T value) {
        boolean contains = false;
        for(int index = 0; index < this.values.length; index++) {
            Object current = this.values[index];
            if(current != null) {
                T castedObject = (T)current;
                if(castedObject.equals(value))  {
                    contains = true;
                }
            }
        }
        return contains;
    }

    /**
     * Return a size of using array.
     * @return length of array.
     */
    public int size() {
        return this.values.length;
    }

    /**
     * Remove object from collection.
     * @param object for removing.
     * @return object which was removed.
     */
    public T remove(Object object) {
        T removed = null;
        if(!this.contains((T)object)) {
            throw new NoSuchElementException("Given element not exist at the set");
        } else {
            for(int index = 0; index < this.values.length; index++) {
               T castedObject = (T)this.values[index];
               removed = castedObject;
                if(castedObject != null) {
                    if (castedObject.equals(object)) {
                        this.values[index] = null;
                        break;
                    }
                }
            }
        }

        return removed;
    }
    /**
     * Check that have yet element at the array.
     * @return true if have yet elements at the array, otherwise false.
     */
    @Override
    public boolean hasNext() {
        return this.cursor != this.values.length;
    }

    /**
     * Return element from array.
     * @return element from array, maybe null.
     */
    @Override
    public T next() {
        return (T)this.values[cursor++];
    }
}
