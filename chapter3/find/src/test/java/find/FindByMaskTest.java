package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for FindByMask.java.
 */
public class FindByMaskTest {

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();

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
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s%s%s%s", "r*.txt was found at ", searchFolder, FileTestUtils.SEPARATOR, "rmask.txt"));
        expected.add(String.format("%s%s%s%s%s%s", "r*.txt was not found at ", searchFolder, FileTestUtils.SEPARATOR, "subfolder", FileTestUtils.SEPARATOR, "mask.txt"));

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        List<String> actual = Arrays.asList(answerer.getAllStrings());

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_MASK);
    }

}
