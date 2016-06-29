package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
	Unit test of Board.java
	
*/
public class BoardTest {

	/**
		instance of testing class
	*/
    private Board board;
	
	/**
		before using must init all need variables
	*/
    @Before
    public void setUp() {
        board = new Board();
    }

	/**
		When create board should check
		that board is empty
	*/
    @Test
    public void whenCreateBoardShouldCheckThatBoardEmpty() {
		
		//Assign block
		String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
       
		//Act block
        String[][] actual = board.getBoard();
		
		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try add figure to board should
		check that board saved it
	*/
    @Test
    public void whenTryAddFigureToBoardShouldCheckThatBoardSaveIt() {
		
		//Assign block
        board.addFigure(new Pawn(),0,0);
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
        String[][] actual = board.getBoard();
		
		//Action block
        assertThat(actual, is(expected));

    }

	/**
		When try move figure in correct direction
		should move figure 
		
	*/
    @Test
    public void whenTryMoveFigureInCorrectDirectionShouldMoveFigure() {
		
		//Assign block
        board.addFigure(new Pawn(),0,0);
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
        board.performMove(0,0,2,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
}
