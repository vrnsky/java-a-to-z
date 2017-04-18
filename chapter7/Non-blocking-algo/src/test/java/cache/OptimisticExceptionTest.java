package cache;


import org.junit.Test;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This unit test for OptimisticException.java
 */
public class OptimisticExceptionTest {

    /**
     * When try throw exception should check that exception throw normally.
     * @throws Exception if some error happened.
     */
    @Test(expected = OptimisticException.class)
    public void whenTryThrowExceptionShouldCheckThatExceptionThrow() throws Exception {
        throw new OptimisticException("args");
    }
}