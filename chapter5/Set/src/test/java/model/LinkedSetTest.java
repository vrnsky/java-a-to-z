package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for LinkedSet.java.
 */
class LinkedSetTest {

    /**
     * When try to create linked set should check that size is zero.
     */
    @Test
    void whenTryCreateLinkedSetShouldCheckThatSetIsEmptyByCheckSize() {
        LinkedSet<String> set = new LinkedSet<>();
        int actual = set.size();
        assertThat(actual, is(0));
    }


    /**
     * When try adding element to the set should check that set saved element.
     */
    @Test
    void whenTryAddElementToTheSetShouldCheckThatElementWasAdded() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try to add and remove element from set should check that element was removed.
     */
    @Test
    void whenTryAddAndRemoveElementFromSetShouldCheckThatElementWasRemoved() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        set.remove("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set element should check that method remove throw exception.
     */
    @Test
    void whenTryRemoveNotExistAtTheSetElementShouldCheckThatRemoveThrowException() {
        LinkedSet<String> set = new LinkedSet<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> set.remove("value"));
    }

    /**
     * When try moving across set using iterator should check that iterator works correct.
     */
    @Test
    void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        String actual = set.next();
        assertThat(actual, is("Value"));
    }

    /**
     * When try call method has next from empty set should check that method return false.
     */
    @Test
    void whenTryCallMethodHasNextOnEmptyListShouldCheckThatMethodReturnFalse() {
        LinkedSet<String> set = new LinkedSet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * When try call method next from empty set should check that method throw exception.
     */
    @Test
    void whenTryCallMethodNextFromEmptySetShouldCheckThatMethodThrowException() {
        LinkedSet<String> set = new LinkedSet<>();
        Assertions.assertThrows(NullPointerException.class, set::next);
    }

    /**
     * When try adding ten thousands element to the linked set should check that linked set works correct.
     */
    @Test
    @Timeout(5000)
    void whenTryAddTenThousandElementToTheLinkedSetShouldCheckThatLinkedWorks() {
        LinkedSet<String> set = new LinkedSet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
