package find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.chat.Answerer;
import org.apache.commons.io.FileUtils;
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This unit test for finder by mask.
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
     * @throws Exception if something wrong.
     */
    @Test
    void whenTrySearchFileByMaskShouldSaveResultInSpecifiedFile() throws Exception {
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
        List<String> actual = answerer.getAllStrings();

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_MASK);
    }

    /**
     * When try check that method check works correct should check that works fine.
     * @throws IOException if some error when create a temp file.
     */
    @Test
    void whenTryCheckThatMethodCheckWorksCorrectShouldCheckThatWorksFine() throws IOException {
        File file = File.createTempFile("mask", "txt");
        FindByMask finder = new FindByMask();
        boolean actual = finder.check(file, file.getName());
        assertThat(actual, is(true));
    }

    /**
     * When try check that method check works correct should check that return false.
     * When param is not suitable.
     * @throws IOException if some error when temp file creation.
     */
    @Test
    void whenTryCheckThatMethodCheckWorksCorrectShouldCheckThatReturnFalse() throws IOException {
        File file = File.createTempFile("mask", "txt");
        FindByMask finder = new FindByMask();
        boolean actual = finder.check(file, "random mask");
        assertThat(actual, is(false));
    }

    /**
     * Check that when try parse an not exist directory should check that app throw exception.
     */
    @Test
    void whenTryGiveFinderEmptyDirectoryShouldCheckThatThrowException() {
        FindByMask findByMask = new FindByMask();
        Assertions.assertThrows(IllegalArgumentException.class, () -> findByMask.find(new String[]{"1", "not exist dir", "3", "4", "5", "6", "7"}));
    }

}
