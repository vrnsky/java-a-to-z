package start;

import model.Game;
import model.GameIO;
import ru.evrnsky.start.ConsoleIO;

/**
 * Start UI.
 */
public class StartUI {

    /**
     * Start program.
     * @param args keys.
     */
    public static void main(String[] args) {
        new ru.evrnsky.start.StartUI(new ConsoleIO()).init();
    }

    /**
     * Init before.
     * @param io instance of io implementation.
     */
    public void init(GameIO io) {
        new Game(io).start();
    }
}
