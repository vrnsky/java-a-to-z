package model;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 */
public class FileSystemLoadTest {

    /**
     * Path to directory which will use in this test.
     */
    private static final String PATH = String.format("%s%s%s", FileUtils.getTempDirectory(), File.separator, "cache");

    /**
     * When try load exist file should check that method return correct file.
     * @throws IOException if some error.
     */
    @Test
    void whenTryLoadExistFileShouldCheckThatMethodUploadItToMemory() throws IOException {
        File cache = Files.createTempFile("cache", ".txt").toFile();
        LoadMethod loadMethod = new FileSystemLoad();
        File expectedFile = new File(cache.toString());
        File actualFile = loadMethod.load(cache.toString());
        assertThat(actualFile, is(expectedFile));
    }

    /**
     * When try load not exist file should check that method upload return null.
     */
    @Test
    void whenTryLoadNotExistFileShouldCheckThatMethodUploadReturnNull() {
        LoadMethod loadMethod = new FileSystemLoad();
        File actualFile =  loadMethod.load(String.format("%s%s%s", PATH, File.separator, "bad_cache.txt"));
        assertThat(actualFile, nullValue());
    }
}
