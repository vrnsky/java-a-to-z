package chess;

/**
 * Common class for all figure.
 */
abstract class Figure {

	/**
	 * Solve can the given figure move to the given position from current.
	 * @param figures board.
	 * @param fromX current position.
	 * @param fromY current position.
	 * @param toX wished position.
	 * @param toY wished position.
	 * @return true if can moved, otherwise false.
	 */
	abstract boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY);
}