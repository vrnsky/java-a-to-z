package model;

/**
 * Board, hold all steps.
 */
public class Board {

    /**
     * At this place hold all board.
     */
    String[][] board;

    /**
     * Width of board.
     */
    private int width;

    /**
     * Height of board.
     */
    private int height;

    /**
     * Create a new board.
     * @param width of board.
     * @param height of board.
     */
    public Board(int width, int height) {
        this.board = new String[width][height];
        this.width = width;
        this.height = height;
        fillBoard();
    }

    /**
     * Default constructor.
     */
    public Board() {
        this(3,3);
    }

    /**
     * Return board as two dimens string array.
     * @return string view of board.
     */
    public String[][] showBoard() {
        return this.board;
    }

    /**
     * Fill board by insert underscores.
     */
    private void fillBoard() {
        for(int index = 0; index < width; index++) {
            for(int barrier = 0; barrier < height; barrier++) {
                board[index][barrier] = "_";
            }
        }
    }

    /**
     * Perform step.
     * @param player instance of player interface.
     * @param x coord of position.
     * @param y coord of position.
     * @return true if step successfully performed, otherwise false.
     */
    public boolean performStep(Player player, int x, int y) {
        if(validate(x,y)) {
            this.board[x][y] = player.getSign();
        }

        return this.board[x][y].equals(player.getSign());
    }

    /**
     * Check boundaries of board.
     * @param x coord of checking position.
     * @param y coord of checking position.
     * @return true if correct position, otherwise false.
     */
    private boolean validate(int x, int y) {
        boolean canStep = false;
        if(x < width && y < width && this.board[x][y].equals("_")) {
            canStep = true;
        }

        return canStep;
    }

    /**
     * Return width of board.
     * @return width of board.
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Return height of board.
     * @return height of board.
     */
    public int getHeight() {
        return this.height;
    }
}
