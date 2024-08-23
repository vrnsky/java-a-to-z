package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 */
class ClientTest {

    /**
     * When try to create a client with wrong data should check that app throw exception.
     */
    @Test
    void whenTryClientWithEqualsTimeInAndTimeOutShouldCheckThrowException() {
        Assertions.assertThrows(IllegalStateException.class, () -> new Client(2L, 1L));
    }
}