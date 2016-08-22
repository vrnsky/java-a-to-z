package collection;

import org.junit.Test;
import static org.junit.Assert.*;
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

        //Assign block
        Queue<String> queue = new Queue<>();
        String expected = "value";

        //Action block
        queue.add(expected);

        //Assert block
        assertThat(queue.poll(), is(expected));
    }

    /**
     * When try push value and call method peek should check that value was not removed.
     */
    @Test
    public void whenTryPushValueToTheQueueAndCallPeekMethodShouldCheckThat() {

        //Assign block
        Queue<String> queue = new Queue<>();
        String expected = "value";

        //Action block
        queue.add(expected);
        queue.peek();

        //Assert block
        assertThat(queue.poll(), is(expected));
    }

    /**
     * When try check that queue is empty should check that method return true.
     */
    @Test
    public void whenTryCheckThatQueueIsEmptyShouldCheckThatMethodReturnTrue() {

        //Assign block
        Queue<String> queue = new Queue<>();

        //Assert block
        assertThat(queue.isEmpty(), is(true));
    }
}
