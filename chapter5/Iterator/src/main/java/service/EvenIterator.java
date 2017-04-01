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
        return this.pointer < this.values.length;
    }

    /**
     * Return next even value from int array.
     * @return even int from array.
     */
    @Override
    public Object next() {
        int result = 0;
        while (this.pointer < this.values.length) {
            if (this.isEven(this.values[this.pointer])) {
                result = this.values[this.pointer++];
                break;
            }
            this.pointer++;
        }
        return result;
    }

    /**
     * Check that number is even.
     * @param number for checking
     * @return true if number even and otherwise false.
     */
    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
