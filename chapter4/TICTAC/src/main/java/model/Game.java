package model;

/**
 * Main class of game structure.
 */
public class Game {

    /**
     * game input and output system.
     */
    private GameIO io;
    /**
     * Player famous as human.
     */
    private Player human;

    /**
     * Instance of primitive ai.
     */
    private Player computer;

    /**
     * Flag which determine may computer make step first.
     */
    private boolean computerFirst;

    /**
     * Count of round.
     */
    private int rounds;

    /**
     * Board of tictactoe.
     */
    private Board board;

    /**
     * Check that at the game exist winner.
     */
    private WinChecker winChecker;

    /**
     * Create a new game.
     * @param io special io.
     */
    public Game(GameIO io) {
        this.io = io;
        winChecker = new WinChecker();
    }


    /**
     * Main loop of game.
     */
    public void start() {
        this.prepare();
        do {
            this.showBoard();
            if(computerFirst) {
                computer.makeStep(board, board.getWidth(), board.getHeight());
                this.userMakeStep();
            } else {
                this.userMakeStep();
                computer.makeStep(board, board.getWidth(), board.getHeight());
            }
        } while (this.getWinner() == null && human.getWins() != rounds && computer.getWins() != rounds);

        this.getWinner().increaseWins();
    }

    /**
     * Before start game must prepared all components.
     */
    private void prepare() {
        this.prepareBoard();
        this.prepareRounds();
        this.askAboutFirstStep();
        this.prepareGamers();

    }

    /**
     * Show board at the io system.
     */
    private void showBoard() {
        String[][] state = board.showBoard();
        for(int index = 0; index < board.getWidth(); index++) {
            for(int barrier = 0; barrier < board.getHeight(); barrier++) {
                this.io.print(state[index][barrier] + " ");
            }
            this.io.println("");
        }
    }

    /**
     * Ask user about size of board.
     */
    private void prepareBoard() {
        boolean changeSize = this.io.ask("Do you want to change size of board(by default 3 x 3) ? (y/n)").equals("y");
        if(changeSize) {
            int width = io.ask("Enter a width of board:", 0, Integer.MAX_VALUE);
            int height = io.ask("Enter a height of board:", 0, Integer.MAX_VALUE);
            this.board = new Board(width, height);
        } else {
            this.board = new Board();
        }
    }

    /**
     * Ask user about who is first.
     */
    private void askAboutFirstStep() {
        this.computerFirst = io.ask("Would you want that computer start game first ? (y/n)").equals("y");
    }

    /**
     * Create an instances of gamers.
     */
    private void prepareGamers() {
        human = new Human(this.io.ask("Enter a sign for user: ").toUpperCase() );
        computer = new AI(human.getSign().equals("X") ? "O" : "X");
    }

    /**
     * Calculate rounds.
     */
    private void prepareRounds() {
        boolean manyRounds = this.io.ask("Would you want to change count of rounds ? (y/n) ").equals("y");
        if(manyRounds) {
            this.rounds = io.ask("Enter of rounds: ", 0, Integer.MAX_VALUE);
        } else {
            this.rounds = 1;
        }

    }

    /**
     * Find and return winner of the current game.
     * @return
     */
    private Player getWinner() {
        Player winner = null;
        if(winChecker.isWinner(human, board)) {
            winner = human;
        } else if (winChecker.isWinner(computer, board)) {
            winner = computer;
        }
        return winner;
    }

    /**
     * User make step.
     */
    private void userMakeStep() {
        int x = this.io.ask("Enter a X position: ", 0, board.getWidth());
        int y = this.io.ask("Enter a Y position: ", 0, board.getHeight());
        human.makeStep(board, x, y);
    }
}


