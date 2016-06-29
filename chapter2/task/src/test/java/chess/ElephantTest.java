package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test of Elephant class
*/
public class ElephantTest {

	/**
		variable for testing behaviour elephant figure
	*/
    private Elephant elephant;

	/**
		Init elephant
	*/
    @Before
    public void setUp() {
        this.elephant = new Elephant();
    }

	/**
		Check than figure not null
	*/
    @Test
    public void whenCreateAnElephantShouldCheckItIsNotNull() {
       
	    //Act block
        boolean actual = elephant != null;
		
		//Action block
        assertThat(actual, is(true));
    }

	/**
		When try attach elepant to board should attach elephant to the board
	*/
    @Test
    public void whenTryAttachElephantToBoardShouldCheckThatBoardSaveIt() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"E", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try move elephant in correct direction should move elephant to given position
		Forward diagonal means that x and y increase at each step
	*/
    @Test
    public void whenTryMovingElephantInCorrectForwardDiagonalShouldMoveElephantToGivenPosition() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "E", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant,0,0);
        board.performMove(0,0,2,2);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try moving elephant in correct backward diagonal should move elephant to given position
		Backward means than x and y decrease at each step
	*/
    @Test
    public void whenTryMovingElephantInCorrectBackwardDirectionShouldMoveElephantToGivenPosition() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"E", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(elephant,2,2);
        board.performMove(2,2,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try moving elephant in correct direction but cell is busy
		Should leave elephant in current position
	*/
    @Test
    public void whenTryMovingElephantInCorrectDirectionButCellIsBusy() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"P", "0", "0", "0", "0", "0", "0", "0"},//0s
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "E", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
		
		//Act block
        board.addFigure(new Pawn(),0,0);
        board.addFigure(elephant,2,2);
        board.performMove(2,2,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	
	/**
		When elephant try skip figures
		should leave elephant at the current position
	*/
	@Test
    public void whenElephantTrySkipFiguresShouldLeaveElephantAtTheCurretPlace() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0s
                {"0", "P", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "E", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
		
		//Act block
        board.addFigure(new Pawn(),1,1);
        board.addFigure(elephant,2,2);
        board.performMove(2,2,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	/**
		When try get string view of elephant
		Should get acronym of elephant
	*/
	@Test
	public void whenTryGetStringViewElephantShouldGetAcronym() {
		
		//Assign block
		String expected = "E";
		
		//Act block
		String actual = this.elephant.toString();
		
		//Action block
		assertThat(actual, is(expected));
	}
}


