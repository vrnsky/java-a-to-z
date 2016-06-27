package chess;


public class Rook extends Figure {

    @Override
    public boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean result = false;
        if(toX == fromX && toY > fromY)
            result = checkRightDirection(figures, fromX, fromY,toX,toY);
        else if (toX == fromX && toY < fromY)
            result = checkLeftDirection(figures,fromX, fromY, toX, toY);
        else if (toX > fromX && toY == fromY)
            result = checkDownDirection(figures, fromX, fromY, toX, toY);
        else if (toX < fromX && toY == fromY)
            result = checkUpDirection(figures, fromX, fromY, toX, toY);
        return result;
    }
	

    private boolean checkRightDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY + 1;
        int length = figures[fromX].length;
        int count = 0;
        while(index < length && index < toX) {
            if(figures[fromX][index] != null)
                count++;

            index++;
        }
        return count == 0;
    }

    private boolean checkLeftDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY-1;
        int length = figures[fromX].length;
        int count = 0;
        while(index >= 0 && index < length && index < toX) {
            if(figures[fromX][index] != null)
                count++;
            index--;
        }
        return count == 0;
    }

    private boolean checkDownDirection(Figure[][] figures, int fromX, int toX, int fromY, int toY) {
        int count = 0;
        int index = fromX+1;
        int length = figures[fromY].length;
        while(index < length && index < toY) {
            if(figures[index][fromY] != null)
                count++;

            index++;
        }

        return count == 0;
    }

    private boolean checkUpDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int index = fromX - 1;
        int length = figures[fromY].length;
        while(index < length && index > toX) {
            if(figures[index][fromY] != null)
                count++;
            index--;
        }

        return count == 0;
    }



}

