package model;


import org.junit.Test;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 */
public class ClientTest {

    /**
     * When try to create a client with wrong data should check that app throw exception.
     */
    @Test(expected = IllegalStateException.class)
    public void whenTryClientWithEqualsTimeInAndTimeOutShouldCheckThrowException() {
        Client client = new Client(2L, 1L);
    }
}