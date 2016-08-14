package service;

import java.util.Iterator;

/**
 * Iterator for even numbers. Return only even numbers.
 */
public class EvenIterator implements Iterator {

    /**
     * At this place hold all values.
     */
    private int[] values;

    /**
     * For correct moving across array.
     */
    private int pointer = 0;

    /**
     * Create a new iterator with given array.
     * @param values array of int.
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }

    /**
     * At the loop across all value and set pointer to value which is even.
     * @return true if even value find, and otherwise false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while(this.pointer < this.values.length) {
            if(this.values[this.pointer] % 2 == 0 && this.values[this.pointer] != 0) {
                result = true;
                break;
            }
            this.pointer++;
        }
        return result;
    }

    /**
     * Return next value from int array.
     * @return even int from array.
     */
    @Override
    public Object next() {
        return this.values[pointer++];
    }
}
