package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of tree nodes. It may accept child.
 *
 * @param <T> determine type with which tree will work.
 */
public class Node<T> {

    /**
     * By default node of tree may have 100 child.
     */
    private static final int DEFAULT_COUNT_CHILD = 100;

    /**
     * At this place hold all children of tree node.
     */
    private List<Node<T>> children = new ArrayList<>(DEFAULT_COUNT_CHILD);

    /**
     * Data holding at the current node.
     */
    private T data;

    /**
     * All elements by default are root.
     */
    private Node<T> parent = null;

    /**
     * For correct moving across tree.
     */
    private Node<T> current = this;

    /**
     * Hold state about balance in tree.
     */
    private boolean balanced = false;


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
     * @param child  instance of node which will added to the parent.
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
        if (this.children.size() == 0 && !this.isRoot()) {
            isLeaf = true;
        } else {
            isLeaf = false;
        }
        return isLeaf;
    }

    /**
     * Return true if object contains at this tree.
     * @param object for searching.
     * @return true if object contains at this tree, otherwise false.
     */
    public boolean contains(Node<T> object) {
        return this.haveGivenNode(object);
    }

    /**
     * Check that current tree is balanced.
     * @return true if tree is balanced, otherwise false.
     */
    public boolean isBalanced() {
        if (this.isRoot() && this.children.size() == 0) {
            balanced = true;
        } else {
            balanced = this.checkBalanceTree(this);
        }
        return balanced;
    }


    /**
     * Remove parent. After it operation element became root node.
     */
    public void removeParent() {
        this.parent = null;
    }

    /**
     * Return parent of current node.
     *
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

    /**
     * Move across all tree and find searching element.
     * @param node object which searching.
     * @return true if object find at the tree, otherwise false.
     */
    private boolean haveGivenNode(Node<T> node) {
        boolean have = false;
        if (node.equals(this)) {
            have = true;
        } else {
            while (current.getChildren() != null && current.getChildren().size() != 0) {
                for (Node<T> elem : current.getChildren()) {
                    current = elem;
                    if (node.equals(current)) {
                        have = true;
                    }
                }
            }
        }
        return have;
    }

    /**
     * Checking that tree is balanced. Balanced means that each node hold only two child.
     * @param root of tree.
     * @return true if tree is balanced, otherwise false.
     */
    private boolean checkBalanceTree(Node<T> root) {
        if(root.getChildren().size () == 2 || root.getParent() != null) {
            balanced = true;
            if(root.getChildren() != null) {
                for (Node<T> elem : root.getChildren()) {
                    checkBalanceTree(elem);
                }
            }
        } else {
            balanced = false;
        }
        return balanced;
    }


}

