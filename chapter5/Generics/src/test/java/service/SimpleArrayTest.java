package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit test for SimpleArray.java.
 * @author evrnsky
 * @version 1.0
 */
class SimpleArrayTest {

    /**
     * When try adding value to the simple array should check that saved value.
     */
    @Test
    void whenTryAddValuesToTheSimpleArrayShouldCheckThatAddedCorrect() {
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "first value";

        list.add(expected);
        String actual = list.get(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try update some value in list should check that list save changes.
     */
    @Test
    void whenTryUpdateSomeValueInListShouldCheckThatValueIsUpdate() {
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "Updated!";

        list.add("Not update!");
        list.update(0, expected);
        String actual = list.get(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try update value in list using bad position should check that method throw exception.
     */
    @Test
    void whenTryUpdateUseBadPositionShouldCheckThatMethodUpdateThrowException() {
        SimpleArray<String> list = new SimpleArray<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(-1));
    }

    /**
     * When try adding new value but array is full should check that value was add.
     */
    @Test
    void whenTryAddNewValueToTheListButListIsFullShouldCheckThatListIsResize() {
        SimpleArray<String> list = new SimpleArray<>(2);
        int expected = 4;

        list.add("one");
        list.add("two");
        list.add("three");
        int actual = list.size();

        assertThat(actual, is(expected));
    }

    /**
     * When try deleting value from list should check value was removed.
     */
    @Test
    void whenTryDeleteValueFromListShouldCheckThatValueWasRemoved() {
        SimpleArray<String> list = new SimpleArray<>();

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
    @Test
    void whenTryDeleteElementUsingBadPositionShouldCheckThatMethodThrowException() {
        SimpleArray<String> list = new SimpleArray<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(-1));
    }

    /**
     * When try update element with negative index should check that list throw exception.
     */
    @Test
    void whenTryUpdateElementWithNegativeIndexShouldCheckThatListThrowException() {
        SimpleArray<String> string = new SimpleArray<>();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> string.update(-1, "new string"));
    }
}
