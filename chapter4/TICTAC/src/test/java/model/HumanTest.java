package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Human.java.
 */
class HumanTest {

    /**
     * When create a human should check that is not null.
     */
    @Test
    void whenTryCreateHumanShouldCheckThatIsNotNull() {

        //Assign block
        Player human = new Human("x");
        Assertions.assertNotNull(human);
    }

    /**
     * When try getting sign of human should check that is correct sign.
     */
    @Test
    void whenTryGetSignOfHumanShouldCheckThatIsCorrectSign() {
        Player human = new Human("x");
        String expected = "x";

        String actual = human.getSign();

        assertThat(actual, is(expected));
    }

    /**
     * When human try making step on the empty cell should check that board accept it.
     */
    @Test
    void whenHumanTryMakeStepOnTheEmptyCellShouldCheckThatBoardAcceptIt() {
        Player human = new Human("X");
        Board board = new Board();
        String[][] expected = {
                {"X", "_", "_"},
                {"_", "_", "_"},
                {"_", "_", "_"}
        };

        human.makeStep(board, 0, 0);
        String[][] actual = board.showBoard();

        assertThat(actual, is(expected));
    }
}
