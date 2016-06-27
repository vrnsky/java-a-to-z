package chess;

/**
 * Created by Egor on 27.06.2016.
 */
public class FigureDecorator extends Figure {

    @Override
    public boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        return true;
    }
}
