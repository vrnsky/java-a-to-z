package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Unit test for FindByName.java.
 *  @author vrnsky
 *  @version 0.1
 */
public class FindByNameTest {

    /**
     * Folder for test.
     */
    private static final String FIND_BY_NAME = "findbyname";

    /**
     * Name of file for search.
     */
    private static final String FILENAME = "name.txt";

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();

    /**
     * Check that find correct write result and correct finding files,
     * if file was not found should show it and show directory
     * also file was found should show it and show directory.
     * @throws Exception if something was wrong.
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() throws Exception {
        FileTestUtils.createDirsAndFiles(FIND_BY_NAME, Arrays.asList(FILENAME), Arrays.asList(FILENAME));
        String searchFolder = String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, FIND_BY_NAME);
        File file = Files.createTempFile("mask", "").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-n", FILENAME, "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s%s%s%s%s", FILENAME, " was found at ", searchFolder, FileTestUtils.SEPARATOR, FILENAME));
        expected.add(String.format("%s%s%s%s%s%s%s", FILENAME, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "subfolder", FileTestUtils.SEPARATOR, FILENAME));

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        List<String> actual = Arrays.asList(answerer.getAllStrings());

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_NAME);
    }


}
