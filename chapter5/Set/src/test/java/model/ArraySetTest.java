package model;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.*;

/**
 *  Unit test for ArraySet.java
 */
public class ArraySetTest {

    /**
     * When try add value to the array set should check that set hold only unique values.
     */
    @Test
    public void whenTryAddValueToTheArraySetShouldCheckThatSetHoldOnlyUniqueValues() {

        //Assign block
        ArraySet<String> arraySet = new ArraySet<>();
        String[] expected = {"one", "two", "three", "four"};

        //Action block
        arraySet.add(expected[0]);
        arraySet.add(expected[1]);
        arraySet.add(expected[1]);
        arraySet.add(expected[2]);
        arraySet.add(expected[3]);
        arraySet.add(expected[3]);

        String[] actual = new String[expected.length];
        int index = 0;
        while(arraySet.hasNext()) {
            String value = arraySet.next();
            if (value != null) {
                actual[index++] = value;
            }
        }

        //Assert block
        assertThat(actual, arrayContaining(expected));
    }
}
