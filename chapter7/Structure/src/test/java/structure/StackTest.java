package structure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 17.04.2017
 *
 * unit test for thread safe stack.
 */
public class StackTest {

    /**
     * When try push element to the stack should check that element was added.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryPushElementToTheStackShouldCheckThatElementAdded() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("yegor");
        assertThat(stack.pop(), is("yegor"));
    }
}