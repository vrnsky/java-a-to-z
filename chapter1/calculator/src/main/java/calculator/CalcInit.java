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
		this.calculator = new Calculator();
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
		String answer = "";
		boolean reuse = false;
		double first, second;
		while(!"y".equals(answer)) {
			if(reuse) {
				first = calculator.getResult();
			} else {
				first = io.askForDouble("Enter a first number: ");
			}
			second = io.askForDouble("Enter a second number: ");
			String operand = io.ask("Type operand: ");
			calculator.calc(operand, first, second);
			this.io.println(String.format("%s %s %s = %s", first, operand, second, calculator.getResult()));
			reuse = this.io.ask("Reuse result in next? (y/n)?").equals("y");
			answer = this.io.ask("Exit? (y/n)");
		}
	}

}