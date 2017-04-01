package collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Stack.java.
 */
public class StackTest {

    /**
     * When try push to stack value and poll, should check that stack return values.
     */
    @Test
    public void whenTryPushToStackAndPollShouldCheckThatStackReturnLastAddedValue() {

        //Assign block
        Stack<String> stack = new Stack<>();
        String expected = "three";

        //Action block
        stack.push("one");
        stack.push("two");
        stack.push("three");

        //Assert block
        assertThat(stack.poll(), is(expected));
    }

    /**
     * When try peek value from stack should check that element was not removing.
     */
    @Test
    public void whenTryPeekValueFromStackShouldCheckThatElementNotRemoving() {

        //Assign block
        Stack<String> stack = new Stack<>();
        String expected = "three";

        //Action block
        stack.push(expected);
        stack.peek();

        //Assert block
        assertThat(stack.poll(), is(expected));
    }

    /**
     * When try check that stack is empty should check that method return true.
     */
    @Test
    public void whenTryCheckThatStackIsEmptyShouldCheckThatMethodReturnTrue() {

        //Assign block
        Stack<String> stack = new Stack<>();

        //Assert block
        assertThat(stack.isEmpty(), is(true));
    }


}
