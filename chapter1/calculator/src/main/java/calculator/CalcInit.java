package calculator;

import start.IO;
import start.Validator;

import java.io.*;

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
		CalcInit calcInit = new CalcInit(new Validator());
		calcInit.start();
	}

	/**
	 * Main loop of program.
     */
	public void start() throws Exception {
		double second, first;
		String operand;
		String answer = "";

		while(!"y".equals(answer)) {
			first = Double.parseDouble(io.ask("Enter a first number: "));
			second = Double.parseDouble(io.ask("Enter a second number: "));
			operand = io.ask("Type operand: ");

			if(operand.equals("+")) calculator.add(first, second);
			else if (operand.equals("*")) calculator.multiply(first, second);
			else if (operand.equals("/")) calculator.div(first, second);
			else if (operand.equals("-")) calculator.deduct(first, second);
			
			io.println(String.format("Result: %s\n", calculator.getResult()));
			answer = io.ask("Exit? (y/n)");
		}
	}
	
}