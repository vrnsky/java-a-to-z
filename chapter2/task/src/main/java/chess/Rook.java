package chess;

/**
	It is implementation of rook figure. It may step by vertical and horizontal
*/
public class Rook extends Figure {

	/**
		It contants for represent rook as string
	*/
	private final static String ROOK_STRING = "R";
	
	/**
		Check than figure may make step in given coords
		@param:int fromX - it is start X position
		@param:int fromY - it is start Y position
		@param:int toX - it is finish X position
		@param:int toY - it is finish Y position
		@return: boolean canMove - true if figure may make this step and otherwise false
	*/
    @Override
    public boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if(toX == fromX && toY > fromY)
            canMove = checkRightDirection(figures, fromX, fromY,toX,toY);
        else if (toX == fromX && toY < fromY)
            canMove = checkLeftDirection(figures,fromX, fromY, toX, toY);
        else if (toX > fromX && toY == fromY)
            canMove = checkDownDirection(figures, fromX, fromY, toX, toY);
        else if (toX < fromX && toY == fromY)
            canMove = checkUpDirection(figures, fromX, fromY, toX, toY);
        return canMove;
    }
	

	/**
		Check right direction by counting figures in the path
		Parameters decribes in method canMove above
		@return: true if in the path no figure and otherwise false
	*/
    private boolean checkRightDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY + 1;
        int length = figures[fromX].length;
        int count = 0;
        while(index < length && index <= toY) {
            if(figures[fromX][index] != null)
                count++;
			index++;
        }
        return count == 0;
    }

	/**
		Check left direction by count figures in the path
		Parameters decribes at the method canMove
		@return: true if figure may make step into the left direction, and otherwise false
	*/
    private boolean checkLeftDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int index = fromY-1;
        int length = figures[fromX].length;
        int count = 0;
        while(index >= 0 && index < length && index <= toX) {
            if(figures[fromX][index] != null)
                count++;
            index--;
        }
        return count == 0;
    }

	/**
		Check down direction by count figures in the path
		Parameters decribes ath method canMove
		@return: ture if figure may make step into down direction and otherwise false
	*/
    private boolean checkDownDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int index = fromX+1;
        int length = figures[fromY].length;
        while(index < length && index != toX) {
            if(figures[index][fromY] != null)
                count++;
            index++;
        }
        return count == 0;
    }

	/**
		Check up direction by count figure in the path
		Parameters describes at the method canMove
		@return: true if figure may make this step and otherwise false
	*/
    private boolean checkUpDirection(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int index = fromX - 1;
        int length = figures[fromY].length;
        while(index < length && index >= toX) {
            if(figures[index][fromY] != null)
                count++;
            index--;
        }
        return count == 0;
    }

	/**
		Return a string view of rook figure
		@return: string view of rook
	*/
    @Override
    public String toString() {
        return ROOK_STRING;
    }



}

