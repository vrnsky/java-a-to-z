package model;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for LinkedSet.java
 */
public class LinkedSetTest {

    /**
     * When try add values to the linked set should check that set hold only unique values.
     */
    @Test
    public void whenTryAddDuplicateValuesAtTheSetShouldCheckThatValueHoldOnlyUnique() {

        //Assign block
        LinkedSet<String> linkedSet = new LinkedSet<>();
        String[] expected = {"one", "two", "three", "four"};

        //Action block
        linkedSet.add(expected[0]);
        linkedSet.add(expected[1]);
        linkedSet.add(expected[1]);
        linkedSet.add(expected[2]);
        linkedSet.add(expected[2]);
        linkedSet.add(expected[3]);

        String[] actual = new String[expected.length];
        int index = 0;
        while(linkedSet.hasNext()) {
            actual[index++] = linkedSet.next();
        }

        //Assert block
        assertThat(actual, arrayContaining(expected));
    }

    /**
     * When try remove not exist element from set should check that method throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistElemFromSetShouldCheckThatMethodRemoveThrowException() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.remove("google");
    }

    /**
     * When try remove exist element from set should check that method remove works correct.
     */
    @Test
    public void whenTryRemoveExistElemFromSetShouldCheckThatMethodRemoveWorksCorrect() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();
        String expected = "value";

        //Action block
        set.add(expected);
        String actual = set.remove(expected);

        //Assert block
        assertThat(actual, is(expected));
    }


    /**
     * When call method size from empty set should check that method size return zero.
     */
    @Test
    public void whenCallMethodSizeFromTheEmptySetShouldCheckThatMethodSizeReturnZero() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        int actual = set.size();

        //Assert block
        assertThat(actual, is(0));
    }
}
