package chess;


public class Elephant extends Figure {
    @Override
   public  boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean result = false;
        if((toX > fromX && toY < fromY) || toX > fromY && toY > fromY)
            result = forwardDiagonal(figures, fromX, fromY, toX, toY);
        else if(toX < fromX && toY < fromY)
            result = backwardDiagonal(figures, fromX, fromY, toX, toY);
        return result;
    }

    private boolean forwardDiagonal(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int currentX = fromX+1;
        int currentY = fromY-1;
        while(currentX <= toX && currentY >= toY && currentY >= 0) {
            if(figures[currentX][currentY] != null)
                count++;
            currentX++;
            currentY--;
        }
        return count == 0;
    }

    private boolean backwardDiagonal(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int currentX = fromX - 1;
        int currentY = fromY - 1;
        while(currentX >= toX && currentY >= toY) {
            if(figures[currentX][currentY] != null)
                count++;
            currentX--;
            currentY--;
        }
        return count == 0;
    }

}
