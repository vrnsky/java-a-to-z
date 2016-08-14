package service;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by Egor on 14.08.2016.
 */
public class EvenIteratorTest {


    @Test
    public void whenAskIteratorAboutHasNextElementsShouldCheckThatIteratorReturnTrue() {

        //Assign block
        EvenIterator iterator = new EvenIterator(new int[]{2,10});


        //Action block
        iterator.next();
        iterator.next();
        boolean actual = iterator.hasNext();

        //Assert block
        assertThat(actual, is(false));
    }

    @Test
    public void whenTryGetNextEvenValueShouldCheckThatIteratorReturnCorrectValue() {

        //Assign block
        EvenIterator iterator = new EvenIterator(new int[]{0,1,2});

        //Action block
        int actual = 0;
        while(iterator.hasNext()) {
            actual = (int)iterator.next();
        }

        //Assert block
        assertThat(actual, is(2));
    }
}
