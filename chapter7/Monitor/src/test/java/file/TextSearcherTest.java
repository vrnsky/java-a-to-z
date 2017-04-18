package file;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This is unit test for text searcher.
 */
public class TextSearcherTest {

    /**
     * When try get founded flag but searching not started or not founded yet, should check that method return false.
     * @throws Exception if some problem happened.
     */
    @Test
    public void whenTryGetFoundedFlagAndShouldCheckThatMethodReturnFalse() throws Exception {
        TextSearcher searcher = new TextSearcher("", new FileStorage());
        assertThat(searcher.getFounded(), is(false));
    }
}