package chess;
/**
 * Implementation of chess elephant figure.
 */
public class Elephant extends Figure {

    /**
     *  It use for show elephant as string.
     */
   private static final String ELEPHANT_STRING = "E";

    /**
     *
     * @param figures board for moving.
     * @param fromX start position by X axis.
     * @param fromY start position by Y axis.
     * @param toX finish position by X axis.
     * @param toY finish position by Y axis.
     * @return true if figure may make this step and otherwise false.
     */
   @Override
   public  boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
       boolean canMove = false;
       if ((toX > fromX && toY < fromY) || toX > fromY && toY > fromY) {
           canMove = forwardDiagonal(figures, fromX, fromY, toX, toY);
       } else if (toX < fromX && toY < fromY) {
           canMove = backwardDiagonal(figures, fromX, fromY, toX, toY);
       }
        return canMove;
    }

    /**
     * Check than elephant may make step by forward diagonal.
     * Forward means than the coordinates are increase by each step.
     * @param figures board for moving.
     * @param fromX start position by X axis.
     * @param fromY start position by Y axis.
     * @param toX finish position by X axis.
     * @param toY finish position by Y axis.
     * @return true if figure may make this step and otherwise false.
     */
   private boolean forwardDiagonal(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int currentX = fromX + 1;
        int currentY = fromY - 1;
        while (currentX <= toX && currentY >= toY && currentY >= 0) {
            if (figures[currentX][currentY] != null) {
                count++;
            }
            currentX++;
            currentY++;
        }
        return count == 0;
    }


    /**
     * Check than elephant may make step by backward diagonal.
     * Backward means the coordinates are decrease by step
     * @param figures board for moving.
     * @param fromX start position by X axis.
     * @param fromY start position by Y axis.
     * @param toX finish position by X axis.
     * @param toY finish position by Y axis.
     * @return true if figure may make this step otherwise false.
     */
   private boolean backwardDiagonal(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int currentX = fromX - 1;
        int currentY = fromY - 1;
        while (currentX >= toX && currentY >= toY) {
            if (figures[currentX][currentY] != null) {
                count++;
            }
            currentX--;
            currentY--;
        }
        return count == 0;
    }

    /**
     * Return a string view of figure.
     * @return elephant string.
     */
   @Override
   public String toString() {
        return ELEPHANT_STRING;
    }

}
