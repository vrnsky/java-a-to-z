package structure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vrnsky
 * @version 0.1
 * @since 17.04.2017
 *
 * Unit test for Copy on write list.
 */
public class CopyOnWriteListTest {

    /**
     * When try add element should check that element was added.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryAddElementShouldCheckThatElementAdded() throws Exception {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.add(0, "first");
        assertThat(strings.get(0), is("first"));
    }

    /**
     * When try remove element should check that all is ok.
     */
    @Test
    public void whenTryRemoveElementShouldCheckThatAllIsOk() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.add(0, "value");
        assertThat(strings.remove(0), is("value"));
    }

    /**
     * When try get size of list should check that all is ok.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryGetSizeOfListShouldCheckThatAllIsOK() throws Exception {
        CopyOnWriteList<String> string = new CopyOnWriteList<>();
        string.add(0, "value");
        assertThat(string.size(), is(1));
    }

    /**
     * When try get element with negative index should check that list throw exception.
     * @throws Exception if some errors happened.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGetElementWithNegativeIndexShouldCheckThatListThrowException() throws Exception {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.get(-1);
    }

    /**
     * When try remove element with negative index should check that list throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryRemoveElementWithNegativeIndexShouldCheckThatListThrowException() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.remove(-1);
    }

    /**
     * When try add element with negative index should check that list throw exception.
     */
    @Test(expected = IllegalStateException.class)
    public void whenTryAddElementWithNegativeIndexShouldCheckThatListThrowException() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.add(-1, "battle");
    }
}