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
    private static final String PATH = "F:/java-a-to-z/iml/move/";

    /**
     * Save all data find and not find.
     */
    @Test
    public void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() {
        //Assign block
        String[] keys = new String[]{"-d", PATH, "-r", "^regexp.txt$", "-m", "-o", PATH + "/result//findbyregexp/findbyregexp.txt/"};
        Answerer answerer = null;
        FindByRegExp finder = new FindByRegExp();
        String[] expected = new String[]{
                "^regexp.txt$ was not found at F:\\java-a-to-z\\iml\\move\\result\\findbymask\\findbymask.txt",
                "^regexp.txt$ was not found at F:\\java-a-to-z\\iml\\move\\result\\findbyname\\findbyname.txt",
                "^regexp.txt$ was not found at F:\\java-a-to-z\\iml\\move\\result\\findbyregexp\\findbyregexp.txt",
                "^regexp.txt$ was not found at F:\\java-a-to-z\\iml\\move\\test\\findbymask\\mask.txt",
                "^regexp.txt$ was not found at F:\\java-a-to-z\\iml\\move\\test\\findbyname\\name.txt",
                "^regexp.txt$ was found at F:\\java-a-to-z\\iml\\move\\test\\findbyregexp\\regexp.txt"
        };

        //Action block
        finder.find(keys);
        try {
            answerer = new Answerer(PATH + "/result//findbyregexp/findbyregexp.txt/");
        } catch (IOException exp) {
            System.out.println("Result file N/A");
        }
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }
}
