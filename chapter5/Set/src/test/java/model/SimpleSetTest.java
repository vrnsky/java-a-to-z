package model;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for SimpleSet.java.
 *
 */
public class SimpleSetTest {

    /**
     * When try add value to set should check that value was added.
     */
    @Test
    public void whenTryAddValueToSetShouldCheckThatValueWasAdded() {
        SimpleSet<String> set = new SimpleSet<>();
        String expected = "value";
        set.add(expected);
        String actual = set.next();
        assertThat(actual, is(expected));
    }


    /**
     * When try move across empty set should check that method hasNext throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryMoveAcrossEmptySetShouldCheckThatMethodHasNextThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        set.hasNext();
    }


    /**
     * When try check capacity of set should check that method capacity return correct value.
     */
    @Test
    public void whenTryKnowSizeOfSetShouldCheckThatMethodSizeReturnCorrectValue() {
        SimpleSet<String> set = new SimpleSet<>();
        assertThat(set.size(), is(0));
    }

    /**
     * When try remove not exist element from set should check that remove throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveNotExistElemFromSetShouldCheckThatMethodThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        set.remove("Google");
    }

    /**
     * When try remove element from empty set should check that set throw exception.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenTryRemoveElementFromEmptySetShouldCheckThatSetThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        set.remove();
    }

    /**
     * When try get iterator on empty list should check that it moving.
     */
    @Test
    public void whenTryGetIteratorOnNotEmptyListShouldCheckThatSetReturnIterator() {
        SimpleSet<String> strings = new SimpleSet<>();
        strings.add("Andrew");
        assertThat(strings.next(), is("Andrew"));
    }

    /**
     * When try next element from empty set should check that set throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryNextElementFromEmptySetShouldCheckThatSetThrowException() {
        SimpleSet<String> set = new SimpleSet<>();
        set.next();
    }

    /**
     * When try add ten thousands of string should check that set accept it all for some time.
     */
    @Test(timeout = 1000)
    public void whenTryAddTenThousandsToSimpleSetShouldCheckThatSetAcceptAllDataInGiveTime() {
        SimpleSet<String> set = new SimpleSet<>();
        for (int index = 0; index < 10000; index++) {
            set.add(String.format("%s", index));
        }
    }
}
