package chess;

import static java.lang.Math.abs;

/**
 * Implementation of horse chess figure.
 */
public class Horse extends Figure {

	/**
	 * Using for show figure as string.
	 */
	private static final String HORSE_STRING = "H";

	/**
	 * Use API of rook chess figure for avoid code duplication.
	 */
    private Rook rook;

	/**
	 * Construct new horse and init needed fields.
	 */
    public Horse() {
        this.rook = new Rook();
    }

	/**
	 * Check may figure make this step.
	 * @param figures board for moving.
	 * @param fromX start X position.
	 * @param fromY start Y position.
	 * @param toX finish X position.
	 * @param toY finish Y position.
     * @return true if figure may make this step and otherwise false.
     */
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if(abs(fromX - toX) == 2) {
            canMove = rook.canMove(figures,toX,fromY,toX,toY);
        }
        else if(abs(fromY - toY) == 2)
            canMove = rook.canMove(figures, fromX, toY, toX, toY);
        return canMove;
    }

	/**
	 * Return a string view of horse.
	 * @return horse string.
     */
    @Override
    public String toString() {
        return HORSE_STRING;
    }
	
}
