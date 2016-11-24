package pool;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 23.11.2016
 * Extended version of thread.
 */
public  class Work implements Runnable {

    /**
     * New new version of run method.
     */
    @Override
    public void run() {
        Logger.getLogger(Work.class).log(Level.INFO, String.format("%s write to log", Thread.currentThread().getName()));
    }
}

