package list;

import collection.SimpleList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.11.2016
 */
class SynchronizedSimpleListTest {

    /**
     * Object for testing.
     */
    private static final int VALUE = 1;

    /**
     * When add data to list should check that added.
     */
    @Test
    void whenAddDataToListShouldCheckThatDataAdded() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        boolean added = list.add(VALUE);
        assertThat(added, is(true));
    }

    /**
     * When get data from list should check that data correct.
     */
    @Test
    void whenGetDataFromListShouldCheckThatCorrect() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.get(index), is(VALUE));
    }

    /**
     * When remove data from list should check that data was removed.
     */
    @Test
    void whenRemoveDataShouldCheckRemovingFromList() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.remove(index), is(VALUE));
    }

    /**
     * When check that some object contains in list should check it.
     */
    @Test
    void whenCheckContainsShouldCheckThatWorksFine() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.contains(VALUE), is(true));
    }

    /**
     * When check size should check that is correct size.
     */
    @Test
    void whenCheckSizeShouldCheckThatIsCorrect() {
        final int size = 1;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.size(), is(size));
    }

    /**
     * When use iterator should check that iterator works correct.
     */
    @Test
    void whenUseIteratorShouldCheckThatIteratorCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(VALUE));
    }

}
