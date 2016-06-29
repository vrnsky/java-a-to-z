package chess;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;

/**
	Unit test of Queen.java
*/
public class QueenTest {

	/**
		instance of testing class
	*/
    private Queen queen;
	
	/**
		Init all need variables
	*/
    @Before
    public void setUp() {
        this.queen = new Queen();
    }

	/**
		Check than constructor works correct
	*/
    @Test
    public void whenTryCreateANewQueenShouldCheckThanItIsNotNull() {
		//Act block
        boolean actual = queen != null;
		//Action block
        assertThat(actual, is(true));
    }

	/**
		When try attach queen to the board should attach queen to the board
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
		When try move queen in right direction should move queen in left direction
		If cell is emply and in the path have no figure
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
		When try move queen in left direction 
		should move queen in left direction
		If cell is emply and in the path have no figure
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
		When try move queen by diagonal
		should check that path is empty and move queen
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
		When try move queen in other direction by diagonal
		should check than path is empty and move queen to given position
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
		When try move queen to other position, but position if busy
		should leave queen at the current place
		
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
		When queen try skip figure
		Should leave queen at the current place
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
		When try get queen string view
		should check that is acronym
	*/
	@Test
	public void whenGetQueenStringViewShouldGetAcronym() {
		
		//Assing block
		String expected = "Q";
		
		//Act block
		String actual = queen.toString();
	
		//Action block
		assertThat(actual, is(expected));
	}
	
}
