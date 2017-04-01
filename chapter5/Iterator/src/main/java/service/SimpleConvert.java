package service;

import java.util.Iterator;
/**
 * Iterator for double iterator.
 */
public class SimpleConvert implements Iterator {

    /**
     * Iterator which points on current iterator.
     */
    private Iterator<Integer> innerIterator;

    /**
     * Hold all iterator at this place.
     */
    private Iterator<Iterator<Integer>> outerIterator;


    /**
     * Return this object which allow to across all nested iterators.
     * @param it iterator of iterator of integer.
     * @return iterator of iterator.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
      this.outerIterator = it;
      if (it == null) {
          throw new IllegalArgumentException("Iterator not allow null");
      }
      return this;
    }

    /**
     * Return true if outer iterator have next or current innerIterator exist and have next element.
     * @return true if current innerIterator have next value, and false otherwise.
     */
    @Override
    public boolean hasNext() {
        if ((this.innerIterator == null) || (!this.innerIterator.hasNext() && this.outerIterator.hasNext())) {
            this.innerIterator = this.outerIterator.next();
        }
        return this.innerIterator.hasNext();
    }

    /**
     * Return value from iterator of iterator.
     * @return int value from iterator.
     */
    @Override
    public Object next() {
        if ((innerIterator == null) || (!this.innerIterator.hasNext())) {
            innerIterator = outerIterator.next();
        }
        return innerIterator.next();
    }
}
