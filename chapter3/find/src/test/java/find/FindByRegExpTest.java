package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private static final String PATH = FileUtils.getUserDirectoryPath();

    /**
     * Save all data find and not find.
     */
    @Test
    public void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() throws Exception {

        //Assign block
        String searchFolder = String.format("%s%s%s", PATH, File.separator, "findbyregexp");
        String resultFolder = String.format("%s%s%s", PATH, File.separator, "result");
        Path file = Files.createTempFile(Paths.get(resultFolder), "regexp", "");
        String[] keys = new String[]{"-d", searchFolder, "-r", "^regexp.txt$", "-m", "-o", file.toString()};
        Answerer answerer = null;
        FindByRegExp finder = new FindByRegExp();
        String[] expected = new String[]{
                String.format("%s%s%s", "^regexp.txt$ was found at ", searchFolder , "\\regexp.txt, ") +
                String.format("%s%s%s", "^regexp.txt$ was found at ", searchFolder, "\\subfolder\\regexp.txt")
        };

        //Action block
        finder.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }
}
