package find;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
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

}
