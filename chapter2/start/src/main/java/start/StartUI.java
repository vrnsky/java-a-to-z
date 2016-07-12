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
	 * @param io instance of IO interface.
     */
	public StartUI(IO io) {
		this.io = io;
		tracker = new Tracker();
	}
	/**
	* Entry point of application
	*/
	public static void main(String[] args) {
		new StartUI(new Validator()).init();		
	}
	
	/**
	* At this method setup need variables.
	*/
	private void init() {
		MenuTracker menuTracker = new MenuTracker(this.io, this.tracker);
		menuTracker.fillActions();
		int start = menuTracker.getIdFirstCommand();
		int finish = menuTracker.getIdLastCommand();
		action(menuTracker, start, finish);
	}

	/**
	 * Ask user about data and interact with him.
	 * @param menuTracker wrapper for API Tracker.
	 * @param start first option of menu.
	 * @param finish last option of menu.
     */
	private void action(MenuTracker menuTracker, int start, int finish) {
		do {
			menuTracker.show();
			int key = io.ask("Type a command: ", start, finish);
			menuTracker.select(key);
		} while (!"y".equals(io.ask("Exit(y): ")));
	}
}