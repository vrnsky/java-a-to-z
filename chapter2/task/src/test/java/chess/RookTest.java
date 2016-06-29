package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test of Rook.java
*/
public class RookTest {

	/**
	  instance of testing class
	*/
    private Rook rook;

	/**
		init before using in test
	*/
    @Before
    public void setUp() {
        this.rook = new Rook();
    }

	/**
		Check than constructor works correct
	*/
    @Test
    public void whenCreateRookShouldCheckItIsNotNull() {
		
		//Act block
        boolean actual = this.rook != null;
		
		//Action block
        assertThat(actual, is(true));
    }

	/**
		When try attach rook to the board should attach rook
		and check that board save it
	*/
    @Test
    public void whenTryAddRookToTheBoardShouldCheckThanBoardSaveIt() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.rook,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	
	/**
		When try moving rook in the board in correct
		vertical direction should move perform
	*/
    @Test
    public void whenTryMovingRookInTheBoardInCorrectVerticalDirectionShouldMovePerform() {
		
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
                {"R", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.rook,0,0);
        board.performMove(0,0,7,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	
	/**
		When try moving rook in the board in correct vertical
		direction should perform move
	*/
    @Test
    public void whenMovingRookInTheBoardIntCorrectHorizontalDirShouldPerformMove() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "R"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.rook,0,0);
        board.performMove(0,0,0,7);
        String[][] actual = board.getBoard();

		//Action blokc
        assertThat(actual, is(expected));
    }

	/**
		When try move rook to the busy cell should
		leave rook at the curren position
	*/
    @Test
    public void whenTryMoveRookToTheBusyCellInVerticalDirectShouldLeaveRookAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"H", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.rook,0,0);
        board.addFigure(new Horse(),7,0);
        board.performMove(0,0,7,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	/**
		When try move across other figures should
		leave rook at the current position
	*/
    @Test
    public void whenTryMoveRookAcrossFigureShouldLeaveRookAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"R", "0", "0", "H", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.rook,0,0);
        board.addFigure(new Horse(),0,3);
        board.performMove(0,0,0,7);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));

    }
	
	/**
		When get string view of rook should get acronym
	*/
	@Test
	public void whenAskAboutStringFromRookShouldGetAcronymForRook() {
		
		//Assign block
		String expected = "R";
		
		//Act block
		String actual = rook.toString();
		
		assertThat(actual, is(expected));
	}
}
