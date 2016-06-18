package ru.evrnsky.chapter2.start;

/**
	RuntimeException for signal of error to user
	Throw this if user choose wrong command
*/
public class MenuOutException extends RuntimeException {

	/**
		Constructor for exception
		@param: String msg - it is message for user
	*/
	public MenuOutException(String msg) {
		super(msg);
	}
}