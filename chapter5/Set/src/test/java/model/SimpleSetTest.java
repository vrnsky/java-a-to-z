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
     * When try add duplicate values to the set should check that set not accept it.
     */
    @Test
    public void whenTryAddDuplicateShouldCheckThatSetNotContainsDuplicate() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();
        String[] values = {"one", "two", "three", "four"};
        String[] expected = {values[3], values[0], values[1], values[2]};

        //Action block
        set.add(values[0]);
        set.add(values[1]);
        set.add(values[1]);
        set.add(values[2]);
        set.add(values[3]);
        set.add(values[3]);

        String[] actual = new String[set.size()];
        int index = 0;
        while(set.hasNext()) {
            actual[index++] = set.next();
        }

        //Assert block
        assertThat(actual, arrayContaining(expected));
    }

    /**
     * When try check size of set should check that method size return correct value.
     */
    @Test
    public void whenTryKnowSizeOfSetShouldCheckThatMethodSizeReturnCorrectValue() {

        //Assign block
        SimpleSet<String> set = new SimpleSet<>();
        int expected = 0;

        //Assert block
        assertThat(set.size(), is(expected));
    }
}
