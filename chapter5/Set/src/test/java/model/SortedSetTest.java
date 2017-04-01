package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for SortedSet.java.
 */
public class SortedSetTest {

    /**
     * When try add value to the set should check that value was added.
     */
    @Test
    public void whenTryAddValueToTheSetShouldCheckThatValueWasAdded() {
        SortedSet<String> set = new SortedSet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try add value and remove value to the set should check that value was removed.
     */
    @Test
    public void whenTryAddAndRemoveValueToTheSetShouldCheckThatValueWasRemoved() {
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
    public void whenCreateSetShouldCheckDefaultCapacity() {
        SortedSet<String> set = new SortedSet<>();
        int actual = set.capacity();
        assertThat(actual, is(100));
    }

    /**
     * When create set should check that size in empty set is negative.
     */
    @Test
    public void whenCreateSetShouldCheckThatSizeInEmptyIsNegative() {
        SortedSet<String> set = new SortedSet<>();
        int actual = set.size();
        assertThat(actual, is(-1));
    }

    /**
     * When try move across set using iterator should check that iterator works correct.
     */
    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
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
    public void whenTryCheckHaveElementsAtTheEmptySetByCallHasNextMethodShouldCheckThatMethodReturnFalse() {
        SortedSet<String> set = new SortedSet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * Check that adding ten thousands elements to the sorted set is faster that 4.5 second.
     */
    @Test(timeout = 1200)
    public void whenTryAddTenThousandsElementToTheSortedSetShouldCheckThatTimeWasCorrect() {
        SortedSet<String> set = new SortedSet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }

}
