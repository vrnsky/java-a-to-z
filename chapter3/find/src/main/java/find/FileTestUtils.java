package find;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.2
 * @since 14.12.2016
 * Utils for test which provide access to the file system.
 */
public class FileTestUtils {


    /**
     * Separator for paths.
     */
    public static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * Name of subfolder.
     */
    private static final String SUBFOLDER = "subfolder";

    /**
     * From this path will start search and will save result.
     */
    private static final String PATH = FileUtils.getTempDirectory().toString();


    /**
     * Utils class does not have public constructor. It is for your safety.
     */
    private FileTestUtils() {
    }

    /**
     * Create a catalogs for test.
     * @param rootName  for root folder.
     * @param rootFiles file which will place at the root.
     * @param subFiles  file which will place at the subfolder.
     * @throws IOException if lib methods have problem.
     */
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

    /**
     * Remove given dir.
     * @param rootName name of dir which will remove.
     * @throws IOException if problem with removing in lib method.
     */
    public static void removeDir(String rootName) throws IOException {
        FileUtils.deleteDirectory(new File(String.format("%s%s%s", PATH, SEPARATOR, rootName)));
    }

    /**
     * Create a file and fill it by data from list of strings.
     * @param testingFolder folder for test.
     * @param fileName name of file which will be create.
     * @param strings  data for full file.
     * @throws IOException if write to file fails.
     */
    public static void createAndFillFile(String testingFolder, String fileName,  List<String> strings) throws IOException {
        FileUtils.forceMkdir(new File(String.format("%s%s%s", PATH, SEPARATOR, testingFolder)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("%s%s%s%s%s", PATH, SEPARATOR, testingFolder, SEPARATOR, fileName)));
        for (String str : strings) {
            writer.write(str);
        }
        writer.close();
    }



}
