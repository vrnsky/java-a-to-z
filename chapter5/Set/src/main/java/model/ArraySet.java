package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of set based on array.
 * @param <T> specify type.
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
     * Default capacity of using array.
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Default constructor.
     */
    public ArraySet() {
        this(DEFAULT_CAPACITY);
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
        if (this.needEnsureCapacity()) {
            this.ensureCapacity();
        }
        if (!contains(value)) {
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
        for (int index = 0; index < this.values.length; index++) {
            Object current = this.values[index];
            if (current != null) {
                T castedObject = (T) current;
                if (castedObject.equals(value))  {
                    contains = true;
                }
            }
        }
        return contains;
    }

    /**
     * Return a capacity of using array.
     * @return length of array.
     */
    public int capacity() {
        return this.values.length;
    }

    /**
     * Return count of element at array.
     * @return count of element at array.
     */
    public int size() {
        return this.index - 1;
    }

    /**
     * Remove object from collection.
     * @param object for removing.
     * @return object which was removed.
     */
    public T remove(Object object) {
        T removed = null;
        if (!this.contains((T) object)) {
            throw new NoSuchElementException("Given element not exist at the set");
        } else {
            for (int index = 0; index < this.values.length; index++) {
               T castedObject = (T) this.values[index];
               removed = castedObject;
                if (castedObject != null) {
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
     * Check that array fill over 75 per cent.
     * @return true if store fill over by 75 per cent, otherwise false.
     */
    private boolean needEnsureCapacity() {
        return this.size() > this.values.length * 3 / 4;
    }

    /**
     * Ensure capacity of using array.
     */
    private void ensureCapacity() {
        int newCapacity = (this.values.length * 3 / 2) + 1;
        Object[] newValues = new Object[newCapacity];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        this.values = newValues;
    }
    /**
     * Check that have yet element at the array.
     * @return true if cursor smaller than length.
     */
    @Override
    public boolean hasNext() {
        return this.cursor != this.values.length && this.size() >= 0;
    }

    /**
     * Return element from array. Notice this method may return null value.
     * @return element from array, maybe null.
     */
    @Override
    public T next() {
        return (T) this.values[cursor++];
    }
}
