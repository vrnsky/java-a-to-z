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

    private volatile CopyOnWriteArrayList filePaths;
    private final Lock lock;

    public FileStorage() {
        this.filePaths = new CopyOnWriteArrayList();
        this.lock = new ReentrantLock();
    }

    public void addCheckedFile(String filePath) {
        lock.lock();
        try {
            this.filePaths.add(filePath);
        } finally {
            lock.unlock();
        }
    }

    public boolean isChecked(String filePath) {
        lock.lock();
        try {
            return this.filePaths.contains(filePath);
        } finally {
            lock.unlock();
        }
    }

    public List<String> getFileList() {
        return this.filePaths;
    }

}
