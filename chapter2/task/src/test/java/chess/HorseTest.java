package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
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
    @BeforeEach
    public void setUp() {
        this.horse = new Horse();
    }

    /**
     * Check than constructor of horse work correct.
     */
    @Test
    void whenCreateAHorseShouldCheckItIsNotNull() {
	    boolean actual = horse != null;
        assertThat(actual, is(true));
    }

    /**
     * When try attach horse to board should check that board saved it.
     */
    @Test
    void whenTryAddHorseToTheBoardShouldCheckItSaved() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"H", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(horse, 0, 0);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * Try moving horse one of possible step should check that figure was moved.
     */
    @Test
    void whenTryMovingHorseInCorrectDirectionShouldMoveHorseToGivenPosition() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "H", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(horse, 0, 0);
        board.performMove(0, 0, 2, 1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * Try moving horse in one of possible position should check that figure was moved.
     */
    @Test
    void whenTryMovingHorseAtTheBottomInCorrectDirection() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "H", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };


        board.addFigure(this.horse, 2, 0);
        board.performMove(2, 0, 4, 1);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try moving horse in one of possible position should check that figure was moved.
     */
    @Test
    void whenTryMovingHorseByVerticalCorrectDirectionShouldMoveHorseToGivenPosition() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "H", "0", "0", "0", "0", "0"}, //1
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

        board.addFigure(this.horse, 0, 0);
        board.performMove(0, 0, 1, 2);
        String[][] actual = board.getBoard();

        assertThat(actual, is(expected));
    }

    /**
     * When try moving horse across other figure should move horse.
     */
    @Test
    void whenTryMovingHorseAcrossOtherFigureShouldMoveHorse() {
        Board board = new Board();
        String[][] expected = new String[][]{
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //0
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //1
                {"P", "H", "0", "0", "0", "0", "0", "0"}, //2
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //3
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //4
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //5
                {"0", "0", "0", "0", "0", "0", "0", "0"}, //6
                {"0", "0", "0", "0", "0", "0", "0", "0"}//7}
        };

		//Act block
        board.addFigure(this.horse, 0, 0);
        board.addFigure(new Pawn(), 2, 0);
        board.performMove(0, 0, 2, 1);
        String[][] actual = board.getBoard();

		//Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try get string view of horse should check that is acronym for figure.
     */
    @Test
	void whenTryGetStringViewOfHorseShouldGetAcronym() {
		String expected = "H";
		String actual = this.horse.toString();
		assertThat(actual, is(expected));
	}
}
