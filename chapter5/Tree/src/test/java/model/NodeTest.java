package model;

import model.Node;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Unit test for Node.java. Node.java - model of simple tree.
 */
public class NodeTest {

    /**
     * When try create root element should check that method isRoot return true.
     */
    @Test
    public void whenTryRootShouldCheckThatRootIsCorrect() {
        Node<String> treeRoot = new Node<>("Root");
        assertThat(treeRoot.isRoot(), is(true));
    }

    /**
     * When try add child to root should check that child was added.
     */
    @Test
    public void whenTryAddChildToTheRootShouldCheckThatChildWasAdded() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> childNode = new Node<>("Child");
        treeRoot.addChild(treeRoot, childNode);
        List<Node<String>> childRoot = treeRoot.getChildren();
        String actual = childRoot.get(0).getData();
        assertThat(actual, is("Child"));
    }

    /**
     * When try check that some node is leaf should check that method isLeaf return true.
     */
    @Test
    public void whenTryCheckThatSomeNodeIsLeafShouldCheckThatMethodWorksCorrect() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> childNode = new Node<>("Child");
        treeRoot.addChild(treeRoot, childNode);
        assertThat(childNode.isLeaf(), is(true));
    }

    /**
     * When try get data from node should check that data is correct.
     */
    @Test
    public void whenTryGetDataFromNodeShouldCheckThatDataIsCorrect() {
        Node<String> treeRoot = new Node<>("Root");
        assertThat(treeRoot.getData(), is("Root"));
    }

    /**
     * When try remove parent from node should check that parent was removed.
     */
    @Test
    public void whenTryRemoveParentShouldCheckThatParentWasRemoved() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> childNode = new Node<>("Child");
        treeRoot.addChild(treeRoot, childNode);
        childNode.removeParent();
        assertThat(childNode.getParent(), is(nullValue()));
    }

    /**
     * When try find find some object in tree should check that contains method return true.
     */
    @Test
    public void whenTryFindSomeObjectInTreeShouldCheckThatContainsMethodReturnTrue() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> subRoot = new Node<>("Subroot");
        Node<String> suberRoot = new Node<>("Suberooter");
        treeRoot.addChild(treeRoot, subRoot);
        treeRoot.addChild(subRoot, suberRoot);
        assertThat(treeRoot.contains(suberRoot), is(true));
    }

    /**
     * When try check that tree contains only root is balanced
     * should check that method is balanced return true.
     */
    @Test
    public void whenTryCheckThatTreeContainsOnlyRootShouldCheckThatMethodIsBalancedReturnTrue() {
        Node<String> treeRoot = new Node<>("Root");
        assertThat(treeRoot.isBalanced(), is(true));
    }

    /**
     * When try check that wrong tree is balance should check that method is balanced return false.
     */
    @Test
    public void whenTryCheckThatWrongTreeIsBalancedShouldCheckThatMethodIsBalancedReturnFalse() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> subRoot = new Node<>("Subroot");
        treeRoot.addChild(treeRoot, subRoot);
        assertThat(treeRoot.isBalanced(), is(false));
    }

    /**
     * When try check that binary tree is balanced should check that method is balanced return true.
     */
    @Test
    public void whenTryCheckThatBinaryTreeIsBalancedShouldCheckThatMethodIsBalancedReturnTrue() {
        Node<String> treeRoot = new Node<>("Root");
        Node<String> leftBranch = new Node<>("Left");
        Node<String> rightBranch = new Node<>("Right");
        treeRoot.addChild(treeRoot, leftBranch);
        treeRoot.addChild(treeRoot, rightBranch);
        Node<String> leftLeafOne = new Node<>("Left leaf one");
        Node<String> leftLeafTwo = new Node<>("Leaf leaf two");
        leftBranch.addChild(leftBranch, leftLeafOne);
        leftBranch.addChild(leftBranch, leftLeafTwo);
        Node<String> rightLeafOne = new Node<>("Right leaf one");
        Node<String> rightLeafTwo = new Node<>("Right leaf two");
        rightBranch.addChild(rightBranch, rightLeafOne);
        rightBranch.addChild(rightBranch, rightLeafTwo);
        assertThat(treeRoot.isBalanced(), is(true));
    }




}
