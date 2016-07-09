package find;

import chat.Answerer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;

/**
 *  Unit test for FindByName.java
 */
public class FindByNameTest {

    /**
     * At this path will start search and save result
     */
    private static final String PATH = "F:/java-a-to-z/iml/move/";

    /**
     * Check that find correct write result and correct finding files
     * if file was not found should show it and show directory
     * also file was found should show it and show directory
     */
    @Test
    public void whenTrySearchFileByNameShouldFndFileIfExistAndSavePathToItInFile() {

        //Assign block
        String[] keys = new String[]{"-d", PATH , "-n", "name.txt", "-n", "-o", PATH + "/result//findbyname/findbyname.txt/"};
        Answerer answerer = null;
        FindByName finder = new FindByName();
        String[] expected = new String[]{
                "name.txt was not found at F:\\java-a-to-z\\iml\\move\\result\\findbymask\\findbymask.txt",
                "name.txt was not found at F:\\java-a-to-z\\iml\\move\\result\\findbyname\\findbyname.txt",
                "name.txt was not found at F:\\java-a-to-z\\iml\\move\\test\\findbymask\\mask.txt",
                "name.txt was found at F:\\java-a-to-z\\iml\\move\\test\\findbyname\\name.txt",
               "name.txt was not found at F:\\java-a-to-z\\iml\\move\\test\\findnyregexp\\regexp.txt",
        };

        //Action block
        finder.find(keys);
        try {
            answerer = new Answerer(PATH + "/result//findbyname/findbyname.txt/");
        } catch(IOException exp) {
            System.out.println("Result file N/A");
        }
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

}
