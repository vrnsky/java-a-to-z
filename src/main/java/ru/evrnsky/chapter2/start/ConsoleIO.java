package ru.evrnsky.chapter2.start;
import java.util.*;
import java.io.PrintStream;

/**
	This class acceptance data from console
*/
public class ConsoleIO implements IO {
	
	private Scanner scanner;
	private PrintStream out;
	
	/**
		Constructor for this class
		@param: scanner - instance of scanner for accept data from user
				out - PrintStream instance for show user info 
	*/
	public ConsoleIO(Scanner scanner, PrintStream out){
		this.scanner = scanner;
		this.out = out;
	}
	
	/**
		Show user console ask and return data from user
		@params: String question - it is string which show to user
		@return: String given from user
	*/
	public String ask(String question) {
		this.out.println(question);
		return scanner.nextLine();
	}
	
	/**
		Show string view of object
		@param:value - object for print
	*/
	public void println(Object value) {
		this.out.println(value);
	}
}