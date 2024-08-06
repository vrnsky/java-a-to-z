package structure;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.04.2017
 *
 * Unit test for thread safe stack.
 */
class StackTest {

    /**
     * When try push element to the stack should check that element was added.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryPushElementToTheStackShouldCheckThatElementAdded() {
        Stack<String> stack = new Stack<>();
        stack.push("yegor");
        assertThat(stack.pop(), is("yegor"));
    }
}