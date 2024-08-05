package collection;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Unit test for SimpleList.java.
 */
class SimpleListTest {

    /**
     * When try aadding value to dynamic list should check that value was added.
     */
    @Test
    void whenTryAddValueToDynamicListShouldCheckThatValueWasAdded() {
        SimpleContainer<String> container = new SimpleList<>();
        String expected = "Hello";

        container.add(expected);
        String actual = container.get(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try removing value from dynamic list should check that method remove return removed value.
     */
    @Test
    void whenTryRemoveValueFromDynamicListShouldCheckThatRemoveMethodReturnCorrectObject() {
        SimpleContainer<String> container = new SimpleList<>();
        String expected = "Java";

        container.add(expected);
        String actual = container.remove(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try check that some object contains at the list should check that contains return true.
     */
    @Test
    void whenTryCheckThatSomeObjectContainsAtTheListShouldCheckThatContainsReturnTrue() {
        SimpleContainer<String> container = new SimpleList<>();
        String value = "Spring";

        container.add(value);
        boolean actual = container.contains(value);

        assertThat(actual, is(true));
    }

    /**
     * When try adding value but list is full should check that list ensureCapacity and accept new value.
     */
    @Test
    void whenTryAddValueButListIsFullShouldCheckThatListAcceptNewValue() {

        SimpleContainer<String> container = new SimpleList<>(1);
        String expected = "Second element";

        container.add("First element");
        container.add(expected);
        String actual = container.get(1);

        assertThat(actual, is(expected));
    }

    /**
     * When try use iterator from the list should check that iterator works correct.
     */
    @Test
    void whenTryGetIteratorFromListShouldCheckThatIteratorWorksCorrect() {
        SimpleContainer<String> container = new SimpleList<>();

        container.add("String");
        container.add("Values");
        Iterator<String> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
    }

    /**
     * When try moving across values using iterator should check that iterator return all values.
     */
    @Test
    void whenTryMoveAcrossValueUsingIteratorShouldCheckThatIteratorReturnAllValues() {
        SimpleContainer<String> container = new SimpleList<>();
        String[] expected = {"String", "Values", "Remove"};

        container.add(expected[0]);
        container.add(expected[1]);
        container.add(expected[2]);
        String[] actual = new String[expected.length];
        Iterator<String> iterator = container.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            actual[index++] = iterator.next();
        }

        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));

    }

    /**
     * When try getting element from negative index should check that app throw exception.
     */
    @Test
    void whenTryGetElementWithNegativeIndexShouldCheckThatListThrowException() {
        SimpleContainer<String> strings = new SimpleList<>();
        Assertions.assertThrows(NoSuchElementException.class, ()-> strings.get(-1));
    }

    /**
     * When try removing element from negative index should check that list throw exception.
     */
    @Test
    void whenTryRemoveElementFromNegativeIndexShouldCheckThatListThrowException() {
        SimpleContainer<String> strings = new SimpleList<>();
        Assertions.assertThrows(NoSuchElementException.class, ()-> strings.remove(-1));
    }

    /**
     * When try getting size from empty list should check that list return zero.
     */
    @Test
    void whenTryGetSizeAtTheEmptyListShouldCheckThatListReturnZero() {
        SimpleContainer<String> strings = new SimpleList<>();
        assertThat(strings.size(), is(-1));
    }

    /**
     * When try get size from not empty list should check that list return it size.
     */
    @Test
    void whenTryGetSizeFromNotEmptyListShouldCheckThatListReturnSize() {
        SimpleContainer<String> strings = new SimpleList<>();
        strings.add("first");
        strings.add("second");
        assertThat(strings.size(), is(1));
    }

}