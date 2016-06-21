package ru.evrnsky.chapter2.start;

public class Validator extends ConsoleIO  {
	
	/**
		Ask user about int and return it
		@param:String question - it is String which will show to user
			   int to - it high point to range
			   int from - it is low point to range
		@return: int result - it result of correct input
	*/
	public int ask(String question, int from, int to) {
		int number = -1;
		boolean invalid = true;
		do {
			try {
				number = Integer.valueOf(super.ask(question));
				if(number >= from && number <= to)
						invalid = false;
				}
			catch(NumberFormatException nfe) {
				super.println("Dear user, please type a number");
			}
			catch (MenuOutException moe) {
				super.println("Dear user, please choose correct options of menu");
			}
		} while (invalid);
		
		return number;
	}

	/**
		Ask user about long and return it
		@param:String question - it is String which will show to user
		@return: long result - it result of correct input
	*/
	public long askForLong(String question) {
		long result = -1;
		boolean invalid = true;
		do {
			try {
				result = super.askForLong(question);
				invalid = false;
			}
			catch(NumberFormatException nfe) {
				super.println("Dear user, please type a number");
			}
		} while(invalid);
		return result;
	}
}