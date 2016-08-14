package service;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by Egor on 14.08.2016.
 */
public class PrimesIteratorTest {

    @Test
    public void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorGoForward() {

        //Assign block
        PrimesIterator iterator = new PrimesIterator(new int[]{2,3,4});

        //Action block
        iterator.next();
        iterator.next();
        boolean actual = iterator.hasNext();

        assertThat(actual, is(false));
    }

    @Test
    public void whenTryMoveAcrossTheIntArrayShouldCheckThatIteratorReturnCorrectValue() {

        //Assign block
        PrimesIterator iterator = new PrimesIterator(new int[]{2,3,4,5});

        //Action block
        int actual = 0;
        while(iterator.hasNext()) {
            actual = (int)iterator.next();
        }

        //Assert block
        assertThat(actual, is(5));
    }
}
