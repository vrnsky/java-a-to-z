package chess;

/**
	Implementation of queen chess figure
*/
public class Queen extends Figure {

	/**
		it uses for string view of queen
	*/
	private final static String QUEEN_STRING = "Q"; 
	
	/**
		use instance of Rook class for reduce code duplication
		Queen may make step by horizontal and vertical
	*/
    private Rook rook;
	
	/**
		use instance of Elephant class for reduce code duplication
		Queen may make step by diagonal
	*/
    private Elephant elephant;

	/**
		Before move figure at the board should init all instance 
		of using classes
	*/
    public Queen() {
        this.rook = new Rook();
        this.elephant = new Elephant();
    }
	
	/**
		Check may make figure this step
		@param:int fromX - it is start X position
		@param:int fromY - it is start Y position
		@param:int toX - it is finish X position
		@param:int toY - it is finish Y position
		@return:boolean, true if queen may make this step, and otherwise false
	*/
    @Override
    boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        boolean canMove = false;
        if(!rook.canMove(figures,fromX,fromY,toX,toY) && elephant.canMove(figures,fromX,fromY,toX,toY))
            canMove = true;
         else if(rook.canMove(figures,fromX, fromY, toX, toY) && !elephant.canMove(figures,fromX,fromY,toX,toY))
            canMove = true;

        return canMove;
    }

	/**
		Return string view of queen
		@return "Q"
	*/
    @Override
    public String toString() {
        return QUEEN_STRING;
    }
}
