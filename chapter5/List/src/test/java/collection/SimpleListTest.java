package collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Unit test for SimpleList.java.
 */
public class SimpleListTest {

    /**
     * When try add value to dynamic list should check that value was added.
     */
    @Test
    public void whenTryAddValueToDynamicListShouldCheckThatValueWasAdded() {
        SimpleContainer<String> container = new SimpleList<>();
        String expected = "Hello";

        container.add(expected);
        String actual = container.get(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try remove value from dynamic list should check that method remove return removed value.
     */
    @Test
    public void whenTryRemoveValueFromDynamicListShouldCheckThatRemoveMethodReturnCorrectObject() {
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
    public void whenTryCheckThatSomeObjectContainsAtTheListShouldCheckThatContainsReturnTrue() {
        SimpleContainer<String> container = new SimpleList<>();
        String value = "Spring";

        container.add(value);
        boolean actual = container.contains(value);

        assertThat(actual, is(true));
    }

    /**
     * When try add value but list is full should check that list ensureCapacity and accept new value.
     */
    @Test
    public void whenTryAddValueButListIsFullShouldCheckThatListAcceptNewValue() {

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
    public void whenTryGetIteratorFromListShouldCheckThatIteratorWorksCorrect() {
        SimpleContainer<String> container = new SimpleList<>();

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

}