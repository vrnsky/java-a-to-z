package file;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.11.2016
 * Manager for TextSearcher threads.
 * It manage all thread for searching text.
 */
public class Application extends Thread {

    /**
     * Instance of text searcher thread.
     */
    private TextSearcher textSearcher;

    /**
     * At this store already read files.
     */
    private FileStorage fileStorage;

    /**
     * Text for search.
     */
    private String text;

    /**
     * Flag which say us continue work or stop.
     */
    private AtomicBoolean run = new AtomicBoolean(true);

    /**
     * Flag for state of thread.
     */
    private boolean init = false;

    public Application(String text) {
        this.text = text;
        this.text = text;
        this.fileStorage = new FileStorage();
    }

    /**
     * While continue work, checked that thread are init.
     * If is not init, init it. Further, checked that
     * flag of continue work is true and async ask text searcher thread
     * about finded text. If it found text, stop it.
     */
    @Override
    public void run() {
        while(run.get()) {
            if(!init) {
                initAllThread();
            } else if(run.get()) {
                if(textSearcher.getFounded()) {
                    run.set(false);
                    textSearcher.brake();
                }
            }
        }
    }

    /**
     * Init thread and start.
     */
    private void initAllThread() {
        init = true;
        this.textSearcher = new TextSearcher(this.text, this.fileStorage);
        this.textSearcher.start();
    }

}
