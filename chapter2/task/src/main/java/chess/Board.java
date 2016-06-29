package chess;

/**
	It is implementation of chess board
*/
public class Board {
	
	/**
		This contants describes a size of chess field
	*/
	private static final int BOARD_WIDTH = 8;
	private static final int BOARD_HEIGHT = 8;
	
	/**
		All fiels is figure cells
	*/
	private Figure[][] figures;
	
	/**
		Create a new board with next size BOARD_WIDTH x BOARD_HEIGHT
	*/
	public Board() {
		figures = new Figure[BOARD_WIDTH][BOARD_HEIGHT];
	}
	
	/**
		Add	figure to the board 
		@param:int X - position of X axis
		@param:int Y - position of Y axis
	*/
	public void addFigure(Figure figure, int x, int y) {
		if(checkBoundaries(x,y) && checkEmpty(x,y)) {
			figures[x][y] = figure;
		}
	}
	
	/**
		Check that given position x and y smaller than max size of board
		@param:int X - position of X asix
		@param:int Y - position of Y axis
		@return: true if x and y smaller than max side of field
	*/
	private boolean checkBoundaries(int x, int y) {
		return x < BOARD_WIDTH && y < BOARD_HEIGHT;
	}
	
	/**
		Check than field at the x,y position if empty by checking figure for null
		@param:int X - position of X axis
		@param:int Y - position of Y axis
		@return: true if at the x and y position does not exist figure, otherwise false
	*/
	private boolean checkEmpty(int x, int y) {
		return figures[x][y] == null;
	}

	
	/**
		Compute may can figure at the position fromX, fromY to position toX, toY by calling method figure canMove
		@param:int fromX - it is start X position
		@param:int fromY - it is start Y position
		@param:int toX - it is finish X position
		@param:int toY - it is finish Y position
		@return: true if figure can may this step and otherwise false
	*/
	public boolean canMove(int fromX, int fromY, int toX, int toY) {
		return checkBoundaries(toX, toY) && figures[fromX][fromY].canMove(figures, fromX, fromY, toX, toY) && checkEmpty(toX,toY) && !checkEmpty(fromX,fromY);
	}

	/**
		Perform moving figure by remove its from current place
		and place at the new place
		@param:int fromX - it is start X position
		@param:int fromY - it is start Y position
		@param:int toX - it is finish X position
		@param:int toY - it is finish Y position
	*/
	public void performMove(int fromX, int fromY, int toX, int toY) {
		if(canMove(fromX,fromY, toX, toY) ) {
			figures[toX][toY] = figures[fromX][fromY];
			figures[fromX][fromY] = null;
		}
	}


	/**
		Return a board in two dimens string array
		@return: String[][] - string view of the board
	*/
	public String[][] getBoard() {
		String[][] board = new String[BOARD_WIDTH][BOARD_HEIGHT];
		for(int x = 0; x < BOARD_WIDTH; x++) {
			for(int y = 0; y < BOARD_HEIGHT; y++) {
				Figure figure = figures[x][y];
				if(figure != null)
					board[x][y] = figure.toString();
				else
					board[x][y] = "0";
			}
		}

		return board;
	}


	
}