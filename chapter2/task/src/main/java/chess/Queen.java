package chess;

/**
 * Created by Egor on 27.06.2016.
 */
public class Queen extends Figure {

    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        return true;
    }
}
