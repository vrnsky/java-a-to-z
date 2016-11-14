package chess;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Queen.java.
 * It test all functionality of queen chess figure.
 */
public class QueenTest {

    /**
     * Instance of testing class.
     */
    private Queen queen;

    /**
     * Init all need variable, it placed there for reduce code in tests.
     */
    @Before
    public void setUp() {
        this.queen = new Queen();
    }

    /**
     * When try create a new queen should check that constructor work correct.
     */
    @Test
    public void whenTryCreateANewQueenShouldCheckThanItIsNotNull() {
        boolean actual = queen != null;
        assertThat(actual, is(true));
    }

    /**
     * When try attach queen to the board should check that queen was attached to the board.
     */
    @Test
    public void whenTryAddQueenToTheBoardShouldCheckThanBoardSaveIt() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;

        board.addFigure(this.queen, startX, startY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move queen in right horizontal direction should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInRightDirectionShouldMoveQueenIfCellInThePathIsEmpty() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "Q"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;
        final int finishX = 0;
        final int finishY = 7;

        board.addFigure(this.queen, startX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try mvoe queen in left horizontal direction should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInLeftDirectionShouldMoveQueenIfCellsInThePathIsEmpty() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "Q", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 7;
        final int finishX = 0;
        final int finishY = 2;

        board.addFigure(this.queen, startX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move queen by diagonal should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInDiagonalShouldMoveQueenIfInThePathCellsAreEmpty() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "Q"}
        };
        final int startX = 0;
        final int startY = 0;
        final int finishX = 7;
        final int finishY = 7;

        board.addFigure(this.queen, startX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move queen in other direction by diagonal should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInOtherDiagonalShouldMoveQueenIfInThePathCellsAreEmpty() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 7;
        final int startY = 7;
        final int finishX = 0;
        final int finshY = 0;

        board.addFigure(this.queen, startX, startY);
        board.performMove(startX, startY, finishX, finshY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move queen to other position but position is busy should leave figure at the current position.
     */
    @Test
    public void whenTryMoveQueenToTheOtherPositionInVerticalDirButInThePathFigureShouldLeaveQueenAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},
                {"H", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;
        final int finishX = 1;
        final int finishY = 0;

        board.addFigure(this.queen, startX, startY);
        board.addFigure(new Horse(), finishX, finishY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When queen try skip figure shoul leave figure at the current place.
     */
    @Test
    public void whenQueenTrySkipFigureShouldLeaveQueenAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;
        final int pawnX = 3;
        final int pawnY = 0;
        final int finishX = 7;
        final int finishY = 0;

        board.addFigure(this.queen, startX, startY);
        board.addFigure(new Pawn(), pawnX, pawnY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try get queen string view should check that is acronym for queen chess figure.
     */
    @Test
    public void whenGetQueenStringViewShouldGetAcronym() {
        String expected = "Q";
        String actual = queen.toString();
        assertThat(actual, is(expected));
    }

}
