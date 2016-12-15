package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Unit test for FindByName.java.
 */
public class FindByNameTest {

    /**
     * Folder for test.
     */
    private static final String FIND_BY_NAME = "findbyname";

    /**
     * Name of file for search.
     */
    private static final String fileName = "name.txt";

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();

    /**
     * Check that find correct write result and correct finding files,
     * if file was not found should show it and show directory
     * also file was found should show it and show directory.
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() throws Exception {
        FileTestUtils.createDirsAndFiles(FIND_BY_NAME, Arrays.asList(fileName), Arrays.asList(fileName));
        String searchFolder = String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, FIND_BY_NAME);
        File file = Files.createTempFile("mask", "").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-n", fileName, "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s%s%s%s%s", fileName, " was found at ", searchFolder, FileTestUtils.SEPARATOR, fileName));
        expected.add(String.format("%s%s%s%s%s%s%s", fileName, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "subfolder", FileTestUtils.SEPARATOR, fileName));

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        List<String> actual = Arrays.asList(answerer.getAllStrings());

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_NAME);
    }


}
