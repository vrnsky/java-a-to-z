package model;

import java.util.Random;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 */
public class Game {

    /**
     * For generate RN position.
     */
    private static final Random RN = new Random();

    /**
     * Instance of board class.
     */
    private Board board;

    /**
     * Enemies.
     */
    private Thread[] enemies;

    /**
     * Create a new game with given params.
     * @param width of board.
     * @param height of board.
     * @param enemy it count.
     */
    public Game(int width, int height, int enemy) {
        this.board = new Board(width, height);
        this.enemies = new Thread[enemy];
        initMonster();
    }

    /**
     * Start all threads which enemies.
     */
    public void start() {
        for (Thread thread : this.enemies) {
            thread.start();
        }
    }

    /**
     * Init all monsters.
     */
    private void initMonster() {
        for (Thread thread : this.enemies) {
            int x = RN.nextInt(board.getWidth());
            int y = RN.nextInt(board.getHeight());
            if (board.getBlock(x, y).getActor() == null) {
                thread = new Thread(new Monster(board, x, y));
            }
        }
    }




}
