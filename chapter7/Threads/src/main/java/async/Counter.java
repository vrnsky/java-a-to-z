package async;

import java.util.List;
import java.util.StringTokenizer;

/**
 * @author evrnsky
 * @version 0.4
 * @since 27.09.2016
 * Simple counter which counts spaces and words at the file.
 */
public class Counter {


    /**
     * Thread which count spaces in the text.
     */
    private SpaceCounter spaceCounter;

    /**
     * Thread which count words in the text.
     */
    private WordsCounter wordsCounter;

    /**
     * Flag which means that some thread is interrupt.
     */
    private boolean wasInterrupted = false;

    /**
     * Hold start of thread.
     */
    private long startTime = 1L;


    private void startThreads() {
        spaceCounter.start();
        wordsCounter.start();
    }

    /**
     * Start compute. At this method main works.
     * @param text from file for compute.
     * @param ms max execution time.
     */
    public void start(List<String> text, long ms) {
        this.initThreads(text);
        this.startThreads();

        try {
            waitForThreads(ms);
            if (System.currentTimeMillis() - startTime > ms) {
                stopThread();
            }
        } catch (InterruptedException exp) {
            System.out.println("Calculation was stopped.");
        }

        printResults();
        System.out.println("Finish.");
    }

    /**
     * Init thread. All you need is create thrad object.
     * @param text from file.
     */
    private void initThreads(List<String> text) {
        this.spaceCounter = new SpaceCounter(text);
        this.wordsCounter = new WordsCounter(text);
        System.out.println("Start");
        startTime = System.currentTimeMillis();
    }

    /**
     * Wait that all thread at given time.
     * @param ms time for waiting.
     * @throws InterruptedException if some thread bad.
     */
    public void waitForThreads(long ms) throws InterruptedException {
        this.spaceCounter.join(ms);
        this.wordsCounter.join(ms);
    }

    /**
     * Try to stop thread.
     * @throws InterruptedException
     */
    private void stopThread() throws InterruptedException {
        if (this.spaceCounter.isAlive()) {
            this.spaceCounter.interrupt();
        }
        if (this.wordsCounter.isAlive()) {
            this.wordsCounter.interrupt();
        }

        this.wordsCounter.join();
        this.spaceCounter.join();
    }

    /**
     * Return counting of spaces.
     * @return count of spaces in text.
     */
    public int getSpaces() {
        return this.spaceCounter.getSpaces();

    }

    /**
     * Return counting of words.
     * @return counting of words.
     */
    public int getWords() {
        return this.wordsCounter.getWords();
    }

    /**
     * Print result about calculation.
     */
    public void printResults() {
        if (wasInterrupted) {
            System.out.println("Calculation was stopped.");
        } else {
            System.out.printf("Words is %s\n", this.wordsCounter.getWords());
            System.out.printf("Spaces is %s\n", this.spaceCounter.getSpaces());
        }
    }

    /**
     * Thread which count space.
     */
    private class SpaceCounter extends Thread {
        /**
         * String from file.
         */
        private List<String> text;

        /**
         * Counter for spaces.
         */
        int spaces = 0;

        /**
         * Create a new space counter with given strings.
         *
         * @param text string for which count spaces.
         */
        public SpaceCounter(List<String> text) {
            this.text = text;
        }

        /**
         * Move across all string in list and find space in it.
         */
        @Override
        public void run() {
            for (String string : text) {
                for (char ch : string.toCharArray()) {
                    if (Character.isSpaceChar(ch)) {
                        spaces++;
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    wasInterrupted = true;
                }
            }
        }

        /**
         * Notice! Call this method after thread is finished.
         *
         * @return all count of spaces in text.
         */
        public int getSpaces() {
            return this.spaces;
        }
    }

    /**
     * Thread which count words at the strings.
     */
    private class WordsCounter extends Thread {

        /**
         * Counter of words.
         */
        int words = 0;

        /**
         * String for counting words.
         */
        private List<String> text;

        /**
         * Create a new words counter.
         *
         * @param text for counting words.
         */
        public WordsCounter(List<String> text) {
            this.text = text;
        }

        /**
         * Counting words in text.
         */
        @Override
        public void run() {
            for (String string : text) {
                StringTokenizer tokenizer = new StringTokenizer(string);
                while (tokenizer.hasMoreElements() && !Thread.currentThread().isInterrupted()) {
                    tokenizer.nextToken();
                    words++;
                }
                if (Thread.currentThread().isInterrupted()) {
                    wasInterrupted = true;
                }
            }
        }

        /**
         * Notice! Call this method after thread is end.
         *
         * @return all count of words.
         */
        public int getWords() {
            return this.words;
        }
    }


}
