package find;

import chat.Answerer;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 *  Unit test for FindByMask.java
 */
public class FindByMaskTest {

    /**
     * From this path will start search and will save result
     */
    private static final String PATH = "F:/java-a-to-z/iml/move/";

    /**
     * When user give correct keys should find file and save all data
     */
    @Test
    public void whenTrySearchFileByMaskShouldSaveResultInSpecifiedFile() {

        //Assign block
        String[] keys = new String[]{"-d", PATH, "-n", "r*.txt", "-f", "-o", PATH + "/result//findbymask/findbymask.txt/"};
        FindByMask findByMask = new FindByMask();
        Answerer answerer = null;
        String[] expected = new String[] {"r*.txt was not found at F:\\java-a-to-z\\iml\\move\\result\\findbyname\\findbyname.txt",
                                          "r*.txt was not found at F:\\java-a-to-z\\iml\\move\\test\\findbymask\\mask.txt",
                                          "r*.txt was not found at F:\\java-a-to-z\\iml\\move\\test\\findbyname\\name.txt",
                                          "r*.txt was found at F:\\java-a-to-z\\iml\\move\\test\\findnyregexp\\regexp.txt"
                                         };
        //Act block
        findByMask.find(keys);
        try {
            answerer = new Answerer(keys[6]);
        } catch(IOException exp) {
            System.out.println(exp.getMessage());
        }
        String[] actual = answerer.getAllStrings();

        //Action block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }



}
