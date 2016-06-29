package chess;

/**
	Implementation of chess elephant figure
*/

public class Elephant extends Figure {
	
   /**
	  It use for show elephant as string
   */
   private static final String ELEPHANT_STRING = "E";
	
	/**
		Check than elephant may make this step
		@param:int fromX - start X position
		@param:int fromY - start Y position
		@param:int toX - finish X position
		@param:int toY - finish Y position
		@return:boolean, true if elephant may make this step, otherwise false
	*/
   @Override
   public  boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if((toX > fromX && toY < fromY) || toX > fromY && toY > fromY)
            canMove = forwardDiagonal(figures, fromX, fromY, toX, toY);
        else if(toX < fromX && toY < fromY)
            canMove = backwardDiagonal(figures, fromX, fromY, toX, toY);
        return canMove;
    }

	/**
		Check than elephant may make step by forward diagonal.
		Forward means coord are incresead by step
		@param: see canMove method,it is above this
		@return: boolean, if figure may make this step by forward diagonal, otherwise false
	*/
    private boolean forwardDiagonal(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        int count = 0;
        int currentX = fromX+1;
        int currentY = fromY-1;
        while(currentX <= toX && currentY >= toY && currentY >= 0) {
            if(figures[currentX][currentY] != null)
                count++;
            currentX++;
            currentY++;
        }
        return count == 0;
    }

	/**
		Check than elephant may make step by backward diagonal
		Backward means the coords are descrease by step
		@param: see canMove method, it is above
		@return: boolean, if elephant may make step by backward diagonal, otherwise false
	*/
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

	/**
		Return string view of elephant figure
		@return:String which describes elephant figure
	*/
    @Override
    public String toString() {
        return ELEPHANT_STRING;
    }

}
