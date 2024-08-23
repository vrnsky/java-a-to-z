package structure;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author vrnsky
 * @version 0.1
 * @since 17.04.2017
 *
 * Unit test for Copy on write list.
 */
class CopyOnWriteListTest {

    /**
     * When try to add element should check that element was added.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryAddElementShouldCheckThatElementAdded() throws Exception {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.add(0, "first");
        assertThat(strings.get(0), is("first"));
    }

    /**
     * When try to remove element should check that all is ok.
     */
    @Test
    void whenTryRemoveElementShouldCheckThatAllIsOk() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        strings.add(0, "value");
        assertThat(strings.remove(0), is("value"));
    }

    /**
     * When try to get size of list should check that all is ok.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryGetSizeOfListShouldCheckThatAllIsOK() throws Exception {
        CopyOnWriteList<String> string = new CopyOnWriteList<>();
        string.add(0, "value");
        assertThat(string.size(), is(1));
    }

    /**
     * When try to get element with negative index should check that list throw exception.
     * @throws Exception if some errors happened.
     */
    @Test
    void whenTryGetElementWithNegativeIndexShouldCheckThatListThrowException() throws Exception {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> strings.get(-1));
    }

    /**
     * When try to remove element with negative index should check that list throw exception.
     */
    @Test
    void whenTryRemoveElementWithNegativeIndexShouldCheckThatListThrowException() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> strings.remove(-1));
    }

    /**
     * When try to add element with negative index should check that list throw exception.
     */
    @Test
    void whenTryAddElementWithNegativeIndexShouldCheckThatListThrowException() {
        CopyOnWriteList<String> strings = new CopyOnWriteList<>();
        Assertions.assertThrows(IllegalStateException.class, () -> strings.add(-1, "battle"));
    }
}