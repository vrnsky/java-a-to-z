package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Unit test for FindByMask.java.
 */
public class FindByMaskTest {

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectoryPath();

    /**
     * Folder for place testing files.
     */
    private static final String FIND_BY_MASK = "findbymask";


    /**
     * When user give correct keys should find file and save all data.
     */
    @Test
    public void whenTrySearchFileByMaskShouldSaveResultInSpecifiedFile() throws Exception {
        FileTestUtils.createDirsAndFiles(FIND_BY_MASK, Arrays.asList("rmask.txt"), Arrays.asList("mask.txt"));
        String searchFolder = String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, FIND_BY_MASK);
        File file = Files.createTempFile("mask", "").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-n", "r*.txt", "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        String[] expected = new String[]{
                String.format("%s%s%s%s", "r*.txt was found at ", searchFolder, FileTestUtils.SEPARATOR,  "rmask.txt, ") +
                String.format("%s%s%s%s%s%s", "r*.txt was not found at ",searchFolder, FileTestUtils.SEPARATOR,
                             "subfolder", System.getProperty("file.separator"), "mask.txt")
        };

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();
        Arrays.asList(actual);

        assertThat(Arrays.asList(expected), is(Arrays.asList(expected)));
        FileTestUtils.removeDir(FIND_BY_MASK);
    }

}
