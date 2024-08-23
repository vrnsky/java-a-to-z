package list;
import collection.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.11.2016
 */
class SynchronizedLinkedListTest {

    /**
     * Value which will add to list.
     */
    private static final int VALUE = 1;

    /**
     * When add data to list should check that data was added.
     */
    @Test
    void whenAddDataToListShouldCheckDataWasAdded() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        boolean added = list.add(VALUE);
        assertThat(added, is(true));
    }

    /**
     * When get data should check that data is correct.
     */
    @Test
    void whenGetDataShouldCheckCorrectData() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.get(index), is(VALUE));
    }

    /**
     * When remove data should check that is removed.
     */
    @Test
    void whenRemoveDataShouldCheckThatRemoved() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.remove(index), is(VALUE));
    }

    /**
     * When check contains list given object should check that contains.
     */
    @Test
    void whenCheckThatObjectContainsShouldCheckCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.contains(VALUE), is(true));
    }

    /**
     * When check size should check that size is correct.
     */
    @Test
    void whenCheckSizeShouldCheckCorrectOfSize() {
        final int size = 1;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.size(), is(size));
    }

    /**
     * When use iterator should check that iterator is correct.
     */
    @Test
    void whenUseIteratorShouldCheckThatIteratorCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(VALUE));
    }
}
