package chess;

import static java.lang.Math.abs;
/**
	It is pawn implementation of pawn figure
*/
public class Pawn extends Figure {
	
	/**
		Use for string view, "P" - it is acronym for pawn
	*/
	private static final String PAWN_STRING = "P";
	/**
		Use rook for decouple code
	*/
	private Rook rook;

	/**
		Init rook at this class for using 
	*/
	public Pawn() {
		this.rook = new Rook();
	}
	
	/**
		Pawn may move in X axis, also if it may beat other figure by diagonal
		@param:int fromX - it is start X position
		@param:int fromY - it is start Y position
		@param:int toX - it is finish X position
		@param:int toY - it is finish Y position
		@return:true if it may move to given position, otherwise false
	*/
	boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
		boolean canMove = false;
		if(abs(fromX - toX) > 2) canMove = false;
		else if(abs(fromY - toY) > 0) canMove = false;
		else canMove = rook.canMove(figures, fromX, fromY, toX, toY);

		return canMove;
	}


	/**
		Return a string view of pawn figure
		@return: string which describes pawn figure
	*/
	@Override
	public String toString() {
		return PAWN_STRING;
	}
}