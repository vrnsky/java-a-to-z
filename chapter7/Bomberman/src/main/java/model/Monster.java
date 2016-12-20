package model;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author evrnsky
 * @version 0.2
 * @since 06.12.2016
 * Monster from game bomberman.
 * If it try to move to the busy block, it must wait 5 seconds.
 * And try again.
 */
public class Monster extends Actor implements Runnable {

    /**
     * Fair lock which need for avoid deadlock and right order of steps.
     */
    private final Lock currentCell = new ReentrantLock(true);

    /**
     * Fair lock which need for avoid deadlock and right order of steps.
     */
    private final Lock nextCell = new ReentrantLock(true);

    /**
     * Time which wait monster for moving.
     */
    private static final int WAIT_TIME = 5000;


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
     * TODO rewrite this method.
     */
    @Override
    void performMoving(Direction direction) {
        boolean stepMake = false;
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
