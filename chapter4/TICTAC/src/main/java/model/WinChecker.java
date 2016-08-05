package model;

/**
 * Created by Egor on 05.08.2016.
 */
public class WinChecker {

    public boolean isWinner(Player player, Board board) {
        return this.checkHorizontal(player, board) || this.checkVertical(player, board) ||
                this.checkDiagonal(player, board) || this.checkBackDiagonal(player, board);
    }

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

    private boolean checkDiagonal(Player player, Board board) {
        int sign = 0;
        for(int x = 0; x < board.getWidth(); x++) {
            for(int y = 0; y < board.getHeight(); y++) {
                if(board.showBoard()[x][y].equals(player.getSign())) {
                    sign++;
                }
            }
        }

        return sign == board.getWidth();
    }

    private boolean checkBackDiagonal(Player player, Board board) {
        int sign = 0;
        for(int x = board.getWidth() - 1; x <= 0; x--) {
            for(int y = board.getHeight() - 2; y <= 0; y--) {
                if(board.showBoard()[x][y].equals(player.getSign())) {
                    sign++;
                }
            }
        }
        return sign == board.getWidth();
    }


}
