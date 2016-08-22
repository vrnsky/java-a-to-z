package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for LinkedList.java
 */
public class LinkedListTest {

    /**
     * When try add values to linked list should check that values was added.
     */
    @Test
    public void whenTryAddValuesToLinkedListShouldCheckThatValueWasAdded() {

        //Assign block
        SimpleContainer<String> container = new LinkedList<>();
        String expected = "Hello";

        //Action block
        container.add(expected);
        String actual = container.get(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try remove value from list should check that value was removed.
     */
    @Test
    public void whenTryRemoveValueShouldCheckThatValueWasRemoved() {

        //Assign block
        SimpleContainer<String> container = new LinkedList<>();
        String expected = "Hello";

        //Action block
        container.add(expected);
        String actual = container.remove(0);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try check that some object contains at the list should check that method works correct.
     */
    @Test
    public void whenTryCheckThatSomeObjectContainsAtTheListShouldCheckThatMethodWorksCorrect() {

        //Assign block
        SimpleContainer<String> container = new LinkedList<>();
        String value = "Java";

        //Action block
        container.add(value);
        boolean actual = container.contains(value);

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try get iterator should check that iterator return all values from the list.
     */
    @Test
    public void whenTryGetIteratorForMovingAcrossListShouldCheckThatIteratorWorksCorrect() {

        //Assign block
        SimpleContainer<String> container = new LinkedList<>();
        String[] expected = {"Hello", "World", "!"};

        //Action block
        container.add(expected[0]);
        container.add(expected[1]);
        container.add(expected[2]);
        Iterator<String> iterator = container.iterator();
        String[] actual = new String[expected.length];
        int index = 0;
        while(iterator.hasNext()) {
            actual[index++] = iterator.next();
        }

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * When try move across list use iterator should check that method iterator return true.
     */
    @Test
    public void whenTryMoveAcrossListUseIteratorShouldCheckThatMethodHasNextOfIteratorReturnTrue() {

        //Assign block
        SimpleContainer<String> container = new LinkedList<>();

        //Action block
        container.add("non empty");
        Iterator<String> iterator = container.iterator();

        //Assert block
        assertThat(iterator.hasNext(), is(true));
    }
}
