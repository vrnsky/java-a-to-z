package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
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
    private static final String PATH = FileUtils.getUserDirectoryPath();

    /**
     * Check that find correct write result and correct finding files,
     * if file was not found should show it and show directory
     * also file was found should show it and show directory.
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() throws Exception {

        //Assign block
        String searchFolder = String.format("%s%s%s", PATH, File.separator, "findbyname");
        String resultFolder = String.format("%s%s%s", PATH, File.separator, "result");
        Path file = Files.createTempFile(Paths.get(resultFolder), "name", "");
        String[] keys = new String[]{"-d", searchFolder , "-n", "name.txt", "-n", "-o", file.toString()};
        Answerer answerer = null;
        FindByName finder = new FindByName();
        String[] expected = new String[]{
                String.format("%s%s%s","name.txt was found at ", searchFolder, "\\name.txt"),
                String.format("%s%s%s", "name.txt was found at ", searchFolder, "\\subfolder\\name.txt")
        };


        //Action block
        finder.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

}
