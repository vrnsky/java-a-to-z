package find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.chat.Answerer;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for FindByRegExp.java.
 * @author vrnsky
 * @version 0.1
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
    private static final String FILE_NAME = "r*.txt";

    /**
     * Save all data find and not find.
     * @throws Exception if something wrong.
     */
    @Test
    void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() throws Exception {
        FileTestUtils.createDirsAndFiles(FIND_BY_REGEXP, Arrays.asList("regexp.txt"), Arrays.asList("regexp.txt"));
        String searchFolder = String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, FIND_BY_REGEXP);
        File file = Files.createTempFile("regexp", "").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-n", FILE_NAME, "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s%s%s%s%s", FILE_NAME, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "regexp.txt"));
        expected.add(String.format("%s%s%s%s%s%s%s", FILE_NAME, " was found at ", searchFolder, FileTestUtils.SEPARATOR, "subfolder", FileTestUtils.SEPARATOR, "regexp.txt"));

        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        List<String> actual = answerer.getAllStrings();

        assertThat(actual.containsAll(expected), is(true));
        FileTestUtils.removeDir(FIND_BY_REGEXP);
    }


    /**
     * When try check that name suitable should check that app return correct answer.
     * @throws IOException if io error happened.
     */
    @Test
    void whenTryCheckThatNameSuitableShouldCheckThatAppReturnCorrectAnswer() throws IOException {
        FindByName findByName = new FindByName();
        File file = Files.createTempFile("ram", "txt").toFile();
        assertThat(findByName.check(file, file.getName()), is(true));
    }

    /**
     * When try check that name is not suitable should check that app return correct answer.
     * @throws IOException if io error happened.
     */
    @Test
    void whenTryCheckThatNameIsNotSuitableShouldCheckThatAppReturnCorrectAnswer() throws IOException {
        FindByName findByName = new FindByName();
        File file = Files.createTempFile("baby", "").toFile();
        assertThat(findByName.check(file, "r*"), is(false));
    }

    /**
     * Check that when try parse a not exist directory should check that app throw exception.
     */
    @Test
    void whenTryGiveFinderEmptyDirectoryShouldCheckThatThrowException() {
        FindByName findByName = new FindByName();
        Assertions.assertThrows(IllegalArgumentException.class, () -> findByName.find(new String[]{"1", "not exist dir", "3", "4", "5", "6", "7"}));
    }



}
