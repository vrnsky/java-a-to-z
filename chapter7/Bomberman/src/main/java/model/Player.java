package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Player this manage by user.
 */
public class Player extends Actor {

    /**
     * Create a new player with given params.
     * @param board instance of board class.
     * @param x at the board.
     * @param y at the board.
     */
    public Player(Board board, int x, int y) {
        super(board, x, y);
    }

    /**
     * Execute moving.
     * @param direction for moving.
     */
    @Override
    void performMoving(Direction direction) {
        if (isValidMoving(direction)) {
            int currentX = getX();
            int currentY = getY();
            synchronized (board.getBlock(currentX, currentY)) {
                updateCoordinates(direction);
                synchronized (board.getBlock(getX(), getY())) {
                    board.getBlock(currentX, currentY).detachActor();
                    board.getBlock(getX(), getY()).attachActor(this);
                }
            }
        }
    }
}
