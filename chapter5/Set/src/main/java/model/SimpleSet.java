package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Implementation of set.
 * @param <T> specify type.
 */
public class SimpleSet<T> implements Iterator<T> {

    /**
     * At this place hold all values.
     */
    private Map<T, Object> map;

    /**
     * Dummy object, exist because map have key-value pair.
     */
    private static final Object OBJECT_PRESENT = new Object();

    /**
     * Inner iterator for correct moving across inner key set of map.
     */
    private Iterator<T> innerIterator;

    /**
     * Default constructor.
     */
    public SimpleSet() {
        this.map = new HashMap<>();
    }

    /**
     * Add value to the set.
     * @param t value which will add.
     */
    public void add(T t) {
        map.put(t, OBJECT_PRESENT);
        this.innerIterator = this.map.keySet().iterator();
    }

    /**
     * Return capacity of map.
     * @return count of elements.
     */
    public int size() {
        return this.map.size();
    }

    /**
     * Remove object from collection.
     * @param key it is object which will remove.
     * @return object which was removed.
     */
    public T remove(T key) {
       if (!this.map.containsKey(key)) {
           throw new NoSuchElementException("Given element not exist at the set.");
       }
       return (T) this.map.remove(key);
    }

    /**
     * Return true if at the key set have yet elements.
     * @return true if have yet elements and otherwise false.
     */
    @Override
    public boolean hasNext() {
        if (map.isEmpty()) {
            throw new NoSuchElementException("Set not have yet elements");
        }
        return this.innerIterator.hasNext();
    }

    /**
     * Return next element from key set.
     * @return next element from key set.
     */
    @Override
    public T next() {
      if (map.isEmpty()) {
          throw new NoSuchElementException("Set not have yet elements");
      }
      return this.innerIterator.next();
    }

    /**
     * Removing.
     */
    @Override
    public void remove() {
    }

    /**
     * Perform some action for each element.
     * @param action instance of action.
     */
    @Override
    public void forEachRemaining(Consumer<? super T> action) {
    }
}
