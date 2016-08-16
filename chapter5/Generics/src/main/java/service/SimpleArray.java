package service;

/**
 * Realization of simple array.
 * @author evrnsky
 * @version 1.0
 */
public class SimpleArray<T> {

    /**
     * Hold all object.
     */
    private Object[] values;

    /**
     * For correct moving across array.
     */
    private int index = 0;

    /**
     * Create a new SimpleArray with given capacity.
     * @param capacity
     */
    public SimpleArray(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Default constructor.
     */
    public SimpleArray() {
        this(10);
    }

    /**
     * Add new value to array, if array is full expand it and insert new element.
     * @param value object for insert.
     */
    public void add(T value) {
        if (!this.validate(this.index)) {
            this.ensureCapacity();
        }
        this.values[this.index++] = value;
    }

    /**
     * Return value at the given position from array.
     * @param position it uses to access for array.
     * @return value which placed at the position at the array.
     */
    public T get(int position) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        return (T) this.values[position];
    }

    /**
     * Update element which exist in array.
     * @param position of old element.
     * @param value new version of value for object array.
     */
    public void update(int position, T value) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        this.values[position] = value;
    }

    /**
     * Remove element at the given position.
     * @param position of remove element.
     */
    public void delete(int position) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        this.values[position] = null;
        this.index--;
    }


    /**
     * Range given values. It check that give value exist between zero and current length of array.
     * @param position number for checking.
     * @return true if value find between zero and length, otherwise false.
     */
    private boolean validate(int position) {
        return ((position >= 0)) && ((position < this.values.length));
    }

    /**
     * Increase capacity for correct inserting new values.
     */
    private void ensureCapacity() {
        int length = (this.values.length * 3) / 2 + 1;
        Object[] expandValues = new Object[length];
        System.arraycopy(this.values, 0, expandValues, 0, this.values.length);
        this.index = this.values.length + 1;
        this.values = expandValues;
    }

    /**
     * Return current size of object in array.
     * @return length of object array.
     */
    public int size() {
        return this.values.length;
    }
}
