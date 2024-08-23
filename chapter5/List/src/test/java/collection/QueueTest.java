package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Queue.java.
 */
class QueueTest {

    /**
     * When try push to the queue should check that value was added.
     */
    @Test
    void whenTryPushToTheQueueShouldCheckThatValueWasAddedToTheQueue() {
        Queue<String> queue = new Queue<>();
        String expected = "value";

        queue.add(expected);

        assertThat(queue.poll(), is(expected));
    }

    /**
     * When try push value and call method peek should check that value was not removed.
     */
    @Test
    void whenTryPushValueToTheQueueAndCallPeekMethodShouldCheckThat() {
        Queue<String> queue = new Queue<>();
        String expected = "value";

        queue.add(expected);
        queue.peek();

        assertThat(queue.poll(), is(expected));
    }

    /**
     * When try check that queue is empty should check that method return true.
     */
    @Test
    void whenTryCheckThatQueueIsEmptyShouldCheckThatMethodReturnTrue() {
        Queue<String> queue = new Queue<>();
        assertThat(queue.isEmpty(), is(true));
    }

    /**
     * When try poll element from empty queue should check that throw exception.
     */
    @Test
    void whenTryPollElementFromEmptyCollectionShouldCheckThatQueueThrowException() {
        Queue<String> queue = new Queue<>();
        Assertions.assertThrows(IllegalArgumentException.class, queue::peek);
    }

    /**
     * When try peek element from empty queue should check that queue throw exception.
     */
    @Test
    void whenTryPeekElementFromEmptyCollectionShouldCheckThatQueueThrowException() {
        Queue<String> strings = new Queue<>();
        Assertions.assertThrows(IllegalArgumentException.class, strings::peek);
    }
}
