package model;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.*;

/**
 * Unit test for SimpleSet.java
 *
 */
public class SimpleSetTest {

    /**
     * When try add value to set should check that value was added.
     */
    @Test
    public void whenTryAddValueToSetShouldCheckThatValueWasAdded() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();
        String expected = "value";

        //Action block
        set.add(expected);
        String actual = set.next();

        //Assert block
        assertThat(actual, is(expected));
    }


    /**
     * When try move across empty set should check that method hasNext throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryMoveAcrossEmptySetShouldCheckThatMethodHasNextThrowException() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();

        //Action block
        set.hasNext();
    }


    /**
     * When try check size of set should check that method size return correct value.
     */
    @Test
    public void whenTryKnowSizeOfSetShouldCheckThatMethodSizeReturnCorrectValue() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();

        //Assert block
        assertThat(set.size(), is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistElemFromSetShouldCheckThatMethodThrowException() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();

        //Action block
        set.remove("Google");
    }
}
