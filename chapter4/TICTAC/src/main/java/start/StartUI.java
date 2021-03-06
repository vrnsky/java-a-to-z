package start;

import model.Game;
import model.GameIO;

/**
 * Start UI.
 */
public class StartUI {

    /**
     * Start program.
     * @param args keys.
     */
    public static void main(String[] args) {
        new StartUI().init(new GameIO(new ConsoleIO()));
    }

    /**
     * Init before.
     * @param io instance of io implementation.
     */
    public void init(GameIO io) {
        new Game(io).start();
    }
}
