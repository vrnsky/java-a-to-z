package model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 */
public class FileSystemLoad implements LoadMethod {

    /**
     * Load file to memory.
     * @param path to file.
     * @return return file.
     */
    @Override
    public File load(String path) {
        Path filePath = Paths.get(path);
        File resultFile = null;
        if(Files.exists(filePath)) {
            resultFile = filePath.toFile();
        }
        return resultFile;
    }
}
