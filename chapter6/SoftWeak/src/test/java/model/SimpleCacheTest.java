package model;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 */
public class SimpleCacheTest {

    /**
     * Path which will use for this test.
     */
    private static final String PATH = String.format("%s%s%s", FileUtils.getTempDirectory(), System.getProperty("file.separator"), "cache");

    /**
     * When cache is only start should check that size is zero and it is empty.
     */
    @Test
    public void whenCacheStartShouldCheckThatCacheIsEmpty() {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        assertThat(cache.size() == 0 && cache.isEmpty(), is(true));
    }

    /**
     * When try load exist file to cache should that file was added to cache.
     * @throws IOException if something was wrong at reading process.
     */
    @Test
    public void whenTryLoadExistFileToCacheShouldCheckThatFileWasAddedToCache() throws IOException {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        List<String> strings = new ArrayList<>();
        strings.add("Please, cache me!");
        File cachedFile = Files.createTempFile("cache", ".txt").toFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(cachedFile));
        writer.write("Please, cache me!");
        writer.flush();
        writer.close();

        List<String> cached = cache.get(cachedFile.toString());
        Iterator<String> iterator = cached.iterator();
        for(String string : strings) {
            assertThat(string, is(iterator.next()));
        }
    }

}
