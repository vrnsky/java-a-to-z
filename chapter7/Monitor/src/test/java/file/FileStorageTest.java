package file;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.05.2017
 *
 * This unit test for file storage test.
 */
class FileStorageTest {

    /**
     * When try to add checked file should check that storage return true.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryAddCheckedFileShouldCheckThatStorageReturnTrue() throws Exception {
        FileStorage storage = new FileStorage();
        storage.addCheckedFile("path");
        assertThat(storage.isChecked("path"), is(true));
    }

    /**
     * When try check that file storage return false on not added file should check that false.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryCheckThatNotAddFileShouldCheckThatFileStorageReturnNull() throws Exception {
        FileStorage storage = new FileStorage();
        assertThat(storage.isChecked("path"), is(false));
    }
}