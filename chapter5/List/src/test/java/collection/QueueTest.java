package collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Queue.java
 */
public class QueueTest {

    /**
     * When try push to the queue should check that value was added.
     */
    @Test
    public void whenTryPushToTheQueueShouldCheckThatValueWasAddedToTheQueue() {
        Queue<String> queue = new Queue<>();
        String expected = "value";

        queue.add(expected);

        assertThat(queue.poll(), is(expected));
    }

    /**
     * When try push value and call method peek should check that value was not removed.
     */
    @Test
    public void whenTryPushValueToTheQueueAndCallPeekMethodShouldCheckThat() {
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
    public void whenTryCheckThatQueueIsEmptyShouldCheckThatMethodReturnTrue() {
        Queue<String> queue = new Queue<>();
        assertThat(queue.isEmpty(), is(true));
    }
}
