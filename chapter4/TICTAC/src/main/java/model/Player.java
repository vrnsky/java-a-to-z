package model;

/**
 * Abstraction for gamers.
 */
public abstract class Player {

    /**
     * Sign of user.
     */
    private String sign;

    /**
     * Count of wins.
     */
    private int wins;

    /**
     * Create a new player with given sign.
     * @param sign x or o.
     */
    public Player(String sign) {
        this.sign = sign;
        this.wins = 0;
    }

    /**
     * Get sign of user.
     * @return sign of user.
     */
    public String getSign() {
        return this.sign;
    }

    /**
     * Increase wins of user.
     */
    public void increaseWins() {
        wins++;
    }

    /**
     * Return wins of user.
     * @return wins of user.
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Make step.
     * @param board instance of board.
     * @param x new position.
     * @param y new position.
     * @return true if made.
     */
    abstract boolean makeStep(Board board, int x, int y);

}
