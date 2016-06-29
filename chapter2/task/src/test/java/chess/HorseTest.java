package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test for Horse class
*/
public class HorseTest {

	/**
		instance of testing class
	*/
    private Horse horse;

	/**
		init variables at this method
	*/
    @Before
    public void setUp() {
        this.horse = new Horse();
    }

	/**
		Check than constructor of horse work correct
	*/
    @Test
    public void whenCreateAHorseShouldCheckItIsNotNull() {
		
		//Act block
	    boolean actual = horse != null;

	    //Action block
        assertThat(actual, is(true));
    }

	/**
		Try attach horse to the board should check than horse attached to the board
	*/
    @Test
    public void whenTryAddHorseToTheBoardShouldCheckItSaved() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"H", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(horse,0,0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     *  1
     *  1   - it one of possible step of horse
     *  1 1
	 
		Try moving horse one of possible step, and check than figure has been moved
     */
    @Test
    public void whenTryMovingHorseInCorrectDirectionShouldMoveHorseToGivenPosition() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "H", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(horse,0,0);
        board.performMove(0,0,2,1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * 1 1
     * 1   - it is one possible step of horse
     * 1
	    
       Try moving horse of of possible step, and check than figure has been moved
	   Now horse exist at the bottom of board
     */
    @Test
    public void whenTryMovingHorseAtTheBottomInCorrectDirection() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "H", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.horse, 2,0);
        board.performMove(2,0,4,1);
        String[][] actual = board.getBoard();
		
		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try moving horse by vertical direction should move horse 
		and check than horse has been moved. Vertical means that horse
		make step three cell by horizontal and two by vertical
	
	*/
    @Test
    public void whenTryMovingHorseByVerticalCorrectDirectionShouldMoveHorseToGivenPosition() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "H", "0", "0", "0", "0", "0"},//1
                {"0", "0", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };
		
		//Act block
        board.addFigure(this.horse,0,0);
        board.performMove(0,0,1,2);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

	/**
		When try moving horse across other figure should move horse
	*/
    @Test
    public void whenTryMovingHorseAcrossOtherFigureShouldMoveHorse() {
		
		//Assign block
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"},//0
                {"0", "0", "0", "0", "0", "0", "0", "0"},//1
                {"P", "H", "0", "0", "0", "0", "0", "0"},//2
                {"0", "0", "0", "0", "0", "0", "0", "0"},//3
                {"0", "0", "0", "0", "0", "0", "0", "0"},//4
                {"0", "0", "0", "0", "0", "0", "0", "0"},//5
                {"0", "0", "0", "0", "0", "0", "0", "0"},//6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.horse,0,0);
        board.addFigure(new Pawn(),2,0);
        board.performMove(0,0,2,1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }
	
	/**
		When try get string view of horse
		Should check that is acronym
	*/
	@Test
	public void whenTryGetStringViewOfHorseShouldGetAcronym() {
		
		//Assign block
		String expected = "H";
		
		//Act block
		String actual = this.horse.toString();
		
		//Action block
		assertThat(actual, is(expected));
	}
}
