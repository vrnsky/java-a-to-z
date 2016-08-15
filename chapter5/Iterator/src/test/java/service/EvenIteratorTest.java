package service;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for EvenIterator.java.
 * @author evrnsky
 * @version 1.0
 */
public class EvenIteratorTest {

    /**
     * When ask iterator about has next even element when pointer at the end
     * Should check that iterator return true.
     */
    @Test
    public void whenAskIteratorAboutHasNextElementsShouldCheckThatIteratorReturnFalse() {

        //Assign block
        EvenIterator iterator = new EvenIterator(new int[]{2,10});


        //Action block
        iterator.next();
        iterator.next();
        boolean actual = iterator.hasNext();

        //Assert block
        assertThat(actual, is(false));
    }

    /**
     * When try move across iterator should check that iterator give only even number.
     */
    @Test
    public void whenTryGetNextEvenValueShouldCheckThatIteratorReturnCorrectValue() {

        //Assign block
        EvenIterator iterator = new EvenIterator(new int[]{1,2,3,4,5,6,7,8});
        int[] expected = new int[]{2,4,6,8};
        int[] actual = new int[expected.length];
        int index = 0;

        //Action block
        while(iterator.hasNext()) {
            actual[index++] = (int)iterator.next();
        }

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * When try get value from iterator without call hasNext should check that value is correct.
     */
    @Test
    public void whenTrySomeEvenValuesFromIteratorShouldCheckThatNextWorksAuto() {

        //Assign block
        EvenIterator iterator = new EvenIterator(new int[]{12,15,80,100});
        int expected = 100;

        //Action block
        iterator.next();
        iterator.next();
        int actual = (int)iterator.next();

        assertThat(actual, is(expected));
    }
}
