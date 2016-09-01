package model;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for ArraySet.java
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
        while (arraySet.hasNext()) {
            String value = arraySet.next();
            if (value != null) {
                actual[index++] = value;
            }
        }

        //Assert block
        assertThat(actual, arrayContaining(expected));
    }

    /**
     * When try add and remove value should check that method remove return removed value.
     */
    @Test
    public void whenTryAddAndRemoveValueShouldCheckThatValueWasRemoved() {

        //Assign block
        ArraySet<String> arraySet = new ArraySet<>();
        String expected = "value";

        //Action block
        arraySet.add(expected);
        String actual = arraySet.remove(expected);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try remove not exist element at the set should check that method throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistAtTheSetElementShouldCheckThatMethodRemoveThrowException() {

        //Assign block
        ArraySet<String> arraySet = new ArraySet<>();

        //Action block
        arraySet.remove("value");
    }

    /**
     * When try call method contains should check that method works correct.
     */
    @Test
    public void whenTryCallMethodContainsShouldCheckThatMethodWorksCorrect() {

        //Assign block
        ArraySet<String> arraySet = new ArraySet<>();
        String expected = "value";

        //Action block
        arraySet.add(expected);
        boolean actual = arraySet.contains(expected);

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try call method size should check that method return length of using array.
     */
    @Test
    public void whenTryCallMethodSizeShouldCheckThatMethodReturnLengthOfUsingArray() {

        //Assign block
        ArraySet<String> arraySet = new ArraySet<>();

        //Action block
        int actual = arraySet.size();

        //Assert block
        assertThat(actual, is(100));
    }
}
