package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *  Unit test for FindByName.java.
 */
public class FindByNameTest {

    /**
     * At this path will start search and save result.
     */
    private static final String PATH = FileUtils.getTempDirectoryPath();

    /**
     * Folder for test.
     */
    private static final String FIND_BY_NAME = "findbyname";

    /**
     * Apps should check also subfolders.
     */
    private static final String SUBFOLDER = "subfolder";

    /**
     * Name of file for search.
     */
    private static final String fileName = "name.txt";

    /**
     * Check that find correct write result and correct finding files,
     * if file was not found should show it and show directory
     * also file was found should show it and show directory.
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() throws Exception {
        prepareForTest();
        String searchFolder = String.format("%s%s", PATH, FIND_BY_NAME);
        File file = Files.createTempFile("name", "").toFile();
        String[] keys = new String[]{"-d", searchFolder , "-n", "name.txt", "-n", "-o", file.toString()};
        Answerer answerer = null;
        FindByName finder = new FindByName();
        String[] expected = new String[]{
                String.format("%s%s%s","name.txt was found at ", searchFolder, "\\name.txt"),
                String.format("%s%s%s", "name.txt was found at ", searchFolder, "\\subfolder\\name.txt")
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
            String root = String.format("%s%s", PATH, FIND_BY_NAME);
            String sub = String.format("%s%s%s%s", PATH, FIND_BY_NAME, File.separator, SUBFOLDER);
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
            FileUtils.deleteDirectory(new File(String.format("%s%s", PATH, FIND_BY_NAME)));
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

}
