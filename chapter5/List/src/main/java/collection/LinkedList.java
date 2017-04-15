package collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Implementation of linked list.
 *
 * @param <T> specify which element may store list.
 */
public class LinkedList<T> implements SimpleContainer<T> {

    /**
     * Head of list.
     */
    private Node<T> first;

    /**
     * Tail of list.
     */
    private Node<T> last;

    /**
     * Count of elements in list.
     */
    private int size = 0;

    /**
     * Default constructor.
     */
    public LinkedList() {
    }


    /**
     * Moving across list and find element at the given position.
     * @param position count of reference which method will move to wish element.
     * @return value which contains at the list at given position.
     */
    @Override
    public T get(int position) {
        return node(position).elem;
    }

    /**
     * Add to the end of list new data.
     *
     * @param value it is will be add to the list.
     * @return true.
     */
    @Override
    public boolean add(T value) {
        this.linkLast(value);
        return true;
    }

    /**
     * Remove element from the list.
     * @param position from this position element will remove.
     * @return removed element.
     */
    @Override
    public T remove(int position) {
        Node<T> node = this.node(position);
        T copy = node.elem;
        this.unlink(node);
        return copy;
    }

    /**
     * Find node at the given index.
     * @param index position of searching node.
     * @return node object which position equals given index.
     */
    private Node<T> node(int index) {
        if (!this.validate(index)) {
            throw new IllegalArgumentException("Bad args");
        }

        Node<T> search = null;
        if (index < this.size / 2) {
            search = first;
            for (int i = 0; i < index; i++) {
                search = first.next;
            }
        } else {
            search = last;
            for (int i = size - 1; i > index; i--) {
                search = search.prev;
            }
        }
        return search;
    }


    /**
     * Check that given elements contains at the list.
     * @param o object for checking.
     * @return true if object contains at the list.
     */
    @Override
    public boolean contains(Object o) {
        T obj = (T) o;
        Node<T> currentNode = first;
        boolean contains = false;
        for (int index = 0; index < this.size; index++) {
            contains = currentNode.elem.equals(obj);
            currentNode = currentNode.next;
        }
        return contains;
    }

    /**
     * Return count of elements in list.
     * @return count of elements.
     */
    public int size() {
        return this.size;
    }

    /**
     * Reverse list.
     */
    public void reverse() {
        Node temp = first;
        first = last;
        last = temp;

        Node current = first;

        while (current != null) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }
    }

    /**
     * Return instance of inner class Itr.
     * @return instance of Itr class.
     */
    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    /**
     * Validate position for prevent index out.
     * @param position it is given value from client.
     * @return true if position correct, otherwise false.
     */
    private boolean validate(int position) {
        return ((position >= 0) && (position < size));
    }

    /**
     * Removing link for given node.
     * @param value node which will be unlinked.
     * @return value from removed link.
     */
    private T unlink(Node<T> value) {
        T elem = value.elem;
        T copy = elem;
        Node<T> next = value.next;
        Node<T> prev = value.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            value.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            value.next = null;
        }

        value.elem = null;
        this.size--;
        return copy;
    }

    /**
     * Link given element as last element at the list.
     * @param t value which will add.
     */
    private void linkLast(T t) {
        Node<T> l = last;
        Node<T> newNode = new Node(l, t, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        this.size++;
    }


    /**
     * Iterator. It allow move across all element in the list.
     */
    private class Itr implements Iterator<T> {

        /**
         * Pointer to the current node.
         */
        private Node<T> currentNode = first;

        /**
         * Check that in list have yet elements.
         * @return true if at the list have yet elements.
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Return value from list. And move current pointer to the next element.
         * @return value from list.
         */
        @Override
        public T next() {
            T value = currentNode.elem;
            currentNode = currentNode.next;
            return value;
        }
    }

    /**
     * Magic.
     * @return some magic.
     */
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    /**
     * Execute some action with all element.
     * @param action for each element.
     */
    @Override
    public void forEach(Consumer<? super T> action) {

    }


    /**
     * It is node of list.
     *
     * @param <T> specify which type may store node.
     */
    private class Node<T> {

        /**
         * Pointer to previous element.
         */
        Node<T> prev;

        /**
         * Pointer to next element.
         */
        Node<T> next;

        /**
         * Data.
         */
        T elem;

        /**
         * Create a new node of list.
         * @param prev pointer to the previous element.
         * @param elem data.
         * @param next pointer to the next element.
         */
        Node(Node<T> prev, T elem, Node<T> next) {
            this.prev = prev;
            this.elem = elem;
            this.next = next;
        }

    }
}
