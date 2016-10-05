package async;

import model.AbstractCache;
import model.FileSystemLoad;
import model.SimpleCache;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.09.2016
 */
public class CounterTest {

    private List<String> strings;
    private static final long MAX_EXECUTION_TIME = 1000;

    @Before
    public void setUp() {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        strings = cache.get(String.format("%s%s%s", FileUtils.getUserDirectoryPath(), File.separator, "simple.txt"));
    }
    /**
     * When try calculate spaces in text should check that counter correct calculate spaces.
     */
    @Test
    public void whenTryCalculateSpacesInTextShouldCheckThatCounterCorrectCalculateSpace() {
        Counter counter = new Counter();
        counter.start(strings, MAX_EXECUTION_TIME);
        assertThat(counter.getSpaces(), is(2));
    }

    /**
     * When try calculate words in text should check that counter correct calculate words.
     */
    @Test
    public void whenTryCalculateWordsInTextShouldCheckThatCounterCorrectCalculateWords() {
        Counter counter = new Counter();
        counter.start(strings, MAX_EXECUTION_TIME);
        assertThat(counter.getWords(), is(3));
    }

}
