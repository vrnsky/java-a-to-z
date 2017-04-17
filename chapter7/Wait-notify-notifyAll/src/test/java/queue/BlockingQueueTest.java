package queue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.11.2016
 *
 * Unit test for BlockingQueue.java.
 * This unit test contains test case for next scenarios:
 * When few threads push data to the queue.
 * When few threads poll data from the queue.
 * Test case which check that user does not may put much more objects.
 */
public class BlockingQueueTest {

    /**
     * Instance of testing API.
     */
    private BlockingQueue<String> queue;

    /**
     * This method calls before each test case and init testing API.
     */
    @Before
    public void setUp() {
        final int capacity = 10;
        queue = new BlockingQueue<>(capacity);
    }


    /**
     * When push to the queue should check that size of queue is changed.
     * @throws Exception if some problem with threads.
     */
    @Test
    public void whenPushToTheQueueShouldCheckThatSizeChanged() throws Exception {
        final int size = 3;
        Runnable producer = () -> queue.add(String.format("%s", System.currentTimeMillis()));
        Thread one = new Thread(producer);
        Thread two = new Thread(producer);
        Thread three = new Thread(producer);
        one.start();
        two.start();
        three.start();
        one.join();
        two.join();
        three.join();
        assertThat(queue.size(), is(size));
    }

    /**
     * When poll elements from queue should check that size is changed.
     * @throws Exception if some problem with thread.
     */
    @Test
    public void whenPollAllElemsFromQueueShouldCheckThatQueueIsEmpty() throws Exception {
        final int size = 0;
        final int threads = 3;
        for (int index = 0; index < threads; index++) {
            this.queue.add(String.format("%s", index));
        }
        Runnable consumer = () -> queue.poll();
        Thread one = new Thread(consumer);
        Thread two = new Thread(consumer);
        Thread three = new Thread(consumer);
        one.start();
        two.start();
        three.start();
        one.join();
        two.join();
        three.join();

        assertThat(queue.size(), is(size));
    }

    /**
     * Check that user does not may put much more elements.
     */
    @Test(expected = IllegalStateException.class)
    public void whenPushMoreThanAcceptQueueShouldCheckElemNotAdd() {
        final int size = 12;
        for (int index = 0; index < size; index++) {
            queue.add(String.format("%s", System.currentTimeMillis()));
        }
    }

    /**
     * When try create a block queye with negative or zero capacity should check that throw exception.
     */
    @Test(expected = IllegalStateException.class)
    public void whenTryCreateBlockQueueWithNegativeOrZeroCapacityShouldCheckThatThrowException() {
        new BlockingQueue<>(0);
    }




}