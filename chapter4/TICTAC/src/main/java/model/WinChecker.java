package model;

/**
 * Object which check that some player win the game.
 */
public class WinChecker {

    /**
     * Return true if player is win at the various path otherwise false.
     * @param player instance of player interface.
     * @param board instance of board.
     * @return true if player is win at the various path otherwise false.
     */
    public boolean isWinner(Player player, Board board) {
        return this.checkHorizontal(player, board) || this.checkVertical(player, board) ||
                this.checkDiagonal(player, board) || this.checkOtherDiagonal(player, board);
    }

    /**
     * Check horizontal path of board.
     * @param player instance of player interface.
     * @param board instance of board.
     * @return true if player win by the horizontal path.
     */
    private boolean checkHorizontal(Player player, Board board) {
        int index = 0;
        int sign = 0;
        for(int barrier = 0; barrier < board.getHeight(); barrier++) {
            if(index == board.getWidth() - 1) { index = 0;}
            if(board.showBoard()[barrier][index].equals(player.getSign())) {
                sign++;
                index++;
            }
        }
        return sign == board.getWidth();
    }

    /**
     * Check vertical path of board.
     * @param player instance of player interface.
     * @param board instance of board class.
     * @return true if player win by the vertical path.
     */
    private boolean checkVertical(Player player, Board board) {
        int index = 0;
        int sign = 0;
        for(int barrier = 0; barrier < board.getWidth(); barrier++) {
            if(index == board.getWidth() - 1) { index = 0; }
            if(board.showBoard()[index][barrier].equals(player.getSign())) {
                sign++;
            }
        }

        return sign == board.getWidth();
    }

    /**
     * Check by diagonal.
     * @param player instance of player interface.
     * @param board instance of board class.
     * @return true if player is win by the diagonal path.
     */
    private boolean checkDiagonal(Player player, Board board) {
        int sign = 0;
        int xEnd = board.getWidth() - 1;
        int yEnd = board.getHeight() - 1;
        while(xEnd >= 0 && yEnd >= 0) {
            if(board.showBoard()[xEnd][yEnd].equals(player.getSign())) {
                sign++;
            }
            xEnd--;
            yEnd--;
        }
        return sign == board.getWidth();
    }

    /**
     * Check the other diagonal because at the quad two diagonal.
     * @param player instance of board interface.
     * @param board instance of board class.
     * @return true if player is win by the diagonal, otherwise false.
     */
    private boolean checkOtherDiagonal(Player player, Board board) {
        int xStart = board.getWidth() - 1;
        int yStart = 0;
        int signTwo = 0;
        while(xStart > 0 && yStart < board.getHeight()-1) {
            if(board.showBoard()[xStart][yStart].equals(player.getSign())) {
                signTwo++;
            }
            xStart--;
            yStart++;
        }
       return signTwo == board.getHeight();
    }
}
