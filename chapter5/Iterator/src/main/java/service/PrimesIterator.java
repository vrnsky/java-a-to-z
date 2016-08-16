package service;

import java.util.Iterator;

/**
 * Iterator which return only prime numbers.
 */
public class PrimesIterator implements Iterator {

    /**
     * At this place hold all values.
     */
    private int[] values;

    /**
     * For correct moving across the int array.
     */
    private int pointer = 0;

    /**
     * Create a new iterator with given int array.
     * @param values array of int.
     */
    public PrimesIterator(int[] values) {
        this.values = values;
    }

    /**
     * Compute have iterator next element or not.
     * @return true if iterator have yet element and otherwise false.
     */
    @Override
    public boolean hasNext() {
        return this.pointer < this.values.length;
    }

    /**
     * Return prime number from array.
     * @return prime number from array.
     */
    @Override
    public Object next() {
        int result = 0;
        while(this.pointer < this.values.length) {
            if(isPrime(this.values[this.pointer])) {
                result = this.values[this.pointer++];
                break;
            }
            this.pointer++;
        }

        return result;
    }

    /**
     * Check that given number is prime.
     * @param number for checking.
     * @return true if number is correct and otherwise false.
     */
    private boolean isPrime(int number) {
        boolean result = false;
        if (number < 2) {
            result = false;
        } else {
            int division = 0;
            for(int index = 2; index < number; index++) {
                if(number % index == 0) {
                    division++;
                }
            }
            result = division == 0;
        }
        return result;
    }
}
