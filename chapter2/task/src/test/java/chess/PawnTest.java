package chess;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import org.junit.Before;

/**
	Unit test of Pawn.java
*/
public class PawnTest {

	/**
		instance of testing object
	*/
    private Pawn pawn;
	
	/**
		before testing need init all need variables
	*/
    @Before
    public void setUp() {
        this.pawn = new Pawn();
    }

	/**
		Check than constructor works correct
	*/
    @Test
    public void whenCreateAPawnShouldCheckItIsNotNull() {
		
		//Act block
        boolean actual = pawn != null;
		
		//Action block
        assertThat(actual, is(true));
    }

	/**
		When try attach pawn to board should
		check that board save it
	*/
    @Test
    public void whenTryAttachPawnToTheBoardShouldAddPawnIfCellIsNotBusy() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"P", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
		
		//Act block
        board.addFigure(this.pawn,0,0);
        String[][] actual = board.getBoard();
		
		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move pawn in correct direction
		should move pawn, if path is empty
	*/
    @Test
    public void whenTryMovePawnInCorrectDirectionShouldMovePawn() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"P", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.pawn,0,0);
        board.performMove(0,0,2,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move pawn in wrong direction
		should leave pawn at the current position
	*/
    @Test
    public void whenTryMovePawnInWrongDirectionShouldLeavePawnAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"P", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.pawn,0,0);
        board.performMove(0,0,0,2);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move pawn but int the path figure
		should leave pawn at the current place
	*/
    @Test
    public void whenTryMovePawnButInThePathFigureShouldLeavePawnAtTheCurrentPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"P", "0", "0", "0", "0", "0", "0", "0"},//0
                {"P", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.pawn,0,0);
        board.addFigure(this.pawn,1,0);
        board.performMove(0,0,2,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try pawn skip over figures
		should leave pawn the current position
	*/
    @Test
    public void whenTryPawnTrySkipOverFiguresShouldLeavePawnAtTheCurrentPlace(){
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"P", "0", "0", "0", "0", "0", "0", "0"},//1
                {"P", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.pawn,1,0);
        board.addFigure(this.pawn,2,0);
        board.performMove(1,0,3,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	@Test
	public void whenTryGetStringViewOfPawnShoulGetStringAcronym() {
		
		//Assign block
		String expected = "P";
		
		//Act block
		String actual = pawn.toString();
		
		assertThat(actual, is(expected));
	}
}
