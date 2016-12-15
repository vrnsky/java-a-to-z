package model;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for LinkedSet.java
 */
public class LinkedSetTest {

    /**
     * When try create linked set should check that size is zero.
     */
    @Test
    public void whenTryCreateLinkedSetShouldCheckThatSetIsEmptyByCheckSize() {
        LinkedSet<String> set = new LinkedSet<>();
        int actual = set.size();
        assertThat(actual, is(0));
    }


    /**
     * When try add element to the set should check that set saved element.
     */
    @Test
    public void whenTryAddElementToTheSetShouldCheckThatElementWasAdded() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(true));
    }

    /**
     * When try add and remove element from set should check that element was removed.
     */
    @Test
    public void whenTryAddAndRemoveElementFromSetShouldCheckThatElementWasRemoved() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        set.remove("Value");
        boolean actual = set.contains("Value");
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set element should check that method remove throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistAtTheSetElementShouldCheckThatRemoveThrowException() {
        LinkedSet<String> set = new LinkedSet<>();
        set.remove("value");
    }

    /**
     * When try move across set using iterator should check that iterator works correct.
     */
    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Value");
        String actual = set.next();
        assertThat(actual, is("Value"));
    }

    /**
     * When try call method has next from empty set should check that method return false.
     */
    @Test
    public void whenTryCallMethodHasNextOnEmptyListShouldCheckThatMethodReturnFalse() {
        LinkedSet<String> set = new LinkedSet<>();
        boolean actual = set.hasNext();
        assertThat(actual, is(false));
    }

    /**
     * When try call method next from empty set should check that method throw exception.
     */
    @Test(expected = NullPointerException.class)
    public void whenTryCallMethodNextFromEmptySetShouldCheckThatMethodThrowException() {
        LinkedSet<String> set = new LinkedSet<>();
        set.next();
    }

    /**
     * When try add ten thousands element to the linked set should check that linked set works correct.
     */
    @Test(timeout = 1000)
    public void whenTryAddTenThousandElementToTheLinkedSetShouldCheckThatLinkedWorks() {
        LinkedSet<String> set = new LinkedSet<>();
        for(int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
