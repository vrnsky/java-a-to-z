package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for AI.java.
 */
class AITest {

    /**
     * When try creating an AI should check that is not null.
     */
    @Test
    void whenTryCreateAIShouldCheckThatIsNotNull() {
        Player computer = new AI("o");
        Assertions.assertNotNull(computer);
    }

    /**
     * When try getting sign of AI should check that is correct sign.
     */
    @Test
    void whenTryGetSignOfAIShouldCheckThatIsCorrectSign() {
        Player computer = new AI("O");
        String expected = "O";

        String actual = computer.getSign();

        assertThat(actual, is(expected));
    }

    /**
     * When try making step should check that all is ok.
     */
    @Test
    void whenTryToMakeStepShouldCheckThatStepPerformed() {
        Player computer = new AI("O");
        Board board = new Board();
        assertThat(board.performStep(computer, 0, 0), is(true));
    }

}
