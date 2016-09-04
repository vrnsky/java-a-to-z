package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *
 */
public class SortedSetTest {

    @Test
    public void whenTryAddValueToTheSetShouldCheckThatValueWasAdded() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        set.add("Value");
        boolean actual = set.contains("Value");

        //Assert block
        assertThat(actual, is(true));
    }

    @Test
    public void whenTryAddAndRemoveValueToTheSetShouldCheckThatValueWasRemoved() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        set.add("Value");
        set.remove("Value");
        boolean actual = set.contains("Value");

        //Assert block
        assertThat(actual, is(false));
    }

    @Test
    public void whenCreateSetShouldCheckDefaultCapacity() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        int actual = set.capacity();

        //Assert block
        assertThat(actual, is(100));
    }

    @Test
    public void whenCreateSetShouldCheckThatSizeInEmptyIsNegative() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        int actual = set.size();

        //Assert block
        assertThat(actual, is(-1));
    }

    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        set.add("Value");
        String actual = set.next();

        //Assert block
        assertThat(actual, is("Value"));
    }

    @Test
    public void whenTryCheckHaveElementsAtTheEmptySetByCallHasNextMethodShouldCheckThatMethodReturnFalse() {

        //Assign block
        SortedSet<String> set = new SortedSet<>();

        //Action block
        boolean actual = set.hasNext();

        //Assert block
        assertThat(actual, is(false));
    }

}
