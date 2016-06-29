package chess;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import org.junit.Before;

/**
	It unit test for King class
*/
public class KingTest {

	/**
		Instance of King class for testing
	*/
    private King king;
	
	/**
		Init all needed variables
	*/
    @Before
    public void setUp() {
        this.king = new King();
    }

	/**
		Check than correct create figure object
	*/
    @Test
    public void whenCreateAKingShouldCheckThanItIsNotNull() {
	
     	//Act block
        boolean actual = this.king != null;
		
		//Action block
        assertThat(actual, is(true));
    }

	/**
		Try attach king figure to the board
	*/
    @Test
    public void whenTryAttachKingToBoardShouldCheckThatBoardSaveIt() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move king in correct horizontal direction should move king
	*/
    @Test
    public void whenTryMoveKingInCorrectHorizontalDirectionShouldMoveKing() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "K", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        board.performMove(0,0,0,1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move king in correct vertical direction should move king
	*/
    @Test
    public void whenTryMoveKingInCorrectVerticalDirectionShouldMoveKing() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"K", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        board.performMove(0,0,1,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move king in correct diagonal direction should move king
	*/
    @Test
    public void whenTryMoveKingInCorrectDiagonalDirectionShouldMoveKing() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "K", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        board.performMove(0,0,1,1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move king to the busy cell should leave king at the current place
	*/
    @Test
    public void whenTryMoveKingToTheBusyCellShouldLeaveKingAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "H", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        board.addFigure(new Horse(),1,1);
        board.performMove(0,0,1,1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move king more than one cell should leave king at the current place
	*/
    @Test
    public void whenTryMoveKingBiggerThatOneCellShouldLeaveKingAtTheCurrentPlace() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
        board.performMove(0,0,2,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	/**
		When king try skip figures 
		should leave king at the current place
	*/
	@Test
	public void whenKingTrySkipFigureShouldLeaveKingAtTheCurrentPlace() {
		Board board = new Board();
        String[][] expected = new String[][]{
                {"K", "0", "0", "0", "0", "0", "0", "0"},//0
                {"P", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.king,0,0);
		board.addFigure(new Pawn(),1,0);
        board.performMove(0,0,3,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));		
	}
	
	@Test
	public void whenTryGetStringViewOfKingShouldGetAcronym() {
		
		//Assign block
		String expected = "K";
		
		//Act block
		String actual = king.toString();
		
		//Action block
		assertThat(actual, is(expected));
	}


}
