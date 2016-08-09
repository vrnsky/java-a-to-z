package model;

/**
 * It is special object which describes that in game no one player is not win.
 */
public class NoOnePlayer extends Player {

    /**
     * Create a new player.
     * @param sign for this user.
     */
    public NoOnePlayer(String sign) {
        super(sign);
    }

    /**
     * Return sign of this player.
     * @return special sign for this user.
     */
    @Override
    public String getSign() {
        return super.getSign();
    }

    /**
     * Handler.
     */
    @Override
    public void increaseWins() {
    }

    /**
     * This player not may have win.
     * @return
     */
    @Override
    public int getWins() {
        return super.getWins();
    }

    /**
     * This object not make step.
     * @param board instance of board.
     * @param x position.
     * @param y position.
     * @return always false.
     *
     */
    @Override
    boolean makeStep(Board board, int x, int y) {
        return false;
    }
}
