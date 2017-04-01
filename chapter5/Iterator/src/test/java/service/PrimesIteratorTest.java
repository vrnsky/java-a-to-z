package service;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for PrimeIterator.
 * @author evrnsky
 * @version 1.0
 */
public class PrimesIteratorTest {

    /**
     * When try move across the int array should check that if
     * we have not far a prime number return false.
     */
    @Test
    public void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorGoForward() {
        PrimesIterator iterator = new PrimesIterator(new int[]{2, 3, 4});

        iterator.next();
        iterator.next();
        iterator.next();
        boolean actual = iterator.hasNext();

        assertThat(actual, is(false));
    }

    /**
     * When try move across data using the prime iterator
     * should check that values which iterator return is prime.
     */
    @Test
    public void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorReturnCorrectValue() {
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
