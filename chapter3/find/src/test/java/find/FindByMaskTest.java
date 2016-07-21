package find;

import chat.Answerer;
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
    private static final String PATH = "F:/java-a-to-z/chapter3/find/src/test/java/move/";

    /**
     * When user give correct keys should find file and save all data.
     */
    @Test
    public void whenTrySearchFileByMaskShouldSaveResultInSpecifiedFile() throws Exception {

        //Assign block
        String[] keys = new String[]{"-d", PATH + "test/findbymask", "-n", "r*.txt", "-f", "-o", PATH + "result/findbymask/findbymask.txt"};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        String[] expected = new String[] {
                "r*.txt was found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbymask\\rmask.txt",
                "r*.txt was not found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbymask\\subfolder\\mask.txt"};
        //Act block
        findByMask.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }



}
