package calculator;

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
	private IO io;

	/**
	 * Instance of Calculator API.
	 */
	private Calculator calculator;

	/**
	 * Save a reference to io object.
	 * @param io instance of io interface.
     */
	public CalcInit(IO io) {
		this.io = io;
		calculator = new Calculator();
	}
	/**
	 * Entry point of application.
	 * @param args - key and values from start.
	 * @throws Exception throw if reader from console fail.
     */
	public static void main(String[] args) throws Exception {
		new CalcInit(new Validator()).start();
	}

	/**
	 * Main loop of program.
	 * It allow user input data and get result from calculator.
     */
	public void start() throws Exception {
		MenuCalculator menuCalculator = new MenuSciCalculator(this.calculator, this.io, 8);
		menuCalculator.fillActions();
		int start = menuCalculator.getIdFirstCommand();
		int finish = menuCalculator.getIdLastCommand();

		do {
			menuCalculator.showMenu();
			menuCalculator.select(this.io.ask("Choose an option: ", start, finish));
		} while(!"y".equals(this.io.ask("Exit? y/n")));
	}

}