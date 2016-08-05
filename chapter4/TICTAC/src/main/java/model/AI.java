package model;

import java.util.Random;

/**
 * Implementation of simple AI which play in tictac game.
 */
public class AI extends Player {

    private static final Random RN = new Random();

    /**
     * Create new intelligence.
     * @param sign of computer.
     */
    public AI(String sign) {
        super(sign);
    }

    /**
     * Perform step in board.
     * @param board instance of board class.
     * @param x     position at the board.
     * @param y     position at the board.
     * @return true if step is successfully executed and false otherwise.
     */
    @Override
    public boolean makeStep(Board board, int x, int y) {
        return board.performStep(this, RN.nextInt(x), RN.nextInt(y));
    }
}
