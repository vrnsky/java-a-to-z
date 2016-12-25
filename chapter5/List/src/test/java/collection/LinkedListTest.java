package collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

/**
 * Unit test for LinkedList.java
 */
public class LinkedListTest {

    /**
     * When try add values to linked list should check that values was added.
     */
    @Test
    public void whenTryAddValuesToLinkedListShouldCheckThatValueWasAdded() {
        SimpleContainer<String> container = new LinkedList<>();
        String expected = "Hello";

        container.add(expected);
        String actual = container.get(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try remove value from list should check that value was removed.
     */
    @Test
    public void whenTryRemoveValueShouldCheckThatValueWasRemoved() {
        SimpleContainer<String> container = new LinkedList<>();
        String expected = "Hello";

        container.add(expected);
        String actual = container.remove(0);

        assertThat(actual, is(expected));
    }

    /**
     * When try check that some object contains at the list should check that method works correct.
     */
    @Test
    public void whenTryCheckThatSomeObjectContainsAtTheListShouldCheckThatMethodWorksCorrect() {
        SimpleContainer<String> container = new LinkedList<>();
        String value = "Java";

        container.add(value);
        boolean actual = container.contains(value);

        assertThat(actual, is(true));
    }

    /**
     * When try get iterator should check that iterator return all values from the list.
     */
    @Test
    public void whenTryGetIteratorForMovingAcrossListShouldCheckThatIteratorWorksCorrect() {
        SimpleContainer<String> container = new LinkedList<>();
        String[] expected = {"Hello", "World", "!"};

        container.add(expected[0]);
        container.add(expected[1]);
        container.add(expected[2]);
        Iterator<String> iterator = container.iterator();
        String[] actual = new String[expected.length];
        int index = 0;
        while(iterator.hasNext()) {
            actual[index++] = iterator.next();
        }

        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * When try move across list use iterator should check that method iterator return true.
     */
    @Test
    public void whenTryMoveAcrossListUseIteratorShouldCheckThatMethodHasNextOfIteratorReturnTrue() {

        SimpleContainer<String> container = new LinkedList<>();

        container.add("non empty");
        Iterator<String> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
    }

    /**
     * When reverse the double linked list should check that all reversed.
     */
    @Test
    public void whenReverseListShouldCheckThatIsReversed() {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("value0");
        strings.add("value1");
        strings.reverse();
        Iterator<String> iterator = strings.iterator();
        int index = 0;
        String[] array = new String[strings.size()];
        while(iterator.hasNext()) {
            array[index++] = iterator.next();
        }
        assertThat(array, arrayContaining("value1", "value0"));
    }

}
