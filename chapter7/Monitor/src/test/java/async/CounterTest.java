package async;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
class CounterTest {

    /**
     * When count calculate value should check that value correct.
     * @throws InterruptedException if some thread was interrupt.
     */
    @Test
    void whenTryUseCountToCalculateValueShouldCheckThatValueWasCalculateCorrect() throws InterruptedException  {
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