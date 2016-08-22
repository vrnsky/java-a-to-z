package collection;

/**
 * Implementation of queue. Works next schema: first in, first out.
 */
public class Queue<T> extends Stack<T> {

    /**
     * Add value to the queue.
     * @param value it is will be add to the list.
     * @return always true.
     */
    @Override
    public boolean add(T value) {
        return super.add(value);
    }

    /**
     * Return first element at the queue and remove it.
     * @return removed element.
     */
    @Override
    public T poll() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return super.remove(0);
    }

    /**
     * Return first element at the queue without removing element.
     * @return first element at the queue.
     */
    public T peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return super.get(0);
    }

}
