package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Monster from game bomberman.
 * If it try to move to the busy block, it must wait 5 seconds.
 * And try again.
 */
public class Monster extends Actor implements Runnable {

    /**
     * Create a new monster.
     * @param board for moving.
     * @param x position at the board.
     * @param y position at the board.
     */
    public Monster(Board board, int x, int y) {
        super(board, x, y);
    }

    /**
     * Moving monster at the board.
     * @param direction for moving.
     */
    @Override
    void performMoving(Direction direction) {
        boolean stepMake = false;
        synchronized (board.getBlock(getX(), getY())) {
            while (!stepMake) {
                if (isValidMoving(direction)) {
                    int prevX = getX();
                    int prevY = getY();
                    updateCoordinates(direction);
                    int nextX = getX();
                    int nextY = getY();
                    synchronized (board.getBlock(nextX, nextY)) {
                        if (board.getBlock(nextX, nextY).getActor() != null) {
                            final int waitTime = 5000;
                            try {
                                Thread.sleep(waitTime);
                            } catch (InterruptedException iex) {
                                iex.printStackTrace();
                            }
                        } else {
                            board.getBlock(nextX, nextY).attachActor(this);
                            board.getBlock(prevX, prevY).detachActor();
                            stepMake = true;
                        }
                    }
                }
            }
        }
    }

    /**
     * Async task.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            performMoving(Direction.getRandomDirection());
        }
    }
}
