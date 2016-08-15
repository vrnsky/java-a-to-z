package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit test for SimpleArray.java
 * @author evrnsky
 * @version 1.0
 */
public class SimpleArrayTest {

    /**
     * When try add value to the simple array should check that saved value.
     */
    @Test
    public void whenTryAddValuesToTheSimpleArrayShouldCheckThatAddedCorrect() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "first value";

        //Action block
        list.add(expected);
        String actual = list.get(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try update some value in list should check that list save changes.
     */
    @Test
    public void whenTryUpdateSomeValueInListShouldCheckThatValueIsUpdate() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "Updated!";

        //Action block
        list.add("Not update!");
        list.update(0, expected);
        String actual = list.get(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try update value in list using bad position should check that method throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryUpdateUseBadPositionShouldCheckThatMethodUpdateThrowException() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>();


        //Action & assert block
        list.get(-1);
    }

    /**
     * When try add new value but array is full should check that value was add.
     */
    @Test
    public void whenTryAddNewValueToTheListButListIsFullShouldCheckThatListIsResize() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>(2);
        int expected = 4;

        //Action block
        list.add("one");
        list.add("two");
        list.add("three");
        int actual = list.size();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try delete value from list should check value was removed.
     */
    @Test
    public void whenTryDeleteValueFromListShouldCheckThatValueWasRemoved() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>();

        //Action block
        list.add("one");
        list.add("two");
        list.add("three");
        list.delete(1);
        String actual = list.get(1);

        assertThat(actual, is(nullValue()));
    }

    /**
     * When delete value from simple array should check that method throw exception.
     */
    @Test(expected =  IllegalArgumentException.class)
    public void whenTryDeleteElementUsingBadPositionShouldCheckThatMethodThrowException() {

        //Assign block
        SimpleArray<String> list = new SimpleArray<>();

        //Action & assert block
        list.delete(-1);
    }
}
