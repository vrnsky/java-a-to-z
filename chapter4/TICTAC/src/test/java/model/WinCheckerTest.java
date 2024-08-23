package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for WinChecker.java.
 */
class WinCheckerTest {


    /**
     * When try creating a win check should check that is correct.
     */
    @Test
    void whenTryCreateWinCheckShouldCheckThatIsNotNull() {
        WinChecker checker = new WinChecker();
        Assertions.assertNotNull(checker);
    }

    /**
     * When some player win by vertical should check that win checker is find it.
     */
    @Test
    void whenSomePlayerWinShouldCheckThatWinnerReturnTrue() {
        this.executeTest(new int[]{0, 0, 1, 1, 2, 2}, true);
    }

    /**
     * When some player win by horizontal should check that win checker return true.
     */
    @Test
    void whenSomePlayerWinByHorizontalShouldCheckThatWinCheckerReturnTrue() {
        this.executeTest(new int[]{0, 0, 0, 1, 0, 2}, true);
    }

    /**
     * When some player win by diagonal should check that checker return true.
     */
    @Test
    void whenSomePlayerWinByDiagonalShouldCheckThatCheckerReturnTrue() {
        this.executeTest(new int[]{0, 0, 1, 1, 2, 2}, true);
    }

    /**
     * When some player win by other diagonal should check that checker return true.
     */
    @Test
    void whenSomePlayerWinByOtherDiagonalShouldCheckThatCheckerReturnTrue() {
        this.executeTest(new int[]{0, 2, 1, 1, 2, 0}, true);
    }

    /**
     * To avoid duplication common code placed at this place.
     * @param points array of integer - it is points for step.
     * @param expected result of win checker inspection.
     */
    private void executeTest(int[] points, boolean expected) {
        WinChecker checker = new WinChecker();
        Board board = new Board();
        Player player = new Human("X");

        board.performStep(player, points[0], points[1]);
        board.performStep(player, points[2], points[3]);
        board.performStep(player, points[4], points[5]);
        boolean actual = checker.isWinner(player, board);
        assertThat(actual, is(expected));

    }
}
