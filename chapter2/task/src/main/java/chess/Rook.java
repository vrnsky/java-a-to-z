package chess;

/**
 * Implementation of rook chess figure.
 */
public class Rook extends Figure {


    /**
     * String view of rook.
     */
	private static final String ROOK_STRING = "R";

    /**
     * Check than figure may make step at the given position.
     * @param figures board for moving.
     * @param fromX start X position.
     * @param fromY start Y position.
     * @param toX finish X position.
     * @param toY finish Y position.
     * @return true if figure may make this step and otherwise false.
     */
    @Override
    public boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if (toX == fromX && toY > fromY) {
            canMove = checkRightDirection(figures, fromX, fromY, toX, toY);
        } else if (toX == fromX && toY < fromY) {
            canMove = checkLeftDirection(figures, fromX, fromY, toX, toY);
        } else if (toX > fromX && toY == fromY) {
            canMove = checkDownDirection(figures, fromX, fromY, toX, toY);
        } else if (toX < fromX && toY == fromY) {
            canMove = checkUpDirection(figures, fromX, fromY, toX, toY);
        }
        return canMove;
    }

    /**
     * Check right direction by counting figures in the path.
     * @param figures see method above.
     * @param fromX see method above.
     * @param fromY see method above.
     * @param toX see method above.
     * @param toY see method above.
     * @return see method above.
     */
    private boolean checkRightDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY + 1;
        int length = figures[fromX].length;
        int count = 0;
        while (index < length && index <= toY) {
            if (figures[fromX][index] != null) {
                count++;
            }
			index++;
        }
        return count == 0;
    }

    /**
     * Check left direction by count figures in the path.
     * @param figures see method above.
     * @param fromX see method above.
     * @param fromY see method above.
     * @param toX see method above.
     * @param toY see method above.
     * @return see method above.
     */
    private boolean checkLeftDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY - 1;
        int length = figures[fromX].length;
        int count = 0;
        while (index >= 0 && index < length && index <= toX) {
            if (figures[fromX][index] != null) {
                count++;
            }
            index--;
        }
        return count == 0;
    }

    /**
     * Check down direction by count figures in the path.
     * @param figures see method above.
     * @param fromX see method above.
     * @param fromY see method above.
     * @param toX see method above.
     * @param toY see method above.
     * @return see method above.
     */
    private boolean checkDownDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int index = fromX + 1;
        int length = figures[fromY].length;
        while (index < length && index != toX) {
            if (figures[index][fromY] != null) {
                count++;
            }
            index++;
        }
        return count == 0;
    }

    /**
     * Check up direction by count figure in the path.
     * @param figures see method above.
     * @param fromX see method above.
     * @param fromY see method above.
     * @param toX see method above.
     * @param toY see method above.
     * @return see method above.
     */
    private boolean checkUpDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int index = fromX - 1;
        int length = figures[fromY].length;
        while (index < length && index >= toX) {
            if (figures[index][fromY] != null) {
                count++;
            }
            index--;
        }
        return count == 0;
    }


    /**
     * Return string view of rook chess figure.
     * @return rook string.
     */
    @Override
    public String toString() {
        return ROOK_STRING;
    }



}

