package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Board.java.
 */
public class BoardTest {

    /**
     * When board is only created should check that all cells are empty.
     */
    @Test
    public void whenCreateBoardShouldCheckThatBoardIsEmpty() {

        //Assign block
        Board board = new Board();
        String[][] expected = {
                {"_", "_", "_"},
                {"_", "_", "_"},
                {"_", "_", "_"}
        };

        //Action block
        String[][] actual = board.showBoard();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When someone try make step on the empty cell should check that board accept it.
     */
    @Test
    public void whenSomeoneTryMakeStepOnTheEmptyCellShouldCheckThatBoardAcceptIt() {

        //Assign block
        Board board = new Board();
        Player human = new Human("X");
        String[][] expected = {
                {"_", "X", "_"},
                {"_", "_", "_"},
                {"_", "_", "_"}
        };

        //Action block
        board.performStep(human, 0, 1);
        String[][] actual = board.showBoard();

        //Assert block
        assertThat(actual, is((expected)));
    }

    /**
     * When someone try make on the busy cell should check that step is not perform.
     */
    @Test
    public void whenSomeoneTryMakeStepOnTheBusyCellShouldCheckThatStepIsNotPerform() {

        //Assign block
        Board board = new Board();
        Player player = new Human("X");
        String[][] expected = {
                {"_", "_", "_"},
                {"_", "_", "_"},
                {"_", "X", "_"}
        };

        //Action block
        board.performStep(player, 2, 1);
        String[][] actual = board.showBoard();

        //Assert
        assertThat(actual, is(expected));
    }
}
