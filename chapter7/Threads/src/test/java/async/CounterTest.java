package async;

import find.FileTestUtils;
import model.AbstractCache;
import model.FileSystemLoad;
import model.SimpleCache;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.2
 * @since 28.09.2016
 */
public class CounterTest {

    /**
     * Text for testing.
     */
    private List<String> strings;

    /**
     * Folder for creating a new files for test.
     */
    private static final String CACHE_FOLDER = "cache";

    /**
     * It max time for compute.
     */
    private static final long MAX_EXECUTION_TIME = 1000;

    /**
     * This method call before even test.
     */
    @Before
    public void setUp() throws IOException {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        FileTestUtils.createAndFillFile(CACHE_FOLDER, "simple.txt", Arrays.asList("simple simple simple"));
        strings = cache.get(String.format("%s%s%s%s%s", FileUtils.getTempDirectory(), FileTestUtils.SEPARATOR, CACHE_FOLDER, FileTestUtils.SEPARATOR, "simple.txt"));
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
        final int expectedString = 3;
        Counter counter = new Counter();
        counter.start(strings, MAX_EXECUTION_TIME);
        assertThat(counter.getWords(), is(expectedString));
    }

    /**
     * Removing dir which need for this unit test.
     * @throws IOException if problem with removing dir.
     */
    @After
    public void tearDown() throws IOException {
        FileTestUtils.removeDir(CACHE_FOLDER);
    }

}
