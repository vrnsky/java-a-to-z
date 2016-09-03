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

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        int actual = set.size();

        //Assert block
        assertThat(actual, is(0));
    }


    /**
     * When try add element to the set should check that set saved element.
     */
    @Test
    public void whenTryAddElementToTheSetShouldCheckThatElementWasAdded() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.add("Value");
        boolean actual = set.contains("Value");

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try add and remove element from set should check that element was removed.
     */
    @Test
    public void whenTryAddAndRemoveElementFromSetShouldCheckThatElementWasRemoved() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.add("Value");
        set.remove("Value");
        boolean actual = set.contains("Value");

        //Assert block
        assertThat(actual, is(false));
    }

    /**
     * When try remove not exist at the set element should check that method remove throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistAtTheSetElementShouldCheckThatRemoveThrowException() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.remove("value");
    }

    /**
     * When try move across set using iterator should check that iterator works correct.
     */
    @Test
    public void whenTryMoveAcrossSetUsingIteratorShouldCheckThatIteratorWorksCorrect() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.add("Value");
        String actual = set.next();

        //Assert block
        assertThat(actual, is("Value"));
    }

    /**
     * When try call method has next from empty set should check that method return false.
     */
    @Test
    public void whenTryCallMethodHasNextOnEmptyListShouldCheckThatMethodReturnFalse() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        boolean actual = set.hasNext();

        //Assert block
        assertThat(actual, is(false));
    }

    /**
     * When try call method next from empty set should check that method throw exception.
     */
    @Test(expected = NullPointerException.class)
    public void whenTryCallMethodNextFromEmptySetShouldCheckThatMethodThrowException() {

        //Assign block
        LinkedSet<String> set = new LinkedSet<>();

        //Action block
        set.next();
    }
}
