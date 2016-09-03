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

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        int actual = set.size();

        //Assert block
        assertThat(actual, is(-1));
    }

    /**
     * When create set using default constructor should check that capacity is 100.
     */
    @Test
    public void whenCreateSetUsingDefaultConstructorShouldCheckThatCapacityIsHundred() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        int actual = set.capacity();

        //Assert block
        assertThat(actual, is(100));
    }

    /**
     * When try add element to the array set should that element was added.
     */
    @Test
    public void whenTryAddElementToTheArraySetShouldCheckThatElementWasAdded() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        set.add("Value");
        boolean actual = set.contains("Value");

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try add element and remove it from array set should check that element was removed.
     */
    @Test
    public void whenTryAddElementAndRemoveItShouldCheckThatElementWasRemoved() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        set.add("Value");
        set.remove("Value");
        boolean contains = set.contains("Value");

        //Assert block
        assertThat(contains, is(false));
    }

    /**
     * When try move across set using iterator should check that iterator works correct.
     */
    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        set.add("value");
        String actual = set.next();

        //Assign block
        assertThat(actual, is("value"));
    }

    @Test
    public void whenTryCallMethodHasNextOnEmptySetShouldCheckThatMethodThrowException() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        boolean actual = set.hasNext();

        //Assert block
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set value should check that method remove throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistElementFromSetShouldCheckThatMethodRemoveThrowException() {

        //Assign block
        ArraySet<String> set = new ArraySet<>();

        //Action block
        set.remove("value");

    }
}
