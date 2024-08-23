package model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for SimpleSet.java.
 *
 */
class SimpleSetTest {

    /**
     * When try adding value to set should check that value was added.
     */
    @Test
    void whenTryAddValueToSetShouldCheckThatValueWasAdded() {
        SimpleSet<String> set = new SimpleSet<>();
        String expected = "value";
        set.add(expected);
        String actual = set.next();
        assertThat(actual, is(expected));
    }


    /**
     * When try moving across empty set should check that method hasNext throw exception.
     */
    @Test
    void whenTryMoveAcrossEmptySetShouldCheckThatMethodHasNextThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        Assertions.assertThrows(NoSuchElementException.class, set::hasNext);
    }


    /**
     * When try check capacity of set should check that method capacity return correct value.
     */
    @Test
    void whenTryKnowSizeOfSetShouldCheckThatMethodSizeReturnCorrectValue() {
        SimpleSet<String> set = new SimpleSet<>();
        assertThat(set.size(), is(0));
    }

    /**
     * When try remove not exist element from set should check that remove throw exception.
     */
    @Test
    void whenTryRemoveNotExistElemFromSetShouldCheckThatMethodThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> set.remove("Google"));
    }

    /**
     * When try removing element from empty set should check that set throw exception.
     */
    @Test
    void whenTryRemoveElementFromEmptySetShouldCheckThatSetThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        Assertions.assertThrows(UnsupportedOperationException.class, set::remove);
    }

    /**
     * When try get iterator on empty list should check that it moving.
     */
    @Test
    void whenTryGetIteratorOnNotEmptyListShouldCheckThatSetReturnIterator() {
        SimpleSet<String> strings = new SimpleSet<>();
        strings.add("Andrew");
        assertThat(strings.next(), is("Andrew"));
    }

    /**
     * When try next element from empty set should check that set throw exception.
     */
    @Test
    void whenTryNextElementFromEmptySetShouldCheckThatSetThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        Assertions.assertThrows(NoSuchElementException.class, set::next);
    }

    /**
     * When try adding ten thousand of string should check that set accepts it all for some time.
     */
    @Test
    @Timeout(1000)
    void whenTryAddTenThousandsToSimpleSetShouldCheckThatSetAcceptAllDataInGiveTime() {
        SimpleSet<String> set = new SimpleSet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
