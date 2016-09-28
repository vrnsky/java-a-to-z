package async;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.09.2016
 */
public class CounterTest {

    /**
     * When try calculate spaces in text should check that counter correct calculate spaces.
     */
    @Test
    public void whenTryCalculateSpacesInTextShouldCheckThatCounterCorrectCalculateSpace() {
        Counter counter = new Counter();
        counter.init();
        assertThat(counter.getSpaces(), is(2));
    }

    /**
     * When try calculate words in text should check that counter correct calculate words.
     */
    @Test
    public void whenTryCalculateWordsInTextShouldCheckThatCounterCorrectCalculateWords() {
        Counter counter = new Counter();
        counter.init();
        assertThat(counter.getWords(), is(3));
    }
}
