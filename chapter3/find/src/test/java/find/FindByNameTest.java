package find;

import chat.Answerer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;

/**
 *  Unit test for FindByName.java.
 */
public class FindByNameTest {

    /**
     * At this path will start search and save result.
     */
    private static final String PATH = "F:/java-a-to-z/chapter3/find/src/test/java/move/";

    /**
     * Check that find correct write result and correct finding files,
     * if file was not found should show it and show directory
     * also file was found should show it and show directory.
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() throws Exception {

        //Assign block
        String[] keys = new String[]{"-d", PATH + "test/findbyname" , "-n", "name.txt", "-n", "-o", PATH + "result/findbyname/findbyname.txt"};
        Answerer answerer = null;
        FindByName finder = new FindByName();
        String[] expected = new String[]{
                "name.txt was found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbyname\\name.txt",
                "name.txt was found at F:\\java-a-to-z\\chapter3\\find\\src\\test\\java\\move\\test\\findbyname\\subfolder\\name.txt"
        };

        //Action block
        finder.find(keys);
        answerer = new Answerer(keys[6]);
        String[] actual = answerer.getAllStrings();

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

}
