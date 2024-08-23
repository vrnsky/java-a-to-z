package model;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 08.09.2016
 *
 * Unit test for binary tree.
 */
class BinaryTreeTest {


    /**
     * Comparator.
     */
    private static final Comparator<Node<String>> COMPARATOR = (o1, o2) -> {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Bad args");
        }
        return o1.getData().compareTo(o2.getData());
    };

    /**
     * When try adding element to the left and right should check that binary tree accept it both.
     */
    @Test
    void whenTryAddElementToTheLeftAndRightBranchShouldCheckThatBinaryTreeAcceptIt() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        tree.addChild("Abc");
        tree.addChild("Zyxel");
        List<Node<String>> childs = tree.getChildOf(tree.getRoot());
        assertThat(childs.get(0).getData(), is("Abc"));
        assertThat(childs.get(1).getData(), is("Zyxel"));
    }

    /**
     * When try adding element to the left branch should check that tree was add node.
     */
    @Test
    void whenTryAddElementToTheLeftBranchAtTheSecondLevelOfTreeShouldCheckThatTreeWasAdded() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        tree.addChild("Abc");
        tree.addChild("Zyxel");
        tree.addChild("Biglion");
        List<Node<String>> rootChilds = tree.getChildOf(tree.getRoot());
        List<Node<String>> grandson = tree.getChildOf(rootChilds.get(0));
        assertThat(grandson.get(0).getData(), is("Biglion"));
    }

    /**
     * When try adding element to the right branch should check that element was added.
     */
    @Test
    void whenTryAddElementToTheRightBranchShouldCheckThatElementWasAddedToCorrectPosition() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        tree.addChild("Abc");
        tree.addChild("Zyxel");
        tree.addChild("ZARA");
        List<Node<String>> rootChilds = tree.getChildOf(tree.getRoot());
        List<Node<String>> grandson = tree.getChildOf(rootChilds.get(1));
        assertThat(grandson.get(0).getData(), is("ZARA"));
    }

    /**
     * When try check that element exist at the tree should check that contains method return true.
     */
    @Test
    public void whenTryCheckThatSomeElementContainsAtTheTreeShouldCheckThatMethodContainsWorksCorrect() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        Node<String> root = tree.getRoot();
        assertThat(tree.contains(root), is(true));
    }

    /**
     * When element is deep should check that contains method return true.
     */
    @Test
    public void whenTryCheckThatSomeElementContainsAtTheDeepOfTreeShouldCheckThatMethodContainsWorksCorrect() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        tree.addChild("Abc");
        tree.addChild("Zyxel");
        tree.addChild("World");
        List<Node<String>> rootChild = tree.getChildOf(tree.getRoot());
        List<Node<String>> zyxel = tree.getChildOf(rootChild.get(1));
        Node<String> child = zyxel.get(0);
        tree.contains(child);
    }

    /**
     * When try check that some element not exist at the tree should check that method contains return false.
     */
    @Test
    public void whenTryCheckThatSomeElementNotExistShouldCheckThatMethodContainsReturnFalse() {
        BinaryTree<String> tree = new BinaryTree<>("Root", COMPARATOR);
        tree.addChild("Value");
        assertThat(tree.contains(new Node("value")), is(false));
    }
}
