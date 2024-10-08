package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;



/**
 * Unit test for Pawn.java.
 * It test all opportunity of pawn chess figure.
 */
public class PawnTest {

    /**
     * Instance of testing class.
     */
    private Pawn pawn;

    /**
     * Init all need variable at this place, it placed there for reduce code in tests.
     */
    @BeforeEach
    public void setUp() {
        this.pawn = new Pawn();
    }

    /**
     * Check than constructor works correct.
     */
    @Test
    void whenCreateAPawnShouldCheckItIsNotNull() {
        boolean actual = pawn != null;
        assertThat(actual, is(true));
    }

    /**
     * When try attach pawn to board should check that board save it.
     */
    @Test
    void whenTryAttachPawnToTheBoardShouldAddPawnIfCellIsNotBusy() {
        Board board = new Board();
        String[][] expected = new String[][] {
                {"P", "0", "0", "0", "0", "0", "0", "0"},
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

        board.addFigure(this.pawn, startX, startY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move pawn in correct direction should check that pawn was moved.
     */
    @Test
    void whenTryMovePawnInCorrectDirectionShouldMovePawn() {
        Board board = new Board();
        String[][] expected = new String[][] {
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;
        final int finishX = 2;
        final int finishY = 0;

        board.addFigure(this.pawn, startX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move pawn in wrong direction should leave pawn at the current position.
     */
    @Test
    void whenTryMovePawnInWrongDirectionShouldLeavePawnAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][] {
                {"P", "0", "0", "0", "0", "0", "0", "0"},
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
        final int finishY = 2;

        board.addFigure(this.pawn, startX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try move pawn but in the path have figure or figures should leave pawn at the current place.
     */
    @Test
    void whenTryMovePawnButInThePathFigureShouldLeavePawnAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][] {
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 0;
        final int startY = 0;
        final int pawnX = 1;
        final int finishX = 2;
        final int finishY = 0;


        board.addFigure(this.pawn, startX, startY);
        board.addFigure(this.pawn, pawnX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When pawn try skip over figure or figures should leave pawn at the current position.
     */
    @Test
    void whenTryPawnTrySkipOverFiguresShouldLeavePawnAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][] {
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"P", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };
        final int startX = 1;
        final int startY = 0;
        final int pawnX = 2;
        final int finishX = 3;
        final int finishY = 0;

        board.addFigure(this.pawn, startX, startY);
        board.addFigure(this.pawn, pawnX, startY);
        board.performMove(startX, startY, finishX, finishY);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When pawn try over three cell should check that pawn left at the current place.
     */
    @Test
    void whenPawnTryStepOverThreeCellShouldCheckThatPawnLeftAtCurrentPlace() {
        Board board = new Board();
        final int startX = 0;
        final int startY = 0;
        final int finishX = 3;
        final int finishY = 0;
        board.addFigure(this.pawn, startX, startY);
        boolean actual = board.canMove(startX, startY, finishX, finishY);
        assertThat(actual, is(false));
    }

    /**
     * When try get string view of pawn figure should check that is acronym for pawn.
     */
	@Test
	void whenTryGetStringViewOfPawnShouldGetStringAcronym() {
		String expected = "P";
		String actual = pawn.toString();
		assertThat(actual, is(expected));
	}
}
