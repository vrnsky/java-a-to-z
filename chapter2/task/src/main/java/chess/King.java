package chess;

import static java.lang.Math.abs;

/**
	Implementation of chess king figure
*/
public class King extends Figure {

	/**
		it uses for show king figure as string
	*/
	private static final String KING_STRING = "K";
	
	/**
		For more reduce code duplication, use Queen
	*/
    private Queen queen;

	/**
		Init all using class
	*/
    public King() {
        this.queen = new Queen();
    }
	
	/**
		Check that king may make this step
		@param:int fromX - start X position
		@param:int fromY - start Y position
		@param:int toX - finish X position
		@param:int toY - finish Y position
		@return:boolean, true if king may make this step, otherwise false
	*/
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if(abs(toX - fromX) == 1 && toY == fromY)
            canMove = queen.canMove(figures,fromX, fromY, toX, toY);
        else if(abs(toX - fromX) == 1 && abs(toY - fromY) == 1)
            canMove = queen.canMove(figures, fromX, fromY, toX, toY);
		else if(abs(fromY - toY) == 1 && toX == fromX)
			canMove = queen.canMove(figures, fromX, fromY, toX, toY);
        return canMove;
    }

	/**
		Return a string view of king
		@return:String describes king figure
	*/
    @Override
    public String toString() {
        return KING_STRING;
    }
}
