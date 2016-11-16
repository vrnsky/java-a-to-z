package list;

import collection.LinkedList;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.11.2016
 */
public class SynchronizedLinkedListTest {

    /**
     * Value which will add to list.
     */
    private static final int VALUE = 1;

    /**
     * When add data to list should check that data was added.
     */
    @Test
    public final void whenAddDataToListShouldCheckDataWasAdded() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        boolean added = list.add(VALUE);
        assertThat(added, is(true));
    }

    /**
     * When get data should check that data is correct.
     */
    @Test
    public final void whenGetDataShouldCheckCorrectData() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.get(index), is(VALUE));
    }

    /**
     * When remove data should check that is removed.
     */
    @Test
    public final void whenRemoveDataShouldCheckThatRemoved() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.remove(index), is(VALUE));
    }

    /**
     * When check contains list given object should check that contains.
     */
    @Test
    public final void whenCheckThatObjectContainsShouldCheckCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.contains(VALUE), is(true));
    }

    /**
     * When check size should check that size is correct.
     */
    @Test
    public final void whenCheckSizeShouldCheckCorrectOfSize() {
        final int size = 1;
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        assertThat(list.size(), is(size));
    }

    /**
     * When use iterator should check that iterator is correct.
     */
    @Test
    public final void whenUseIteratorShouldCheckThatIteratorCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new LinkedList<>());
        list.add(VALUE);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(VALUE));
    }
}
