package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
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
    private static final String PATH = FileUtils.getTempDirectoryPath();

    /**
     * Folder for place all dirs for test.
     */
    private static final String FIND_BY_REGEXP = "findbyregexp";

    /**
     * One of requirement is searching in sub dirs.
     */
    private static final String SUBFOLDER = "subfolder";

    /**
     * Some file for test.
     */
    private static final String fileName = "regexp.txt";

    /**
     * Save all data find and not find.
     */
    @Test
    public void whenTrySearchFileByRegExpShouldCheckThatWeWriteResultInFile() throws Exception {
        prepareForTest();
        String searchFolder = String.format("%s%s", PATH, FIND_BY_REGEXP);
        File result = Files.createTempFile("result_findbyregexp", ".txt").toFile();
        String[] keys = new String[]{"-d", searchFolder, "-r", "^regexp.txt$", "-m", "-o", result.toString()};
        Answerer answerer = null;
        FindByRegExp finder = new FindByRegExp();
        String[] expected = new String[]{
                String.format("%s%s%s", "^regexp.txt$ was found at ", searchFolder , "\\regexp.txt, ") +
                String.format("%s%s%s", "^regexp.txt$ was found at ", searchFolder, "\\subfolder\\regexp.txt")
        };


        finder.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        afterTest();
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * Create dirs for this test.
     */
    private void prepareForTest() {
        try {
            String root = String.format("%s%s", PATH, FIND_BY_REGEXP);
            String sub = String.format("%s%s%s%s", PATH, FIND_BY_REGEXP, File.separator, SUBFOLDER);
            FileUtils.forceMkdir(new File(root));
            FileUtils.forceMkdir(new File(sub));
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("%s%s%s", root, File.separator, fileName)));
            writer.close();
            writer = new BufferedWriter(new FileWriter(String.format("%s%s%s", sub, File.separator, fileName)));
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Removing dirs which created for this test.
     */
    private void afterTest() {
        try {
            FileUtils.deleteDirectory(new File(String.format("%s%s", PATH, FIND_BY_REGEXP)));
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

}
