package service;

/**
 * Model of storage which determine how to data hold and access to all value at the array.
 * @author evrnsky
 * @version 1.0.
 */
public abstract class AbstractStorage<T> implements Store {

    /**
     * At this place hold all values.
     */
    private SimpleArray<T> values;

    /**
     * Construct new storage with given capacity.
     * @param capacity size of simple array.
     */
    public AbstractStorage(int capacity) {
        this.values = new SimpleArray<>(capacity);
    }

    /**
     * Default constructor.
     */
    public AbstractStorage() {
        this(10);
    }

    /**
     * Add new value to the simple array.
     * @param value object which will insert to the simple array.
     */
    public void add(T value) {
        this.values.add(value);
    }

    /**
     * Return value from simple array placed at the position.
     * @param position pointer to data.
     * @return value placed at the given position.
     */
    public T get(int position) {
        return this.values.get(position);
    }

    /**
     * Remove value from simple array placed at the given position.
     * @param position from this place value will delete.
     */
    public void remove(int position) {
        this.values.delete(position);
    }

    /**
     * Update value which already in simple array.
     * @param position at this position value will be update.
     * @param value new version of value.
     */
    public void update(int position, T value) {
        this.values.update(position, value);
    }


}
