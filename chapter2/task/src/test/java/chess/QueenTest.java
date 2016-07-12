package chess;

import static org.junit.Assert.*;
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
		//Act block
        boolean actual = queen != null;
		//Action block
        assertThat(actual, is(true));
    }

    /**
     * When try attach queen to the board should check that queen was attached to the board.
     */
    @Test
    public void whenTryAddQueenToTheBoardShouldCheckThanBoardSaveIt() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try move queen in right horizontal direction should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInRightDirectionShouldMoveQueenIfCellInThePathIsEmpty(){
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "Q"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,0);
        board.performMove(0,0,0,7);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try mvoe queen in left horizontal direction should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInLeftDirectionShouldMoveQueenIfCellsInThePathIsEmpty() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "Q", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,7);
        board.performMove(0,7,0,2);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try move queen by diagonal should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInDiagonalShouldMoveQueenIfInThePathCellsAreEmpty() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "Q"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,0);
        board.performMove(0,0,7,7);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try move queen in other direction by diagonal should check that figure was moved.
     */
    @Test
    public void whenTryMoveQueenInOtherDiagonalShouldMoveQueenIfInThePathCellsAreEmpty() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
		
		//Act block
        board.addFigure(this.queen,7,7);
        board.performMove(7,7,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try move queen to other position but position is busy should leave figure at the current position.
     */
    @Test
    public void whenTryMoveQueenToTheOtherPositionInVerticalDirButInThePathFigureShouldLeaveQueenAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},//0
                {"H", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,0);
        board.addFigure(new Horse(),1,0);
        board.performMove(0,0,1,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When queen try skip figure shoul leave figure at the current place.
     */
    @Test
	public void whenQueenTrySkipFigureShouldLeaveQueenAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"Q", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"P", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.queen,0,0);
        board.addFigure(new Pawn(),3,0);
        board.performMove(0,0,7,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));		
	}

    /**
     * When try get queen string view should check that is acronym for queen chess figure.
     */
    @Test
	public void whenGetQueenStringViewShouldGetAcronym() {
		
		//Assign block
		String expected = "Q";
		
		//Act block
		String actual = queen.toString();
	
		//Action block
		assertThat(actual, is(expected));
	}
	
}
