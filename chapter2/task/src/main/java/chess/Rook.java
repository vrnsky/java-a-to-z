package chess;

public class Rook extends Figure {

    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean result = false;
        //rook may step by horizontal and vertical
        int index = fromX;
        while(figures[index][fromY] == null && index <= toX) {
            result = true;
            index++;
        }

        index = fromY;
        while(figures[fromX][index] == null && index <= toY) {
            result = true;
            index++;
        }
        return result;
    }

}
