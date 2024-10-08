package model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 *
 * Unit test for parser.
 */
class ParserTest {

    /**
     * Test case number one.
     */
    @Test
    void whenTryParseAddingOrderOperationShouldCheckThatMethodParseReturnCorrectOrder() {
        String addOrder = "<AddOrder book=\"book-2\" operation=\"BUY\" price=\"100.20\" volume=\"20\" orderId=\"184\" />";
        Parser parser = new Parser();
        Order expected = new Order("book-2", Order.Type.BUY, 100.20f, 20, 184);
        Order actual = parser.parse(addOrder, true);
        assertThat(actual, is(expected));
    }

    /**
     * Test case number two.
     */
    @Test
    void whenTryParseDeleteOrderOperationShouldCheckThatMethodParseReturnCorrectOrder() {
        String deleteOrder = "<DeleteOrder book=\"book-2\" orderId=\"49\" />";
        Parser parser = new Parser();
        Order expected = new Order("book-2", Order.Type.BUY, 0f, 0, 49);
        Order actual = parser.parse(deleteOrder, false);
        assertThat(actual, is(expected));
    }
}