package chess;

import static java.lang.Math.abs;
/**
 * Implementation of pawn chess figure.
 */
public class Pawn extends Figure {

	/**
	 * String view of pawn chess figure.
	 */
	private static final String PAWN_STRING = "P";

	/**
	 * Use rook api for avoid code duplication.
	 */
	private Rook rook;


	/**
	 * Create a new pawn.
	 * Before using API of rook need init it.
	 */
	public Pawn() {
		this.rook = new Rook();
	}


	/**
	 * Pawn may move in X axis, also if it may beat other figure by diagonal.
	 * @param figures board for moving.
	 * @param fromX start X position.
	 * @param fromY start Y position.
	 * @param toX finish X position.
	 * @param toY finish Y position.
     * @return true if it may move to given position otherwise false.
     */
	boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
		boolean canMove = false;
		if(abs(fromX - toX) > 2) canMove = false;
		else if(abs(fromY - toY) > 0) canMove = false;
		else canMove = rook.canMove(figures, fromX, fromY, toX, toY);

		return canMove;
	}

	/**
	 * Return a string view of pawn figure.
	 * @return pawn string.
     */
	@Override
	public String toString() {
		return PAWN_STRING;
	}
}