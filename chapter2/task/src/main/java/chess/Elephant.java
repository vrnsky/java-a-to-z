package chess;


public class Elephant extends Figure {
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean result = false;
        for(int index = fromX; index <= toX; index++ ) {
            for(int barrier = toY; barrier <= fromY; barrier--) {
                if(figures[index][barrier] == null)
                    result = true;
            }
        }
        return result;
    }
}
