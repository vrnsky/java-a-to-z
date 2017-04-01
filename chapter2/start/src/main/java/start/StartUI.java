package start;

/**
 * At this class we start interact with user.
 */

public class StartUI {

    /**
     * Implementation of IO system.
     */
    private final IO io;

    /**
     * Instance of API Tracker for use it.
     */
    private final Tracker tracker;


    /**
     * Create a new by give it IO system.
     * @param instance instance of IO interface.
     */
    public StartUI(final IO instance) {
        this.io = instance;
        tracker = new Tracker();
    }

    /**
     * Entry point of application.
     * @param args key for app.
     */
    public static void main(final String[] args) {
        new StartUI(new Validator(new ConsoleIO())).init();
    }

    /**
     * At this method setup need variables.
     */
    public final void init() {
        MenuTracker menuTracker = new MenuTracker(this.io, this.tracker);
        menuTracker.fillActions();
        int start = menuTracker.getIdFirstCommand();
        int finish = menuTracker.getIdLastCommand();
        action(menuTracker, start, finish);
    }

    /**
     * Ask user about data and interact with him.
     * @param menuTracker wrapper for API Tracker.
     * @param start       first option of menu.
     * @param finish      last option of menu.
     */
    private void action(final MenuTracker menuTracker,
                        final int start, final int finish) {
        do {
            menuTracker.show();
            int key = io.ask("Type a command: ", start, finish);
            menuTracker.select(key);
        } while (!"y".equals(io.ask("Exit(y): ")));
    }
}
