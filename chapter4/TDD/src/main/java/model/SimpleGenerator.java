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
     * @param template   string with all keys.
     * @param dictionary all key-value pairs.
     * @return string with values without keys.
     */
    public String generate(String template, Map<String, String> dictionary) {
        if (template == null || dictionary == null || dictionary.size() == 0) {
            throw new IllegalArgumentException("Bad arguments, please check arguments.");
        }
        StringBuffer buffer = new StringBuffer(template);
        Matcher matcher = PATTERN.matcher(buffer);
        try {
            while (matcher.find()) {
                buffer.replace(matcher.start(), matcher.end(), dictionary.get(getCleanKey(buffer.substring(matcher.start(), matcher.end()))));
            }
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("Not found some key(s) at the dictionary");
        }

        if (buffer.indexOf("${") != -1 && buffer.indexOf("}") != -1) {
            throw new IllegalArgumentException("You don\'t use all values from dictionary!");
        }
        return buffer.toString();
    }

    /**
     * Remove from string ${ and }.
     *
     * @param key from template.
     * @return key without dollar and brackets.
     */
    public String getCleanKey(String key) {
        return key.substring(2, key.length() - 1);
    }

}
