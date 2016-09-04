package model;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Implementation of set based on array.
 */
public class SortedSet<T> implements Iterator<T> {

    /**
     * At this place hold all values.
     */
    private Object[] values;

    /**
     * For correct inserting new values using this variable.
     */
    private int index = 0;

    /**
     * For correct moving across set using iterator.
     */
    private int cursor = 0;

    /**
     * Default constructor.
     */
    public SortedSet() {
        this(100);
    }

    /**
     * Create new set with given capacity.
     * @param capacity length of objects array.
     */
    public SortedSet(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Return capacity of set. Not count of elements. Its return length of using array.
     * @return length of using array.
     */
    public int capacity() {
        return this.values.length;
    }

    /**
     * Return count of elements at the set.
     * @return -1 if set is have not element, otherwise count of elem. Remember this is zero based set.
     */
    public int size() {
        return this.index - 1;
    }

    /**
     * Adding new value to the set. Set not may hold null value because contains method using hashCode method.
     * First adding to the set execute without checking of contains element because all elements at the set are null.
     * Next adding - before adding new element, element at the array sort and
     * check that element exist at the array by binary search.
     * @param value object for adding.
     * @return true if object was added, otherwise false.
     */
    public boolean add(T value) {
        boolean added = false;
        if(value == null) {
            throw new IllegalArgumentException("This set not may have null value");
        } else if (index >= 0) {
            if(this.values[index] != null) {
                Arrays.sort(this.values);
            }
            if(!this.contains(value)) {
                if(this.needEnsureCapacity()) {
                    this.ensureCapacity();
                }
                this.values[index++] = value;
                added = true;
            }
        }
        return added;
    }

    /**
     * Check that given elem exist at the set.
     * @param value object for checking.
     * @return true if same object already in set, otherwise false.
     */
    public boolean contains(T value) {
        int high = index == 0 ? 0 : index-1;
        return this.binarySearch((T[])values, value, 0, high) != -1;
    }

    /**
     * Binary search for some element.
     * @param values at this place must execute search.
     * @param value search object.
     * @param low range of low bound for searching.
     * @param high range of high bound for searching.
     * @return -1 if value not find, otherwise return hashcode of found object.
     */
    private int binarySearch(T[] values, T value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(value == null || values[mid] == null) {
            return -1;
        }
        if (value.hashCode() < values[mid].hashCode()) {
            return binarySearch(values, value, low, mid - 1);
        } else if (value.hashCode() > values[mid].hashCode()) {
            return binarySearch(values, value, mid + 1, high);
        } else {
            return mid;
        }

    }

    /**
     * Remove value from set.
     * @param value object for removing.
     * @return removed object.
     */
    public T remove(T value) {
        if(!this.contains(value)) {
            throw new IllegalArgumentException("Bad args");
        }
        T removed = null;
        for(int index = 0; index < this.values.length; index++) {
            T casted = (T)this.values[index];
            if(casted != null) {
                if(casted.equals(value)) {
                    removed = (T)this.values[index];
                    this.values[index] = null;
                }
            }
        }

        return removed;
    }

    /**
     * Return true if at the set have elements and cursor smaller that length of storage.
     * @return true if cursor smaller that values.length and if set is not empty.
     */
    @Override
    public boolean hasNext() {
        return this.cursor != this.values.length && this.size() != -1;
    }

    /**
     * Return value from set.
     * @return value from set.
     */
    @Override
    public T next() {
        return (T)this.values[this.cursor++];
    }

    /**
     * Check that storage need increase capacity. If storage filled over 75 per cent should increase capacity.
     * @return true if storage is fill over 75%, otherwise false.
     */
    private boolean needEnsureCapacity() {
        return this.index > this.values.length * 3 / 4;
    }

    /**
     * Ensure capacity of storage.
     */
    private void ensureCapacity() {
        int capacity = (this.values.length * 3 / 2) + 1;
        Object[] newValues = new Object[capacity];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        this.values = newValues;
    }


}