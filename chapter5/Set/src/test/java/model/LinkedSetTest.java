package model;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.*;

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
}
