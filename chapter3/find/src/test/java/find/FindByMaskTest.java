package find;

import chat.Answerer;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *  Unit test for FindByMask.java.
 */
public class FindByMaskTest {

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getUserDirectoryPath();

    /**
     * When user give correct keys should find file and save all data.
     */
    @Test
    public void whenTrySearchFileByMaskShouldSaveResultInSpecifiedFile() throws Exception {

        //Assign block
        String searchFolder = String.format("%s%s%s", PATH, File.separator, "findbymask");
        String resultFolder = String.format("%s%s%s", PATH, File.separator, "result");
        Path file = Files.createTempFile(Paths.get(resultFolder), "mask","");
        String[] keys = new String[]{"-d", searchFolder, "-n", "r*.txt", "-f", "-o", file.toString()};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        String[] expected = new String[] {
                String.format("%s%s%s","r*.txt was found at ", PATH, "\\findbymask\\rmask.txt, ") +
                String.format("%s%s%s","r*.txt was not found at ", PATH, "\\findbymask\\subfolder\\mask.txt")
        };

        //Act block
        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }
}
