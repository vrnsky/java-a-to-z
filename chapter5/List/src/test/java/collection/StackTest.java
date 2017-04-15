package collection;

import org.junit.Test;

import java.util.EmptyStackException;

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
        Stack<String> stack = new Stack<>();
        String expected = "three";

        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertThat(stack.poll(), is(expected));
    }

    /**
     * When try peek value from stack should check that element was not removing.
     */
    @Test
    public void whenTryPeekValueFromStackShouldCheckThatElementNotRemoving() {
        Stack<String> stack = new Stack<>();
        String expected = "three";

        stack.push(expected);
        stack.peek();

        assertThat(stack.poll(), is(expected));
    }

    /**
     * When try check that stack is empty should check that method return true.
     */
    @Test
    public void whenTryCheckThatStackIsEmptyShouldCheckThatMethodReturnTrue() {
        Stack<String> stack = new Stack<>();
        assertThat(stack.isEmpty(), is(true));
    }

    /**
     * When try check that stack is empty on not empty stack should check that is false.
     */
    @Test
    public void whenTryCheckThatStackIsEmptyOnNotEmptyStackShouldCheckThatFalse() {
        Stack<String> stack = new Stack<>();
        stack.add("Strings");
        assertThat(stack.isEmpty(), is(false));
    }

    /**
     * When try poll data from empty stack should check that app throw exception.
     */
    @Test(expected = EmptyStackException.class)
    public void whenTryPollDataFromEmptyStackShouldCheckThatAppThrowException() {
        Stack<String> stack = new Stack<>();
        stack.poll();
    }

    /**
     * Wjem try peek data from empty stack should check that app throw exception.
     */
    @Test(expected = EmptyStackException.class)
    public void whenTryPeekDataFromEmptyStackShouldCheckThatAppThrowException() {
        Stack<String> stack = new Stack<>();
        stack.peek();
    }

}
