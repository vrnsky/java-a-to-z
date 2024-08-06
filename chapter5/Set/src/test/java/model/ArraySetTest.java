package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for ArraySet.java.
 */
class ArraySetTest {

    /**
     * When create set should check that set not have element.
     * By call set method. Set must return count of elements.
     * For empty list size is -1.
     */
    @Test
    void whenCreateArraySetShouldCheckThatSizeIsZero() {
        ArraySet<String> set = new ArraySet<>();
        int actual = set.size();
        assertThat(actual, is(-1));
    }

    /**
     * When create set using default constructor should check that capacity is 100.
     */
    @Test
    void whenCreateSetUsingDefaultConstructorShouldCheckThatCapacityIsHundred() {
        ArraySet<String> set = new ArraySet<>();
        int actual = set.capacity();
        assertThat(actual, is(100));
    }

    /**
     * When try adding element to the array set should that element was added.
     */
    @Test
    void whenTryAddElementToTheArraySetShouldCheckThatElementWasAdded() {
        ArraySet<String> set = new ArraySet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try adding element and remove it from array set should check that element was removed.
     */
    @Test
    void whenTryAddElementAndRemoveItShouldCheckThatElementWasRemoved() {
        ArraySet<String> set = new ArraySet<>();
        set.add("Value");
        set.remove("Value");
        boolean contains = set.contains("Value");
        assertThat(contains, is(false));
    }

    /**
     * When try moving across set using iterator should check that iterator works correct.
     */
    @Test
    void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
        ArraySet<String> set = new ArraySet<>();
        set.add("value");
        String actual = set.next();
        assertThat(actual, is("value"));
    }

    /**
     * When try ask about next, but next not exist.
     */
    @Test
    void whenTryCallMethodHasNextOnEmptySetShouldCheckThatMethodThrowException() {
        ArraySet<String> set = new ArraySet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set value should check that method remove throw exception.
     */
    @Test
    void whenTryRemoveNotExistElementFromSetShouldCheckThatMethodRemoveThrowException() {
        ArraySet<String> set = new ArraySet<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> set.remove("value"));
    }

    /**
     * When try adding ten thousand to the array set should check that it take a lot of time.
     */
    @Test
    @Timeout(value = 4500)
    void whenTryAddTenThousandsElementToTheArraySetShouldCheckThatThisOperationTakeBigTime() {
        ArraySet<String> set = new ArraySet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
