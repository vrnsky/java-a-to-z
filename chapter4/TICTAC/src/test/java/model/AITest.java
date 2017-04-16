package model;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for AI.java.
 */
public class AITest {

    /**
     * When try create a AI should check that is not null.
     */
    @Test
    public void whenTryCreateAIShouldCheckThatIsNotNull() {
        Player computer = new AI("o");
        boolean actual = computer != null;
        assertThat(actual, is(true));
    }

    /**
     * When try get sign of ai should check that is correct sign.
     */
    @Test
    public void whenTryGetSignOfAIShouldCheckThatIsCorrectSign() {
        Player computer = new AI("O");
        String expected = "O";

        String actual = computer.getSign();

        assertThat(actual, is(expected));
    }

    /**
     * When AI try to make good step should check that step is performed.
     */
    @Test
    public void whenAITryToMakeGoodStepShouldCheckThatStepIsPerformed() {
        Board board = new Board();
        Player player = new AI("X");
        boolean actual = board.performStep(player, board.getWidth() - 1, board.getHeight() -  1);
        assertThat(actual, is(true));
    }

}
