package parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

/**
 * @author evrnsky
 * @version 0.1
 * @since 14.01.2017
 *
 * Date parser which parse date in string form.
 */
public class DateParser {

    /**
     * Map of months.
     */
    private static final Map<String, Integer> MONTHS_NUMBERS = new HashMap<>();

    /**
     * Formatter for dates.
     */
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd MM yy");

    /**
     * Default constructor.
     */
    public DateParser() {
        fillMonthsNumberMap();
    }


    /**
     * Parse string date and return time in miliseconds.
     * @param date string view of date.
     * @return time in miliseconds.
     * @throws ParseException if it is not parseable date.
     */
    public long parseDate(String date) throws ParseException {
        long time = 1L;
        if ("сегодня".contains(date)) {
            time = new Date().getTime();
        } else if ("вчера".contains(date)) {
            time = new Date().getTime() - 3600 * 24;
        } else {
            time = FORMATTER.parse(getOnlyNumbersDate(date)).getTime();
        }
        return time;
    }


    /**
     * Fill months map.
     */
    private void fillMonthsNumberMap() {
        MONTHS_NUMBERS.put("янв", 1);
        MONTHS_NUMBERS.put("фев", 2);
        MONTHS_NUMBERS.put("мар", 3);
        MONTHS_NUMBERS.put("апр", 4);
        MONTHS_NUMBERS.put("май", 5);
        MONTHS_NUMBERS.put("июн", 6);
        MONTHS_NUMBERS.put("июл", 7);
        MONTHS_NUMBERS.put("авг", 8);
        MONTHS_NUMBERS.put("сен", 9);
        MONTHS_NUMBERS.put("окт", 10);
        MONTHS_NUMBERS.put("ноя", 11);
        MONTHS_NUMBERS.put("дек", 12);
    }

    /**
     * Return number code of months.
     * @param literal three letter of month.
     * @return number code of month.
     */
    private int getMonthNumber(String literal) {
        return MONTHS_NUMBERS.get(literal);
    }

    /**
     * Return string only with numbers.
     * @param date for example 28 Oct 12
     * @return date without alphabetical letters.
     */
    private String getOnlyNumbersDate(String date) {
        String[] numbers = date.split(" ");
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("%s ", numbers[0]));
        buffer.append(String.format("%s ", getMonthNumber(numbers[1])));
        buffer.append(numbers[2]);
        return buffer.toString();
    }

}
