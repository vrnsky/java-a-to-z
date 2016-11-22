package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * @author evrnsky
 * @version 0.1
 * @since 17.11.2016
 * Implementation of searching text from file system.
 * It search in readable and not hidden files.
 * Also check that contains file path searching text.
 */
public class TextSearcher extends Thread {

    /**
     * Logger for this class
     */
    private static Logger LOG = Logger.getLogger(TextSearcher.class);

    /**
     * Flag which signal about find text or not.
     */
    private boolean founded = false;

    /**
     * Text for search.
     */
    private String searchText;

    /**
     * Flag which specify continue work or stop.
     */
    private AtomicBoolean run = new AtomicBoolean(true);

    /**
     * Root elements of file system - disk
     */
    private File[] disks = File.listRoots();

    /**
     * Instance of file storage for writing checked files.
     */
    private FileStorage fileStorage;

    /**
     * List of files which contains search text.
     */
    private List<String> resultFiles;


    /**
     * Constructor for text searcher thread.
     * @param text    search text.
     * @param storage instance of file storage for store already checked file.
     */
    public TextSearcher(String text, FileStorage storage) {
        this.searchText = text;
        this.fileStorage = storage;
        this.resultFiles = new ArrayList<>();
    }

    /**
     * Return true if something was found.
     * @return true if something was found, otherwise false.
     */
    public boolean getFounded() {
        return this.founded;
    }

    /**
     * Search text from root elements of file system to the end.
     */
    @Override
    public void run() {
        while (run.get()) {
            searchFromDisk(this.searchText);
        }
    }

    /**
     * Stop thread.
     */
    public void brake() {
        this.run.set(false);
        this.interrupt();
    }

    /**
     * Return list of found files.
     * @return list of found files.
     */
    public List<String> getFileList() {
        return this.resultFiles;
    }

    /**
     * Search from disk.
     * @param text for search.
     */
    private void searchFromDisk(String text) {
        for (File disk : disks) {
                search(disk.getAbsolutePath());
        }
    }

    /**
     * Recursive search from directory to file.
     * @param disk start of search.
     * @return true if text is find, otherwise false.
     */
    private boolean search(String disk) {
        File[] files = new File(disk).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    search(file.getAbsolutePath());
                } else if (isCorrectFile(file) && !this.isInterrupted()) {
                    processingFile(file, this.searchText);
                }
            }
        }
        return founded;
    }

    /**
     * Read file and set founded flag.
     * @param file for reading.
     * @param text for searching.
     */
    private void processingFile(File file, String text) {
        founded = readFile(file.getAbsolutePath(), text);
        LOG.log(Level.INFO, String.format("SEARCH AT: %s", file.getAbsolutePath()));
        if (founded) {
            LOG.log(Level.INFO, String.format("FOUND AT: %s", file.getAbsolutePath()));
            this.resultFiles.add(file.getAbsolutePath());
        }
        this.fileStorage.addCheckedFile(file.getAbsolutePath());
    }

    /**
     * Read file.
     * @param file for reading.
     * @param text for searching.
     * @return true if some string in file contains text or
     * file path contains text, otherwise false.
     */
    private boolean readFile(String file, String text) {
        boolean find = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains(text)) {
                    find = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if (file.contains(text)) {
            find = true;
        }
        return find;
    }

    /**
     * Checked that current file correct.
     * Correct means that file not read yet, not hidden and can read.
     * @param file instance of file.
     * @return true if all expression is true, otherwise false.
     */
    private boolean isCorrectFile(File file) {
        return file.canRead() && !this.fileStorage.isChecked(file.getAbsolutePath()) && !file.isHidden();
    }


}
