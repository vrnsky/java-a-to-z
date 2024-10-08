package parser;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.01.2017
 *
 * Unit test for date parser.
 */
class DateParserTest {


    /**
     * When parse some fixed date such as in test should check that all is ok.
     * @throws ParseException if not parseable string.
     */
    @Test
    void whenParseSomeDateShouldCheckThatAllIsOk() throws ParseException {
        DateParser parser = new DateParser();
        String date = "5 янв 17";
        long actualTime = parser.parseDate(date);
        long expectedTime = 1483563600000L;
        assertThat(actualTime, is(expectedTime));
    }

}