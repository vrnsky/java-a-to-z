package list;

import collection.SimpleList;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.11.2016
 */
public class SynchronizedSimpleListTest {

    /**
     * Object for testing.
     */
    private static final int VALUE = 1;

    /**
     * When add data to list should check that added.
     */
    @Test
    public final void whenAddDataToListShouldCheckThatDataAdded() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        boolean added = list.add(VALUE);
        assertThat(added, is(true));
    }

    /**
     * When get data from list should check that data correct.
     */
    @Test
    public final void whenGetDataFromListShouldCheckThatCorrect() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.get(index), is(VALUE));
    }

    /**
     * When remove data from list should check that data was removed.
     */
    @Test
    public final void whenRemoveDataShouldCheckRemovingFromList() {
        final int index = 0;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.remove(index), is(VALUE));
    }

    /**
     * When check that some object contains in list should check it.
     */
    @Test
    public final void whenCheckContainsShouldCheckThatWorksFine() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.contains(VALUE), is(true));
    }

    /**
     * When check size should check that is correct size.
     */
    @Test
    public final void whenCheckSizeShouldCheckThatIsCorrect() {
        final int size = 1;
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        assertThat(list.size(), is(size));
    }

    /**
     * When use iterator should check that iterator works correct.
     */
    @Test
    public final void whenUseIteratorShouldCheckThatIteratorCorrect() {
        SynchronizedList<Integer> list = new SynchronizedList<>(new SimpleList<>());
        list.add(VALUE);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(VALUE));
    }

}
