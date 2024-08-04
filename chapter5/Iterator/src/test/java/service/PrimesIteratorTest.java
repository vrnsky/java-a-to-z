package service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for PrimeIterator.
 * @author evrnsky
 * @version 1.0
 */
class PrimesIteratorTest {

    /**
     * When try moving across the int array should check that if
     * we have not far a prime number return false.
     */
    @Test
    void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorGoForward() {
        PrimesIterator iterator = new PrimesIterator(new int[]{2, 3, 4});

        iterator.next();
        iterator.next();
        iterator.next();
        boolean actual = iterator.hasNext();

        assertThat(actual, is(false));
    }

    /**
     * When try moving across data using the prime iterator
     * should check that values which iterator return is prime.
     */
    @Test
    void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorReturnCorrectValue() {
        PrimesIterator iterator = new PrimesIterator(new int[]{2, 3, 4, 5});
        int[] expected = new int[]{2, 3, 5};

        int index = 0;
        int[] actual = new int[expected.length];

        while (iterator.hasNext()) {
            actual[index++] = (int) iterator.next();
        }
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }
}
