package find;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.2
 * @since 19.12.2016
 * Unit test for file utils which provide next function create and remove catalogs.
 *
 */
public class UtilsTest {

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();


    /**
     * When utils create a full catalog should check that it created.
     * @throws Exception if writer at the utils have problem.
     */
    @Test
    public void whenCreateCatalogShouldCheckThatAllIsCreated() throws Exception {
       FileTestUtils.createDirsAndFiles("testing", Arrays.asList("name.txt"), Arrays.asList("name.txt"));
       File rootFile = new File(String.format("%s%s%s%s%s", PATH, FileTestUtils.SEPARATOR, "testing", FileTestUtils.SEPARATOR, "name.txt"));
       assertThat(rootFile.exists(), is(true));
       FileTestUtils.removeDir("testing");
    }

    /**
     * When remove a catalog should check that is already not exist.
     * @throws Exception if library function remove dir have problem with removing.
     */
    @Test
    public void whenRemoveDirShouldCheckThatAllRemoved() throws Exception {
        FileTestUtils.createDirsAndFiles("testing", Arrays.asList("name.txt"), Arrays.asList("name.txt"));
        FileTestUtils.removeDir("testing");
        File rootFile = new File(String.format("%s%s%s", PATH, FileTestUtils.SEPARATOR, "testing"));
        assertThat(rootFile.exists(), is(false));
    }

    /**
     * When create a file and fill it by data should check that all ok.
     * @throws IOException if problem with file system.
     */
    @Test
    public void whenCreateAndFillFileShouldCheckThatAllOk() throws IOException {
        final String folder = "folder";
        final String fileName = "test.txt";
        List<String> expectedStrings = Arrays.asList("happy");
        FileTestUtils.createAndFillFile(folder, fileName,  expectedStrings);
        BufferedReader reader = new BufferedReader(new FileReader(String.format("%s%s%s%s%s", PATH, FileTestUtils.SEPARATOR, folder, FileTestUtils.SEPARATOR, fileName)));
        List<String> strings = new ArrayList<>();
        String s = "";
        while ((s = reader.readLine()) != null) {
            strings.add(s);
        }
        assertThat(strings, is(expectedStrings));
    }

}
