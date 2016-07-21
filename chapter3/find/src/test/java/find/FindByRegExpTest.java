package find;

import chat.Answerer;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for FindByRegExp.java.
 */
public class FindByRegExpTest {

    /**
     * At this path will be search and save result.
     */
    private static final String PATH = "F:/java-a-to-z/chapter3/find/src/test/java/move/";

    /**
     * Save all data find and not find.
     */
    @Test
    public void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() throws Exception {
        //Assign block
        String[] keys = new String[]{"-d", PATH + "test/findbyregexp", "-r", "^regexp.txt$", "-m", "-o", PATH + "result/findbyregexp/findbyregexp.txt/"};
        Answerer answerer = null;
        FindByRegExp finder = new FindByRegExp();
        String[] expected = new String[]{
                "^regexp.txt$ was found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbyregexp\\regexp.txt",
                "^regexp.txt$ was found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbyregexp\\subfolder\\regexp.txt"
        };

        //Action block
        finder.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }
}
