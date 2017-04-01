package parity;

import start.IO;

/**
 * Implementation of parity checker.
 * It check that given numbers is odd or even.
 */
public class ParityChecker {

	/**
	 * Instance of IO interface for accept data from user.
	 */
	private IO io;

	/**
	 * Construct new parity checker by give it instance of io interface.
	 * @param io - instance of io interface.
     */
	public ParityChecker(IO io) {
		this.io = io;
	}

	/**
	 * Check that entered number odd or even and show result to user.
	 */
	public void isEvenOrOdd() {
		int number = this.io.ask("Enter a number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (number % 2 == 0) {
			this.io.println("It is even");
		} else {
			this.io.println("It is odd");
		}
	}
}
