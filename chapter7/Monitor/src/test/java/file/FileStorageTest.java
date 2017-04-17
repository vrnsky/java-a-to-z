package file;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.05.2017
 *
 * This unit test for file storage test.
 */
public class FileStorageTest {

    /**
     * When try add checked file should check that storage return true.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryAddCheckedFileShouldCheckThatStorageReturnTrue() throws Exception {
        FileStorage storage = new FileStorage();
        storage.addCheckedFile("path");
        assertThat(storage.isChecked("path"), is(true));
    }

    /**
     * When try check that file storage return false on not added file should check that false.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryCheckThatNotAddFileShouldCheckThatFileStorageReturnNull() throws Exception {
        FileStorage storage = new FileStorage();
        assertThat(storage.isChecked("path"), is(false));
    }
}