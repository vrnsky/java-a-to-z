package chess;

/**
 * Implementation queen chess figure.
 */
public class Queen extends Figure {

	/**
	 * String view of queen chess figure.
	 */
	private static final String QUEEN_STRING = "Q";

	/**
	 * For avoid code duplication use API of existing class rook.
	 * It allow queen make step by horizontal and vertical directions.
	 */
    private Rook rook;

	/**
	 * For avoid code duplication use API of existing class elephant.
	 * It allow queen make by diagonal.
	 */
    private Elephant elephant;

	/**
	 * Create a new queen and init all need fields.
	 */
    public Queen() {
        this.rook = new Rook();
        this.elephant = new Elephant();
    }

	/**
	 * Check may make figure this step.
	 * @param figures board for moving.
	 * @param fromX start X position.
	 * @param fromY start Y position.
	 * @param toX finish X position.
	 * @param toY finish Y position.
     * @return true if queen may make this step otherwise false.
     */
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
		boolean canMove = false;
		if (!rook.canMove(figures, fromX, fromY, toX, toY) && elephant.canMove(figures, fromX, fromY, toX, toY)) {
			canMove = true;
		} else if (rook.canMove(figures, fromX, fromY, toX, toY) && !elephant.canMove(figures, fromX, fromY, toX, toY)) {
			canMove = true;
	    }
        return canMove;
    }

	/**
	 * Return string view of figure.
	 * @return queen string.
     */
    @Override
    public String toString() {
        return QUEEN_STRING;
    }
}
