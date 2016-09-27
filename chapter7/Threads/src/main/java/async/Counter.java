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
    private static final String PATH = String.format("%s%s%s", FileUtils.getUserDirectoryPath(), File.separator, "how.txt");

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
    private void init() {
        AbstractCache cache = new SimpleCache(new FileSystemLoad());
        List<String> text = cache.get(PATH);
        Thread spaceCounter = new Thread(new SpaceCounter(text));
        spaceCounter.start();
        Thread wordsCounter = new Thread(new WordsCounter(text));
        wordsCounter.start();
    }

    /**
     * Thread which count space.
     */
    private static class SpaceCounter implements Runnable {
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
                        System.out.printf("Spaces: %s", spaces++);
                    }
                }
            }
        }
    }

    /**
     * Thread which count words at the strings.
     */
    private static class WordsCounter implements Runnable {

        /**
         * Counter of words.
         */
        private int words = 0;

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
                System.out.println("Words: " + words);
            }
        }
    }
}
