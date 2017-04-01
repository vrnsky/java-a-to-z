package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Resizeable array.
 * @param <T> specify which type may store list.
 */
public class SimpleList<T> implements SimpleContainer<T> {

    /**
     * At this place hold all values.
     */
    private Object[] values;

    /**
     * Pointer for correct adding new elements.
     */
    private int cursor = 0;

    /**
     * Default capacity of using array.
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Default constructor.
     */
    public SimpleList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create a list with given capacity.
     * @param capacity counts of values which may store array.
     */
    public SimpleList(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Return value from array at the given position.
     * @param position number of data in array.
     * @return value from array.
     */
    @Override
    public T get(int position) {
        if (!validate(position)) {
            throw new ArrayIndexOutOfBoundsException("Bad position!");
        }
        return (T) this.values[position];
    }

    /**
     * Add new element to the array.
     * @param value it is data which will adding.
     * @return true if value was added.
     */
    @Override
    public boolean add(T value) {
        if (!this.validate(this.cursor)) {
            this.ensureCapacity();
        }
        this.values[this.cursor++] = value;
        return this.values[this.cursor - 1].equals(value);
    }

    /**
     * Remove value from the list, update cursor and return removed value.
     * @param position from this position value will remove.
     * @return value which was removed from list.
     */
    @Override
    public T remove(int position) {
        if (!validate(position)) {
            throw new NoSuchElementException("Element with given position not exist at the list!");
        }
        T removed = (T) this.values[position];
        this.values[position] = null;
        this.cursor--;
        return removed;
    }

    /**
     * Checking that given object contains at the list.
     * @param object for checking.
     * @return true if object find at the list, otherwise false.
     */
    @Override
    public boolean contains(Object object) {
        T value = (T) object;
        boolean result = false;
        for (int index = 0; index < this.values.length; index++) {
            T data = (T) this.values[index];
            if (data != null) {
                if (value.equals(data)) {
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * Return size of list.
     * @return size of list.
     */
    @Override
    public int size() {
        int size = 0;
        if (this.cursor == 1) {
            size = 1;
        } else {
            size = this.cursor - 1;
        }
        return size;
    }
    /**
     * Validate given value. It need for correct permission to the array.
     * @param position value for validate.
     * @return true if value is valid, otherwise false.
     */
    private boolean validate(int position) {
        return ((position >= 0) && (position < this.values.length));
    }

    /**
     * Create new array with new length, copy values from
     * old array to the new array, change reference.
     */
    private void ensureCapacity() {
        int newLength = (this.values.length * 3) / 2 + 1;
        Object[] newValues = new Object[newLength];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        this.values = newValues;
    }

    /**
     * Foreach loop.
     * @param action what action to do.
     */
    @Override
    public void forEach(Consumer<? super T> action) {

    }

    /**
     * Something magic method.
     * @return something magic method.
     */
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    /**
     * Return instance of new iterator.
     * @return iterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    /**
     * Simple iterator.
     */
    private class Itr implements Iterator<T> {

        /**
         * Pointer to the current element.
         */
        private int index = 0;

        /**
         * Check that in list have yet elements.
         * @return true if at the list have yet element otherwise false.
         */
        @Override
        public boolean hasNext() {
            return (this.index != values.length) && (values[index] != null);
        }

        /**
         * Return next value.
         * @return value from list.
         */
        @Override
        public T next() {
            return (T) values[index++];
        }

        /**
         * Remove from collection.
         */
        @Override
        public void remove() {
        }

        /**
         * Magic method.
         * @param action for each element.
         */
        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }
}
