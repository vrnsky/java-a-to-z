package find;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 14.12.2016
 */
public class FileTestUtils {

    private static final String SUBFOLDER = "subfolder";

    public static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();


    private FileTestUtils() {

    }

    public static void createDirsAndFiles(String rootName, List<String> rootFiles, List<String> subFiles) throws IOException {
        FileUtils.forceMkdir(new File(String.format("%s%s%s", PATH, SEPARATOR, rootName)));
        FileUtils.forceMkdir(new File(String.format("%s%s%s%s%s", PATH, SEPARATOR, rootName, SEPARATOR, SUBFOLDER)));
        for (String rootFile : rootFiles) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("%s%s%s%s%s", PATH, SEPARATOR, rootName, SEPARATOR, rootFile)));
            writer.close();
        }

        for (String subFile : subFiles) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("%s%s%s%s%s%s%s", PATH, SEPARATOR, rootName, SEPARATOR, SUBFOLDER, SEPARATOR, subFile)));
            writer.close();
        }

    }

    public static void removeDir(String rootName) throws IOException {
        FileUtils.deleteDirectory(new File(String.format("%s%s", PATH, rootName)));
    }



}
