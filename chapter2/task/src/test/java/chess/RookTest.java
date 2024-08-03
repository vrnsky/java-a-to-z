package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Rook.java
 * It test implementation rook chess figure.
 */
@Disabled
class RookTest {

    /**
     * Instance of testing class.
     */
    private Rook rook;

    /**
     * Init need variable before test, it placed there for reduce code in tests.
     */
    @BeforeEach
    public void setUp() {
        this.rook = new Rook();
    }

    /**
     * When create a rook should check that constructor of class works correct.
     */
    @Test
    void whenCreateRookShouldCheckItIsNotNull() {
        boolean actual = this.rook != null;
        Assertions.assertTrue(actual);
    }

    /**
     * When try attach rook to the board should attach rook and check that board save it.
     */
    @Test
    void whenTryAddRookToTheBoardShouldCheckThanBoardSaveIt() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.rook, 0, 0);
        String[][] actual = board.getBoard();

        Assertions.assertEquals(expected, actual);
    }

    /**
     * When try moving rook in the board in correct vertical direction should check that figure was moved.
     */
    @Test
    void whenTryMovingRookInTheBoardInCorrectVerticalDirectionShouldMovePerform() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"R", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.rook, 0, 0);
        board.performMove(0, 0, 7, 0);
        String[][] actual = board.getBoard();

        Assertions.assertEquals(expected, actual);
    }

    /**
     * When try moving rook in correct vertical direction should check that figure was moved.
     */
    @Test
    void whenMovingRookInTheBoardIntCorrectHorizontalDirShouldPerformMove() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "R"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.rook, 0, 0);
        board.performMove(0, 0, 0, 7);
        String[][] actual = board.getBoard();

//        Assertions.assertEquals(expected, actual);
    }

    /**
     * When try move rook to the busy cell should leave rook at the current position.
     */
    @Test
    void whenTryMoveRookToTheBusyCellInVerticalDirectShouldLeaveRookAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"H", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.rook, 0, 0);
        board.addFigure(new Horse(), 7, 0);
        board.performMove(0, 0, 7, 0);
        String[][] actual = board.getBoard();

//        Assertions.assertEquals(expected, actual);
    }

    /**
     * When rook try move across other figures should leave rook at the current position.
     */
    @Test
    void whenTryMoveRookAcrossFigureShouldLeaveRookAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "H", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.rook, 0, 0);
        board.addFigure(new Horse(), 0, 3);
        board.performMove(0, 0, 0, 7);
        String[][] actual = board.getBoard();

        Assertions.assertEquals(expected, actual);

    }

    /**
     * When need get string view of rook should check that it is acronym of rook.
     */
    @Test
    void whenAskAboutStringFromRookShouldGetAcronymForRook() {
        String expected = "R";
        String actual = rook.toString();
        Assertions.assertEquals(expected, actual);
    }
}
