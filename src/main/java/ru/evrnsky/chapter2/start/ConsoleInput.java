package ru.evrnsky.chapter2.start;
import java.util.*;

/**
	This class acceptance data from console
*/
public class ConsoleInput implements Input {
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
		Show user console ask and return data from user
		@params: String question - it is string which show to user
		@return: String given from user
	*/
	public String ask(String question) {
	
		System.out.print(question);
		return scanner.nextLine();
	}
}