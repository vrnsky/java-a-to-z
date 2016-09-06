package model;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for ArraySet.java
 */
public class ArraySetTest {

    /**
     * When create set should check that set not have element
     * By call set method. Set must return count of elements.
     * For empty list size is -1.
     */
    @Test
    public void whenCreateArraySetShouldCheckThatSizeIsZero() {
        ArraySet<String> set = new ArraySet<>();
        int actual = set.size();
        assertThat(actual, is(-1));
    }

    /**
     * When create set using default constructor should check that capacity is 100.
     */
    @Test
    public void whenCreateSetUsingDefaultConstructorShouldCheckThatCapacityIsHundred() {
        ArraySet<String> set = new ArraySet<>();
        int actual = set.capacity();
        assertThat(actual, is(100));
    }

    /**
     * When try add element to the array set should that element was added.
     */
    @Test
    public void whenTryAddElementToTheArraySetShouldCheckThatElementWasAdded() {
        ArraySet<String> set = new ArraySet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try add element and remove it from array set should check that element was removed.
     */
    @Test
    public void whenTryAddElementAndRemoveItShouldCheckThatElementWasRemoved() {
        ArraySet<String> set = new ArraySet<>();
        set.add("Value");
        set.remove("Value");
        boolean contains = set.contains("Value");
        assertThat(contains, is(false));
    }

    /**
     * When try move across set using iterator should check that iterator works correct.
     */
    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
        ArraySet<String> set = new ArraySet<>();
        set.add("value");
        String actual = set.next();
        assertThat(actual, is("value"));
    }

    @Test
    public void whenTryCallMethodHasNextOnEmptySetShouldCheckThatMethodThrowException() {
        ArraySet<String> set = new ArraySet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set value should check that method remove throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistElementFromSetShouldCheckThatMethodRemoveThrowException() {
        ArraySet<String> set = new ArraySet<>();
        set.remove("value");
    }

    @Test(timeout = 60 * 1000)
    public void whenTryAddTenThousandsElementToTheArraySetShouldCheckThatThisOperationTakeBigTime() {
        ArraySet<String> set = new ArraySet<>();
        for(int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
