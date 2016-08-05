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
     * @param sign
     */
    public Player(String sign) {
        this.sign = sign;
        this.wins = 0;
    }

    public String getSign() {
        return this.sign;
    }

    public void increaseWins() {
        wins++;
    }

    public int getWins() {
        return this.wins;
    }

    abstract boolean makeStep(Board board, int x, int y);

}
