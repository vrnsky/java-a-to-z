package collection;

import java.util.EmptyStackException;

/**
 * Implementation of stack. Works next schema: last in, first out.
 */
public class Stack<T> extends LinkedList<T> {

    /**
     * Add element to the end of the list.
     * @param value
     */
    public void push(T value) {
        super.add(value);
    }

    /**
     * Return last element at the stack.
     * @return last element at the stack.
     */
    public T poll() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return super.remove(super.size()-1);
    }

    /**
     * Return last element at the stack, without removing.
     * @return last element.
     */
    public T peek() {
        if(isEmpty())  {
            throw new EmptyStackException();
        }
        return super.get(super.size()-1);
    }

    /**
     * Checking that is stack is empty.
     * @return true if stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return super.size() == 0;
    }

}
