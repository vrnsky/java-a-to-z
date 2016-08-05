package model;

/**
 * Implementation of human player.
 */
public class Human extends Player {

    /**
     * Create a new player.
     * @param sign of this player.
     */
    public Human(String sign) {
        super(sign);
    }

    /**
     * Try to perform step.
     * @param board instance of board class.
     * @param x position at the board x.
     * @param y position at the board y.
     * @return true if step successfully executed, otherwise false.
     */
    public boolean makeStep(Board board, int x, int y) {
        return board.performStep(this, x, y);
    }
}
