package file;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author evrnsky
 * @version 0.1
 * @since 19.11.2016
 */
public class FileStorage {

    /**
     * At this place hold all data.
     */
    private volatile CopyOnWriteArrayList filePaths;

    /**
     * For correct multithreading access.
     */
    private final Lock lock;

    /**
     * Create a new file storage.
     */
    public FileStorage() {
        this.filePaths = new CopyOnWriteArrayList();
        this.lock = new ReentrantLock();
    }

    /**
     * Add checked file to the list.
     * @param filePath represent string view of file path from file system.
     */
    public void addCheckedFile(String filePath) {
        lock.lock();
        try {
            this.filePaths.add(filePath);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Check that given string view of file path already checked.
     * @param filePath string view of file path.
     * @return true if given file path already checked, otherwise false.
     */
    public boolean isChecked(String filePath) {
        lock.lock();
        try {
            return this.filePaths.contains(filePath);
        } finally {
            lock.unlock();
        }
    }
}
