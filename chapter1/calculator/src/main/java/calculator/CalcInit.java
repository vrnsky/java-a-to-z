package calculator;

import start.ConsoleIO;
import start.IO;
import start.Validator;

/**
 * It class interact with user by accept data,
 * call API of calculator and show to user result.
 */
public class CalcInit {

	/**
	 * Handle input from user and show data for user.
	 */
	private final IO io;

	/**
	 * Instance of Calculator API.
	 */
	private final Calculator calculator;

	/**
	 * Save a reference to io object.
	 * @param inOut instance of io interface.
     */
	public CalcInit(IO inOut) {
		this.io = inOut;
		calculator = new Calculator();
	}
	/**
	 * Entry point of application.
	 * @param args - key and values from start.
	 * @throws Exception throw if reader from console fail.
     */
	public static void main(String[] args) throws Exception {
		new CalcInit(new Validator(new ConsoleIO())).start();
	}

	/**
	 * Main loop of program.
	 * @throws Exception if something wrong.
	 */
	public void start() throws Exception {
		final int actions = 8;
		MenuCalculator menuCalculator = new MenuSciCalculator(this.calculator, this.io, actions);
		menuCalculator.fillActions();
		int start = menuCalculator.getIdFirstCommand();
		int finish = menuCalculator.getIdLastCommand();

		do {
			menuCalculator.showMenu();
			menuCalculator.select(this.io.ask("Choose an option: ", start, finish));
		} while (!"y".equals(this.io.ask("Exit? y/n")));
	}

}