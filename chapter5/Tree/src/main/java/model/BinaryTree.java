package model;

import java.util.Comparator;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.09.2016
 */
public class BinaryTree<T> {

    /**
     * For more readable code.
     */
    private static final int RIGHT_BRANCH = 1;

    /**
     * For more readable code.
     */
    private static final int LEFT_BRANCH = 0;

    /**
     * Root of tree.
     */
    private Node<T> root;

    /**
     * For correct moving elements across tree.
     */
    private Comparator<Node<T>> comparator;

    /**
     * Pointer for inserting new node.
     */
    private Node<T> currentNode;


    /**
     * Create a new binary tree.
     * @param data object which hold root.
     * @param comparator method which describe how to compare two node.
     */
    public BinaryTree(T data, Comparator<Node<T>> comparator) {
        this.root = new Node<>(data);
        this.comparator = comparator;
        this.currentNode = this.root;
    }

    /**
     * Add child to the tree.
     * @param data object which hold node.
     */
    public void addChild(T data) {
        Node<T> newNode = new Node<>(data);
        int branch = this.comparator.compare(newNode, this.root) <= 0 ? LEFT_BRANCH : RIGHT_BRANCH;
        currentNode = this.updateCurrentNode(branch);
        addChildToBranch(newNode, branch);
    }

    /**
     * Return children of given node.
     * @param node from it will call get child method.
     * @return children from given node.
     */
    public List<Node<T>> getChildOf(Node<T> node) {
        return node.getChildren();
    }

    /**
     * Return root of tree.
     * @return root of tree.
     */
    public Node<T> getRoot() {
        return this.root;
    }

    /**
     * Update pointer for correct inserting new element.
     * @param branch to this will add new object.
     * @return updated pointer.
     */
    private Node<T> updateCurrentNode(int branch) {
      Node<T> result = null;
      if(this.root.getChildren().size() <= 1) {
          result = this.root;
      } else if(this.root.getChildren().size() == 2) {
          Node<T> current = this.root;
          while(current.getChildren().size() == 2) {
              current = current.getChildren().get(branch);
          }
          result = current;
      }
      return result;
    }

    /**
     * Check that given element contains at this tree.
     * @param element for checking.
     * @return true if element contains at this tree.
     */
    public boolean contains(Node<T> element) {
        return this.findElementAtBranch(element) != null;
    }

    /**
     * Add child to given branch.
     * @param node object which will add.
     * @param idBranch number of branch.
     */
    private void addChildToBranch(Node<T> node, int idBranch) {
        if(currentNode.getChildren().size() == 0) {
            currentNode.getChildren().add(node);
        } else {
            currentNode.getChildren().add(idBranch, node);
        }
    }

    /**
     * Try to find element at the branch.
     * @param element for searching.
     * @return true if object was find, otherwise false.
     */
    private Node<T> findElementAtBranch(Node<T> element) {
        Node<T> result = null;
        if(this.root.equals(element) && root.getChildren().size() == 0) {
            result = root;
        } else {
           int correct = this.root.getChildren().size() == 1 ? 0 : 1;
           Node<T> current = this.root.getChildren().get(correct);
           while(current.getChildren().size() != 0) {
               for(Node<T> elem : current.getChildren()) {
                   if(elem.equals(element)) {
                       result = elem;
                   }
               }
               if(current.getChildren().size() == 0) {
                   break;
               } else if(current.getChildren().size() == 1) {
                   current = current.getChildren().get(LEFT_BRANCH);
               } else if(current.getChildren().size() == 2){
                   current = current.getChildren().get(RIGHT_BRANCH);
               }
           }
        }

        return result;
    }
}
