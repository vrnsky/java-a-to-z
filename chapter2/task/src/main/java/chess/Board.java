package chess;

public class Board {
	
	private static final int BOARD_WIDTH = 8;
	private static final int BOARD_HEIGHT = 8;
	private Figure[][] figures;
	
	
	public Board() {
		figures = new Figure[BOARD_WIDTH][BOARD_HEIGHT];
	}
	
	/**
		Adding figure to the field
		Should check that position is free also check boundaries
		Next steps
		1.Checking boundaries of the field
		2.Next check that cell is empty 
		3.Write to the coord a new figure
		
	*/
	public void addFigure(Figure figure, int x, int y) {
		if(checkBoundaries(x,y) && checkEmpty(x,y)) {
			figures[x][y] = figure;
		}
	}
	
	public boolean checkBoundaries(int x, int y) {
		return x < BOARD_WIDTH && y < BOARD_HEIGHT;
	}
	
	public boolean checkEmpty(int x, int y) {
		return figures[x][y] == null;
	}

	
	public boolean canMove(int fromX, int fromY, int toX, int toY) {
		return figures[fromX][fromY].canMove(figures, fromX, fromY, toX, toY);
	}

	public void performMove(int fromX, int fromY, int toX, int toY) {
		if(canMove(fromX,fromY, toX, toY)) {
			figures[toX][toY] = figures[fromX][fromY];
			figures[fromX][fromY] = null;
		}
	}
	
}