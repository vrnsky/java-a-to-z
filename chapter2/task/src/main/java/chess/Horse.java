package chess;

import static java.lang.Math.abs;

/**
	Implementation of horse chess figure
*/
public class Horse extends Figure {
	
	/**
		using for represent horse figure as string
	*/
	private static final String HORSE_STRING = "H";

	/**
		Use class rook for compute correct or wrong moving 
	*/
    private Rook rook;

	/**
		For using rook need init it
	*/
    public Horse() {
        this.rook = new Rook();
    }
	
	/**
		Check may figure make this step
		@param:int fromX - start X position
		@param:int fromY - start Y position
		@param:int toX - finish X position
		@param:int toY - finish Y position
		@return: boolean, true if figure may make this step and otherwise false
	*/
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        //We must know vertical or horizontal horse 
        if(abs(fromX - toX) == 2) {
            canMove = rook.canMove(figures,toX,fromY,toX,toY);
        }
        else if(abs(fromY - toY) == 2)
            canMove = rook.canMove(figures, fromX, toY, toX, toY);
        return canMove;
    }

	/**
		Return value of constant HORSE_STRING
		@return: String - string horse view
	*/
    @Override
    public String toString() {
        return HORSE_STRING;
    }
	
}
