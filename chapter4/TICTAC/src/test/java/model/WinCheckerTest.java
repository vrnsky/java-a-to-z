package model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for WinChecker.java
 */
public class WinCheckerTest {


    /**
     * When try create a win check should check that is correct.
     */
    @Test
    public void whenTryCreateWinCheckShouldCheckThatIsNotNull() {

        //Assign block
        WinChecker checker = new WinChecker();

        //Action block
        boolean actual = checker != null;

        //Assign block
        assertThat(actual, is(true));
    }

    /**
     * When some player win by vertical should check that win checker is find it.
     */
    @Test
    public void whenSomePlayerWinShouldCheckThatWinnerReturnTrue() {

        //Assign block
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        //Action block
        board.performStep(player, 0, 0);
        board.performStep(player, 1, 1);
        board.performStep(player, 2, 2);
        System.out.println(checker.isWinner(player, board));
        boolean actual = checker.isWinner(player, board);

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When some player win by horizontal should check that win checker return true.
     */
    @Test
    public void whenSomePlayerWinByHorizontalShouldCheckThatWinCheckerReturnTrue() {

        //Assign block
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        //Action block
        board.performStep(player, 0, 0);
        board.performStep(player, 0, 1);
        board.performStep(player, 0, 2);
        boolean actual = checker.isWinner(player, board);

        //Assign block
        assertThat(actual, is(true));
    }

    /**
     * When some player win by diagonal should check that checker return true.
     */
    @Test
    public void whenSomePlayerWinByDiagonalShouldCheckThatCheckerReturnTrue() {

        //Assign block
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        //Action block
        board.performStep(player, 0,0);
        board.performStep(player, 1,1);
        board.performStep(player, 2,2);
        boolean actual = checker.isWinner(player, board);

        //Assert block
        assertThat(actual, is(true));
    }
}
