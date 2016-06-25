package chess;


public class Horse extends Figure {
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean result = false;
        if(toX - fromX <= 3 && toY - fromY <= 2)
            result = true;
        return result;
    }

}
