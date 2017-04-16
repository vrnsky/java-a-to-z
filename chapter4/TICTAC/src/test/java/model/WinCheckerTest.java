package model;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for WinChecker.java.
 */
public class WinCheckerTest {


    /**
     * When try create a win check should check that is correct.
     */
    @Test
    public void whenTryCreateWinCheckShouldCheckThatIsNotNull() {
        WinChecker checker = new WinChecker();
        boolean actual = checker != null;
        assertThat(actual, is(true));
    }

    /**
     * When some player win by vertical should check that win checker is find it.
     */
    @Test
    public void whenSomePlayerWinShouldCheckThatWinnerReturnTrue() {
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        board.performStep(player, 0, 0);
        board.performStep(player, 1, 1);
        board.performStep(player, 2, 2);
        System.out.println(checker.isWinner(player, board));
        boolean actual = checker.isWinner(player, board);

        assertThat(actual, is(true));
    }

    /**
     * When some player win by horizontal should check that win checker return true.
     */
    @Test
    public void whenSomePlayerWinByHorizontalShouldCheckThatWinCheckerReturnTrue() {
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        board.performStep(player, 0, 0);
        board.performStep(player, 0, 1);
        board.performStep(player, 0, 2);
        boolean actual = checker.isWinner(player, board);

        assertThat(actual, is(true));
    }

    /**
     * When some player win by diagonal should check that checker return true.
     */
    @Test
    public void whenSomePlayerWinByDiagonalShouldCheckThatCheckerReturnTrue() {
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        board.performStep(player, 0, 0);
        board.performStep(player, 1, 1);
        board.performStep(player, 2, 2);
        boolean actual = checker.isWinner(player, board);

        assertThat(actual, is(true));
    }

    /**
     * When some player win by other diagonal should check that checker return true.
     */
    @Test
    public void whenSomePlayerWinByOtherDiagonalShouldCheckThatCheckerReturnTrue() {
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        board.performStep(player, 0, 2);
        board.performStep(player, 1, 1);
        board.performStep(player, 2, 0);
        boolean actual = checker.isWinner(player, board);

        assertEquals(true, actual);
    }
}
