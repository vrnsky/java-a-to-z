package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for FindByRegExp.java.
 */
public class FindByRegExpTest {

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();

    /**
     * Folder for place all dirs for test.
     */
    private static final String FIND_BY_REGEXP = "findbyregexp";

    /**
     * Some file for test.
     */
    private static final String fileName = "r*.txt";

    /**
     * Save all data find and not find.
     */
    @Test
    public void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() throws Exception {
        FileTestUtils.createDirsAndFiles(FIND_BY_REGEXP, Arrays.asList("regexp.txt"), Arrays.asList("regexp.txt"));
        String searchFolder = String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, FIND_BY_REGEXP);
        File file = Files.createTempFile("regexp", "").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-n", fileName, "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s%s%s%s%s", fileName, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "regexp.txt"));
        expected.add(String.format("%s%s%s%s%s%s%s", fileName, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "subfolder", FileTestUtils.SEPARATOR, "regexp.txt"));

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        List<String> actual = Arrays.asList(answerer.getAllStrings());

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_REGEXP);
    }


}
