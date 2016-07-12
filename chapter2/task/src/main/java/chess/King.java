package chess;

import static java.lang.Math.abs;
/**
 * Implementation of chess king figure.
 */
public class King extends Figure {

	/**
	 * String view of king chess figure.
	 */
	private static final String KING_STRING = "K";

	/**
	 * King may step such as queen but it may make only one step.
	 */
    private Queen queen;

	/**
	 * Construct new king figure and init all needed fields.
	 */
    public King() {
        this.queen = new Queen();
    }

	/**
	 * Check that king may make this step.
	 * @param figures board for moving.
	 * @param fromX start X position.
	 * @param fromY start Y position.
	 * @param toX finish X position.
	 * @param toY finish Y position.
     * @return true if king may make this step, otherwise false.
     */
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if(abs(toX - fromX) == 1 && toY == fromY)
            canMove = queen.canMove(figures,fromX, fromY, toX, toY);
        else if(abs(toX - fromX) == 1 && abs(toY - fromY) == 1)
            canMove = queen.canMove(figures, fromX, fromY, toX, toY);
		else if(abs(fromY - toY) == 1 && toX == fromX)
			canMove = queen.canMove(figures, fromX, fromY, toX, toY);
        return canMove;
    }

	/**
	 * Return a string vie of king.
	 * @return king string.
     */
    @Override
    public String toString() {
        return KING_STRING;
    }
}
