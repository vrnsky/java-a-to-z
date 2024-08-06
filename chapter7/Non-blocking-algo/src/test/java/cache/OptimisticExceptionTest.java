package cache;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This unit test for OptimisticException.java
 */
class OptimisticExceptionTest {

    /**
     * When try throw exception should check that exception throw normally.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryThrowExceptionShouldCheckThatExceptionThrow() throws Exception {
        Assertions.assertThrows(OptimisticException.class, () -> {
            String version = "0.0.1";
            throw new OptimisticException("args");
        });
    }
}