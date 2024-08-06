package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for SortedSet.java.
 */
class SortedSetTest {

    /**
     * When try adding value to the set should check that value was added.
     */
    @Test
    void whenTryAddValueToTheSetShouldCheckThatValueWasAdded() {
        SortedSet<String> set = new SortedSet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try adding value and remove value to the set should check that value was removed.
     */
    @Test
    void whenTryAddAndRemoveValueToTheSetShouldCheckThatValueWasRemoved() {
        SortedSet<String> set = new SortedSet<>();
        set.add("Value");
        set.remove("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(false));
    }

    /**
     * When create set should check that default capacity is 100.
     */
    @Test
    void whenCreateSetShouldCheckDefaultCapacity() {
        SortedSet<String> set = new SortedSet<>();
        int actual = set.capacity();
        assertThat(actual, is(100));
    }

    /**
     * When create set should check that size in empty set is negative.
     */
    @Test
    void whenCreateSetShouldCheckThatSizeInEmptyIsNegative() {
        SortedSet<String> set = new SortedSet<>();
        int actual = set.size();
        assertThat(actual, is(-1));
    }

    /**
     * When try moving across set using iterator should check that iterator works correct.
     */
    @Test
    void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
        SortedSet<String> set = new SortedSet<>();
        set.add("Value");
        String actual = set.next();
        assertThat(actual, is("Value"));
    }

    /**
     * When try check have elements at the empty set by call has next method
     * should check that method return false.
     */
    @Test
    void whenTryCheckHaveElementsAtTheEmptySetByCallHasNextMethodShouldCheckThatMethodReturnFalse() {
        SortedSet<String> set = new SortedSet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * Check that adding ten thousands elements to the sorted set is faster that 4.5 second.
     */
    @Test
    @Timeout(120)
    void whenTryAddTenThousandsElementToTheSortedSetShouldCheckThatTimeWasCorrect() {
        SortedSet<String> set = new SortedSet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }

}
