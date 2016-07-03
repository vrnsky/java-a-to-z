package parity;

import start.IO;

/**
 * Implementation of parity checker
 */
public class ParityChecker {

	private IO io;

	/**
	 * Construct new parity checker by give it instance of io interface
	 * @param io - instance of io interface
     */
	public ParityChecker(IO io) {
		this.io = io;
	}

	/**
	 * Check that entered number odd or even
	 * And show result
	 */
	public void isEvenOrOdd() {
		int number = this.io.ask("Enter a number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

		if(number % 2 == 0)
			this.io.println("It is even");
		else if(number % 2 > 0)
			this.io.println("It is odd");
	}
}
