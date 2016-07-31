package model;
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
     * Pointer for moving across data array.
     */
    private int position = 0;

    /**
     * Generate string by insert values from data array at the ${template}
     * @param template string with templates.
     * @param data array of object which will insert.
     * @return string with new data.
     */
    @Override
    public String generate(String template, Object[] data) {
        if(template == null) {
            throw new IllegalArgumentException("Please give correct string");
        }
        StringBuffer builder = new StringBuffer(template);
        Matcher matcher = PATTERN.matcher(builder);
        if(data == null) {
            throw new IllegalArgumentException("Please, give correct array of object.");
        }
        if(!checkMatches(template, data.length)) throw new IllegalArgumentException("More or less key(s), please!");
        while(matcher.find()) {
            builder.replace(matcher.start(), matcher.end(), data[position++].toString());
            matcher.reset();
        }
        return builder.toString();
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

}
