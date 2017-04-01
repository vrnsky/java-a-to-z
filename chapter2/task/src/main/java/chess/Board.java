package chess;


/**
 * Implementation of chess board.
 */
public class Board {

	/**
	 * Width of board size given in cells.
	 */
	private static final int BOARD_WIDTH = 8;

	/**
	 * Height of board size given in cells.
	 */
	private static final int BOARD_HEIGHT = 8;

	/**
	 * All cells in board must be figure.
	 */
	private Figure[][] figures;

	/**
	 * Create a new board with default size.
	 */
	public Board() {
		figures = new Figure[BOARD_WIDTH][BOARD_HEIGHT];
	}


	/**
	 * Add figure to the board.
	 * @param figure implementation of figure interface.
	 * @param x position of X axis.
     * @param y position of Y axis.
     */
	public void addFigure(Figure figure, int x, int y) {
		if (checkBoundaries(x, y) && checkEmpty(x, y)) {
			figures[x][y] = figure;
		}
	}

	/**
	 * Check that given coordinates smaller than given size of board.
	 * @param x position of X axis.
	 * @param y position of Y axis.
     * @return true if x and y smaller that size of board, otherwise false.
     */
	private boolean checkBoundaries(int x, int y) {
		return x < BOARD_WIDTH && y < BOARD_HEIGHT;
	}

	/**
	 * Check that field at the x and y position is empty by checking figure for null.
	 * @param x position of X axis.
	 * @param y position of Y axis.
     * @return true if cell is empty, and otherwise false.
     */
	private boolean checkEmpty(int x, int y) {
		return figures[x][y] == null;
	}

	/**
	 * Compute may can figure at the given position move to other given position.
	 * @param fromX start point by X axis.
	 * @param fromY start point by Y axis.
	 * @param toX finish point by X axis.
	 * @param toY finish point by Y axis.
     * @return true if figure may this step, and otherwise false.
     */
	public boolean canMove(int fromX, int fromY, int toX, int toY) {
		return checkBoundaries(toX, toY)
				&&
			   figures[fromX][fromY].canMove(figures, fromX, fromY, toX, toY)
				&&
		       checkEmpty(toX, toY) && !checkEmpty(fromX, fromY);
	}

	/**
	 * Perform moving figure by remove its from current place and place at the new place.
	 * @param fromX it is start X position.
	 * @param fromY it is start Y position.
	 * @param toX it is finish X position.
     * @param toY it is finish Y position.
     */
	public void performMove(int fromX, int fromY, int toX, int toY) {
		if (canMove(fromX, fromY, toX, toY)) {
			figures[toX][toY] = figures[fromX][fromY];
			figures[fromX][fromY] = null;
		}
	}

	/**
	 * Return a board in two dimens string array.
	 * @return string view of the board.
     */
	public String[][] getBoard() {
		String[][] board = new String[BOARD_WIDTH][BOARD_HEIGHT];
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGHT; y++) {
				Figure figure = figures[x][y];
				if (figure != null) {
					board[x][y] = figure.toString();
				} else {
					board[x][y] = "0";
				}
			}
		}
		return board;
	}
}