package async;

import model.AbstractCache;
import model.FileSystemLoad;
import model.SimpleCache;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.09.2016
 * Simple counter which counts spaces and words at the file.
 */
public class Counter {

    /**
     * Specify file which using for counting.
     */
    private static final String PATH = String.format("%s%s%s", FileUtils.getUserDirectoryPath(), File.separator, "simple.txt");

    /**
     * Thread which count spaces in the text.
     */
    private SpaceCounter spaceCounter;

    /**
     * Thread which count words in the text.
     */
    private WordsCounter wordsCounter;

    /**
     * Flag which means that counter is finish it works.
     */
    private boolean isFinished = false;

    /**
     * Entry point of application.
     * @param args not use.
     */
    public static void main(String[] args) {
       new Counter().init();
    }

    /**
     * Load string to memory and count in it spaces and words.
     */
    public void init() {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        List<String> text = cache.get(PATH);
        spaceCounter = new SpaceCounter(text);
        wordsCounter = new WordsCounter(text);
        System.out.println("It is counter for spaces and words at the next. Counter start soon...");
        spaceCounter.start();
        wordsCounter.start();
        try {
            wordsCounter.join();
            spaceCounter.join();
            isFinished = true;
            System.out.println("Counter finished.");
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Return counting of spaces.
     * @return count of spaces in text.
     */
    public int getSpaces() {

        if(isFinished) {
            return this.spaceCounter.getSpaces();
        } else {
            throw new IllegalStateException("Counter not finished yet!");
        }
    }

    /**
     * Return counting of words.
     * @return counting of words.
     */
    public int getWords() {
        if(isFinished) {
            return this.wordsCounter.getWords();
        } else {
            throw new IllegalStateException("Counter not finished yet!");
        }
    }

    /**
     * Thread which count space.
     */
    private static class SpaceCounter extends Thread {
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
                for (int index = 0; index < string.length(); index++) {
                    if (Character.isSpaceChar(string.charAt(index))) {
                        System.out.printf("Spaces: %s\n", spaces++);
                    }
                }
            }
        }

        /**
         * Notice! Call this method after thread is finished.
         * @return all count of spaces in text.
         */
        public int getSpaces() {
            return this.spaces;
        }
    }

    /**
     * Thread which count words at the strings.
     */
    private static class WordsCounter extends Thread {

        /**
         * Counter of words.
         */
        volatile int words = 0;

        /**
         * String for counting words.
         */
        private List<String> text;

        /**
         * Create a new words counter.
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
            for(String string : text) {
                words += string.split(" +").length;
                System.out.printf("Words: %s\n", words);
            }
        }

        /**
         * Notice! Call this method after thread is end.
         * @return all count of words.
         */
        public int getWords() {
            return this.words;
        }
    }
}
