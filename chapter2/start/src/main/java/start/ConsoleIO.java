package start;
import java.util.*;
import java.io.PrintStream;

/**
	This class acceptance data from console
*/
public class ConsoleIO implements IO {
	

	private Scanner scanner = new Scanner(System.in);
	private PrintStream out = new PrintStream(System.out);
	
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
	   Ask user about int and ranged it
	   @param question - it is string which will show to user
	   @param from - low point to range
	          to - high point to range
      @return result of user input if correct input, otherwise throw exception
	  @throw: MenuOutException - it is exception which signal about user choose wrong menu options
     */
	public int ask(String question, int from, int to) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		if(key >= from && key <= to) {
			exist = true;
		}
		
		if(exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range");
		}
	}

	/**
		Ask user about long and return it
		@param:String question - it is String which will show to user
		@return: long result - it result of correct input
		@throw: exception which signal about wrong data,
		if user enter value smaller or bigger than Long.MAX_VALUE or Long.MIN_VALUE
	*/
	public long askForLong(String question) {
		long key =  Long.valueOf(this.ask(question));
		return key;
	}
	
	/**
		Show string view of object
		@param:value - object for print
	*/
	public void println(Object value) {
		this.out.println(value);
	}
}