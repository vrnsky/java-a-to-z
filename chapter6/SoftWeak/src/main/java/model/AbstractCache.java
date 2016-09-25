package model;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 * Abstract model of cache.
 */
public abstract class AbstractCache {

    /**
     * Determine how to load file.
     */
    private LoadMethod method;

    /**
     * Model of cache.
     */
    private Map<String, SoftReference<File>> cache;

    /**
     * Create a new abstract cache with given param.
     * @param method instance of LoadMethod interface which describe how to upload file to memory.
     */
    public AbstractCache(LoadMethod method) {
        this.cache = new HashMap<>();
        this.method = method;
    }

    /**
     * Get file from cache if file already in cache, otherwise load file to cache.
     * @param fileName path to file.
     * @return instance of file.
     */
    private File getFile(String fileName) {
        File file = null;
        if(this.cache.containsKey(fileName)) {
            file = this.cache.get(fileName).get();
        } else {
            File newFile = this.method.load(fileName);
            if(newFile == null) {
                throw new IllegalStateException("File not exist");
            }
            this.cache.put(fileName, new SoftReference<>(newFile));
            file = newFile;
        }
        return file;
    }

    /**
     * Return list of string which contains at the given file.
     * @param path to the file.
     * @return list of strings in cache file.
     * @throws IOException if something was wrong with file.
     */
    public List<String> getDataFromFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = this.getFile(path);
        try(BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
            String string = "";
            while((string = reader.readLine()) != null) {
                strings.add(string);
            }
        }
        return strings;
    }

    /**
     * Return state of filling cache.
     * @return true if cache is empty otherwise false.
     */
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    /**
     * Return size of cache.
     * @return size of cache.
     */
    public int size() {
        return this.cache.size();
    }
}
