package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of tree nodes. It may accept child.
 * @param <T> determine type with which tree will work.
 */
public class Node<T> {

    /**
     * At this place hold all children of tree node.
     */
    private List<Node<T>> children = new ArrayList<>();

    /**
     * Data holding at the current node.
     */
    private T data;

    /**
     * All elements by default are root.
     */
    private Node<T> parent = null;

    /**
     * Create a new node with given data.
     * @param data which hold at the node.
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Add child to given parent.
     * @param parent instance of class, to it will add child.
     * @param child instance of node which will added to the parent.
     */
    public void addChild(Node<T> parent, Node<T> child) {
        parent.addChild(child);
        child.parent = parent;
    }

    /**
     * If node not have parent is seems like root element of tree.
     * @return true if is root element otherwise fale.
     */
    public boolean isRoot() {
        return this.parent == null;
    }

    /**
     * Node which have parent, but not have child it is leaf.
     * @return true if this node is leaf, otherwise false.
     */
    public boolean isLeaf() {
        boolean isLeaf;
        if(this.children.size() == 0 && !this.isRoot()) {
            isLeaf = true;
        } else {
            isLeaf = false;
        }
        return isLeaf;
    }

    /**
     * Remove parent. After it operation element became root node.
     */
    public void removeParent() {
        this.parent = null;
    }

    /**
     * Return parent of current node.
     * @return parent of current node.
     */
    public Node<T> getParent() {
        return this.parent;
    }

    /**
     * Return children of current node.
     * @return children of current node.
     */
    public List<Node<T>> getChildren() {
        return this.children;
    }

    /**
     * Get data from current node.
     * @return data object holding at this node.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Add child to this node.
     * @param child instance of this class.
     */
    private void addChild(Node<T> child) {
        this.children.add(child);
    }

}
