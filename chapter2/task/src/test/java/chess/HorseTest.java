package chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Horse.java
 * Testing all opportunity action for horse chess figure.
 */
public class HorseTest {

    /**
     * Instance of testing class.
     */
    private Horse horse;

    /**
     * To reduce code in test init action perform at this method.
     */
    @Before
    public void setUp() {
        this.horse = new Horse();
    }

    /**
     * Check than constructor of horse work correct.
     */
    @Test
    public void whenCreateAHorseShouldCheckItIsNotNull() {
		
		//Act block
	    boolean actual = horse != null;

	    //Action block
        assertThat(actual, is(true));
    }

    /**
     * When try attach horse to board should check that board saved it.
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
     * Try moving horse one of possible step should check that figure was moved.
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
     * Try moving horse in one of possible position should check that figure was moved.
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
     * When try moving horse in one of possible position should check that figure was moved.
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
     * When try moving horse across other figure should move horse.
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
     * When try get string view of horse should check that is acronym for figure.
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
