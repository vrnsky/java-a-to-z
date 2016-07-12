package start;

/**
* At this class we start interact with user.
*/

public class StartUI {

	/**
	 * Implementation of IO system.
	 */
	private IO io;

	/**
	 * Instance of API Tracker for use it.
	 */
	private Tracker tracker;

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
	* At this method user choose command and app execute it.
	*/
	public void init() {
		MenuTracker menuTracker = new MenuTracker(this.io, this.tracker);
		menuTracker.fillActions();
		int start = menuTracker.getIdFirstCommand();
		int finish = menuTracker.getIdLastCommand();
		
		do {
			menuTracker.show();
			int key = io.ask("Type a command: ", start, finish);
			menuTracker.select(key);
		} while (!"y".equals(io.ask("Exit(y): ")));
	}
}