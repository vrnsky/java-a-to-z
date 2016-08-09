package model;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple generator. Generate string with given data.
 */
public class SimpleGenerator implements Template {

    /**
     * String view of regular expression.
     */
    private static final String REGEXP = "\\$\\{\\w+\\}";

    /**
     * Compiled regular expression.
     */
    private static final Pattern PATTERN = Pattern.compile(REGEXP);


    /**
     * Generate string from string with key. Value take from key-value storage.
     * @param template string with all keys.
     * @param dictionary all key-value pairs.
     * @return string with values without keys.
     */
    public String generate(String template, Map<String, String> dictionary) {
        if(template == null || dictionary == null || dictionary.size() == 0 || !checkMatches(template, dictionary.size())) {
            throw new IllegalArgumentException("Bad arguments, please check arguments.");
        }
        StringBuffer buffer = new StringBuffer(template);
        Matcher matcher = PATTERN.matcher(buffer);
        while(matcher.find()) {
            buffer.replace(matcher.start(), matcher.end(), dictionary.get(getCleanKey(buffer.substring(matcher.start(), matcher.end()))));
        }
        return buffer.toString();
    }

    /**
     * Count matches and check that matches equals for length of data array.
     * @param template string with template.
     * @param value size of data array.
     * @return true if matches equals data.length, otherwise false.
     */
    public boolean checkMatches(String template, int value) {
        Matcher matcher = PATTERN.matcher(template);
        int count = 0;
        while(matcher.find()) {
            count++;
        }
        return count == value;
    }

    /**
     * Remove from string ${ and }.
     * @param key from template.
     * @return key without dollar and brackets.
     */
    public String getCleanKey(String key) {
        return key.substring(2, key.length()-1);
    }

}
