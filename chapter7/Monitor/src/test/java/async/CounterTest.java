package async;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class CounterTest {

    @Test
    public void whenTryUseCountToCalculateValueShouldCheckThatValueWasCalculateCorrect() throws InterruptedException  {
        Counter counter = new Counter();
        Thread threadOne = new CounterThread(counter);
        Thread threadTwo = new CounterThread(counter);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        assertThat(counter.getAmount(), is(2));
    }
}