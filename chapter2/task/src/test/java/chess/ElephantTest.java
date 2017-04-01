package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Elephant.java
 * It test moving of elephant in different directions.
 */
public class ElephantTest {

    /**
     * Instance of testing class.
     */
    private Elephant elephant;

    /**
     * Init extract to this method for reduce code in test.
     */
    @Before
    public void setUp() {
        this.elephant = new Elephant();
    }

    /**
     * When create a new elephant should check that it is not null.
     */
    @Test
    public void whenCreateAnElephantShouldCheckItIsNotNull() {
        boolean actual = elephant != null;
        assertThat(actual, is(true));
    }

    /**
     * When try attach elephant to board should check that elephant was attached to board.
     */
    @Test
    public void whenTryAttachElephantToBoardShouldCheckThatBoardSaveIt() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"E", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant, 0, 0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }


    /**
     * When try move elephant in correct direction should move elephant to give position.
     */
    @Test
    public void whenTryMovingElephantInCorrectForwardDiagonalShouldMoveElephantToGivenPosition() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "E", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant, 0, 0);
        board.performMove(0, 0, 2, 2);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try moving elephant in correct backward diagonal should move elephant to given position.
     */
    @Test
    public void whenTryMovingElephantInCorrectBackwardDirectionShouldMoveElephantToGivenPosition() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"E", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant, 2, 2);
        board.performMove(2, 2, 0, 0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try moving elephant in correct direction but cell is busy
     * should leave elephant in current position.
     */
    @Test
    public void whenTryMovingElephantInCorrectDirectionButCellIsBusy() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"P", "0", "0", "0", "0", "0", "0", "0"}, //0s
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "E", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };


        board.addFigure(new Pawn(), 0, 0);
        board.addFigure(elephant, 2, 2);
        board.performMove(2, 2, 0, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When elephant try skip figures should leave elephant at the current position.
     */
    @Test
    public void whenElephantTrySkipFiguresShouldLeaveElephantAtTheCurretPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0s
                {"0", "P", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "E", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };


        board.addFigure(new Pawn(), 1, 1);
        board.addFigure(elephant, 2, 2);
        board.performMove(2, 2, 0, 0);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try get string view of elephant should get acronym of elephant figure.
     */
	@Test
	public void whenTryGetStringViewElephantShouldGetAcronym() {
		String expected = "E";
		String actual = this.elephant.toString();
		assertThat(actual, is(expected));
	}
}


