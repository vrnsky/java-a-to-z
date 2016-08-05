package model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Human.java.
 */
public class HumanTest {

    /**
     * When create a human should check that is not null.
     */
    @Test
    public void whenTryCreateHumanShouldCheckThatIsNotNull() {

        //Assign block
        Player human = new Human("x");

        //Action block
        boolean actual = human != null;

        assertThat(actual, is(true));
    }

    /**
     * When try get sign of human should check that is correct sign.
     */
    @Test
    public void whenTryGetSignOfHumanShouldCheckThatIsCorrectSign() {

        //Assign block
        Player human = new Human("x");
        String expected = "x";

        //Action block
        String actual = human.getSign();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When human try make step on the empty cell should check that board accept it.
     */
    @Test
    public void whenHumanTryMakeStepOnTheEmptyCellShouldCheckThatBoardAcceptIt() {

        //Assign block
        Player human = new Human("X");
        Board board = new Board();
        String[][] expected = {
                {"X","_","_"},
                {"_","_","_"},
                {"_","_","_"}
        };

        //Action block
        human.makeStep(board, 0,0);
        String[][] actual = board.showBoard();

        //Assert block
        assertThat(actual, is(expected));
    }
}
