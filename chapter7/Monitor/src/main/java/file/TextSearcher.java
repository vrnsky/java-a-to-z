package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * @author evrnsky
 * @version 0.1
 * @since 17.11.2016
 * Implementation of searching text from file system.
 * It searches in readable and not hidden files.
 * Also check that contains file path searching text.
 */

public class TextSearcher extends Thread {

    /**
     * Logger for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(TextSearcher.class);

    /**
     * Flag which signal about find text or not.
     */
    private boolean founded = false;

    /**
     * Text for search.
     */
    private final String searchText;

    /**
     * Flag which specify continue work or stop.
     */
    private final AtomicBoolean run = new AtomicBoolean(true);

    /**
     * Root elements of file system - disk.
     */
    private final File[] disks = File.listRoots();

    /**
     * Instance of file storage for writing checked files.
     */
    private final FileStorage fileStorage;

    /**
     * List of files which contains search text.
     */
    private final List<String> resultFiles;


    /**
     * Constructor for text searcher thread.
     * @param text    search text.
     * @param storage instance of file storage for store already checked file.
     */
    public TextSearcher(final String text, final FileStorage storage) {
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
            searchFromDisk();
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
        if (!run.get()) {
            throw new IllegalStateException("Wait for finish of thread work.");
        }
        return this.resultFiles;
    }

    /**
     * Search file start from disk and recursive down.
     */
    private void searchFromDisk() {
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
        this.founded = readFile(file.getAbsolutePath(), text);
        log.info(String.format("SEARCH AT: %s", file.getAbsolutePath()));
        if (this.founded) {
            log.info(String.format("FOUND AT: %s", file.getAbsolutePath()));
            synchronized (this.resultFiles) {
                this.resultFiles.add(file.getAbsolutePath());
            }
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
