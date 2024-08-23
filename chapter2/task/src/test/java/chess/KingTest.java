package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Unit test for King.java.
 * Test all opportunity of king chess figure.
 */
class KingTest {

    /**
     * Instance of testing class.
     */
    private King king;


    /**
     * Init all need variable, it placed there for reduce code in test.
     */
    @BeforeEach
    public void setUp() {
        this.king = new King();
    }

    /**
     *  Check that constructor create correct figure object.
     */
    @Test
    void whenCreateAKingShouldCheckThanItIsNotNull() {
        boolean actual = this.king != null;
        assertThat(actual, is(true));
    }

    /**
     * When try attach king to the board should check than board save it.
     */
    @Test
    void whenTryAttachKingToBoardShouldCheckThatBoardSaveIt() {

        //Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move king in correct horizontal direction should check that king was moved.
     */
    @Test
    void whenTryMoveKingInCorrectHorizontalDirectionShouldMoveKing() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "K", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.performMove(0, 0, 0, 1);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move king in correct vertical direction should check that king was moved.
     */
    @Test
    void whenTryMoveKingInCorrectVerticalDirectionShouldMoveKing() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"K", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.performMove(0, 0, 1, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move king in correct diagonal direction should check that king was moved.
     */
    @Test
    void whenTryMoveKingInCorrectDiagonalDirectionShouldMoveKing() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "K", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.performMove(0, 0, 1, 1);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move king to the busy cell should leave king at the current place.
     */
    @Test
    void whenTryMoveKingToTheBusyCellShouldLeaveKingAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "H", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.addFigure(new Horse(), 1, 1);
        board.performMove(0, 0, 1, 1);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move king more than one cell should leave king at the current place.
     */
    @Test
    void whenTryMoveKingBiggerThatOneCellShouldLeaveKingAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.performMove(0, 0, 2, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When king try skip figures should leave king at the current place.
     */
    @Test
    void whenKingTrySkipFigureShouldLeaveKingAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        board.addFigure(this.king, 0, 0);
        board.addFigure(new Pawn(), 1, 0);
        board.performMove(0, 0, 3, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try get string view of king chess figure should check that is acronym.
     */
    @Test
    void whenTryGetStringViewOfKingShouldGetAcronym() {
        String expected = "K";
        String actual = king.toString();
        assertThat(actual, is(expected));
    }


}
