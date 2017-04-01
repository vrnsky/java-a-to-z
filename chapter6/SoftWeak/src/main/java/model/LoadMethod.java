package model;

import java.io.File;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 *
 * Each load method must implement this interface.
 */
public interface LoadMethod {

    /**
     * Describe how to load file from path.
     * @param path place from take file.
     * @return file loaded from path.
     */
    File load(String path);
}
