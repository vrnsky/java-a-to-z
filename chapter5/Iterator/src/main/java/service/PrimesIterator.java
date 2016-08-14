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
     * At the loop check current number for its primes and if is primes
     * set pointer to current value.
     * @return true if at the array find prime number, otherwise false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while(this.pointer < this.values.length) {
            if(isPrime(this.values[this.pointer])) {
                result = true;
                break;
            }
            this.pointer++;
        }

        return result;
    }

    /**
     * Return prime number from array.
     * @return prime number from array.
     */
    @Override
    public Object next() {
        return this.values[pointer++];
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
