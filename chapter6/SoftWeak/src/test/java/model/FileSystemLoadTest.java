package model;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import java.io.File;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 */
public class FileSystemLoadTest {

    /**
     * Path to directory which will use in this test.
     */
    private static final String PATH = String.format("%s%s%s",FileUtils.getUserDirectoryPath(), File.separator, "cache");

    /**
     * When try load exist file should check that method return correct file.
     */
    @Test
    public void whenTryLoadExistFileShouldCheckThatMethodUploadItToMemory() {
        LoadMethod loadMethod = new FileSystemLoad();
        File expectedFile = new File(String.format("%s%s%s", PATH, File.separator, "cache.txt"));
        File actualFile = loadMethod.load(String.format("%s%s%s", PATH, File.separator, "cache.txt"));
        assertThat(actualFile, is(expectedFile));
    }

    /**
     * When try load not exist file should check that method upload return null.
     */
    @Test
    public void whenTryLoadNotExistFileShouldCheckThatMethodUploadReturnNull() {
        LoadMethod loadMethod = new FileSystemLoad();
        File actualFile =  loadMethod.load(String.format("%s%s%s", PATH, File.separator, "bad_cache.txt"));
        assertThat(actualFile, nullValue());
    }
}
