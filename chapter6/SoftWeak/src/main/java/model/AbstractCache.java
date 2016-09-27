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
    private Map<String, SoftReference<List<String>>> cache;

    /**
     * Create a new abstract cache with given param.
     * @param method instance of LoadMethod interface which describe how to upload file to memory.
     */
    public AbstractCache(LoadMethod method)   {
        this.cache = new HashMap<>();
        this.method = method;
    }

    /**
     * Return strings from file.
     * @param key file name.
     * @return string in file which specify by key arg.
     */
    public List<String> get(String key) {
        List<String> strings;
        if(this.cache.containsKey(key)) {
            strings = this.cache.get(key).get();
        } else {
            strings = getDataFromFile(key);
            this.cache.put(key, new SoftReference<>(strings));
        }
        return strings;
    }

    /**
     * Read file and return data from it.
     * @param fileName specify file to read.
     * @return string which was read from file.
     */
    private List<String> getDataFromFile(String fileName)   {
        List<String> strings = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String string = "";
            while((string = reader.readLine()) != null) {
                strings.add(string);
            }
        } catch (IOException exp) {
            exp.printStackTrace();
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
