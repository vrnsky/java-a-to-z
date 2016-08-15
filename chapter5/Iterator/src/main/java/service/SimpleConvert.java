package service;

import java.util.Iterator;

/**
 * Iterator for double iterator.
 */
public class SimpleConvert implements Iterator {

    /**
     * Iterator which points on current iterator.
     */
    private Iterator<Integer> pointer;

    /**
     * Hold all iterator at this place.
     */
    private Iterator<Iterator<Integer>> values;


    /**
     * Return this object which allow to across all nested iterators.
     * @param it iterator of iterator of integer.
     * @return
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
      this.values = it;
      return this;
    }

    /**
     * Return true if outer iterator have next or current pointer exist and have next element.
     * @return true if current pointer have next value, and false otherwise.
     */
    @Override
    public boolean hasNext() {
        return (this.values.hasNext() || (this.pointer != null && this.pointer.hasNext()));
    }

    /**
     * Return value from iterator of iterator.
     * @return int value from iterator.
     */
    @Override
    public Object next() {
        if(pointer == null) {
            pointer = values.next();
        } else if (!pointer.hasNext()) {
            pointer = values.next();
        }
        return pointer.next();
    }
}
