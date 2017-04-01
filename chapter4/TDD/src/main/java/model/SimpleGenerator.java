package model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
        Set<String> usedValues = new HashSet<>();
        StringBuffer buffer = new StringBuffer(template);
        Matcher matcher = PATTERN.matcher(buffer);

        while (matcher.find()) {
            String cleanKey = this.getCleanKey(buffer.substring(matcher.start(), matcher.end()));
            if (dictionary.containsKey(cleanKey)) {
                usedValues.add(cleanKey);
                buffer.replace(matcher.start(), matcher.end(), dictionary.get(cleanKey));
            } else {
                throw new IllegalArgumentException("Bad arguments, please check arguments!");
            }
        }

        Set<String> allKeys = dictionary.keySet();
        for (String key : allKeys) {
            if (!usedValues.contains(key)) {
                throw new IllegalArgumentException(String.format("You don\'t use this key %s", key));
            }
        }
        return buffer.toString();
    }

    /**
     * Remove from string ${ and }.
     * @param key from template.
     * @return key without dollar and brackets.
     */
    private String getCleanKey(String key) {
        return key.substring(2, key.length() - 1);

    }

}
