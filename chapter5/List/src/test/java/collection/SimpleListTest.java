package collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Unit test for SimpleList.java
 */
public class SimpleListTest {

    /**
     * When try add value to dynamic list should check that value was added.
     */
    @Test
    public void whenTryAddValueToDynamicListShouldCheckThatValueWasAdded() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>();
        String expected = "Hello";

        //Action block
        container.add(expected);
        String actual = container.get(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try remove value from dynamic list should check that method remove return removed value.
     */
    @Test
    public void whenTryRemoveValueFromDynamicListShouldCheckThatRemoveMethodReturnCorrectObject() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>();
        String expected = "Java";

        //Action block
        container.add(expected);
        String actual = container.remove(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try check that some object contains at the list should check that contains return true.
     */
    @Test
    public void whenTryCheckThatSomeObjectContainsAtTheListShouldCheckThatContainsReturnTrue() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>();
        String value = "Spring";

        //Action block
        container.add(value);
        boolean actual = container.contains(value);

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try add value but list is full should check that list ensureCapacity and accept new value.
     */
    @Test
    public void whenTryAddValueButListIsFullShouldCheckThatListAcceptNewValue() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>(1);
        String expected = "Second element";

        //Action block
        container.add("First element");
        container.add(expected);
        String actual = container.get(1);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try use iterator from the list should check that iterator works correct.
     */
    @Test
    public void whenTryGetIteratorFromListShouldCheckThatIteratorWorksCorrect() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>();

        //Action block
        container.add("String");
        container.add("Values");
        Iterator<String> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
    }

    /**
     * When try move across values using iterator should check that iterator return all values.
     */
    @Test
    public void whenTryMoveAcrossValueUsingIteratorShouldCheckThatIteratorReturnAllValues() {

        //Assign block
        SimpleContainer<String> container = new SimpleList<>();
        String[] expected = {"String", "Values", "Remove"};

        //Action block
        container.add(expected[0]);
        container.add(expected[1]);
        container.add(expected[2]);
        String[] actual = new String[expected.length];
        Iterator<String> iterator = container.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            actual[index++] = iterator.next();
        }

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));

    }

}