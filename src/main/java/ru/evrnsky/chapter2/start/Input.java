package ru.evrnsky.chapter2.start;

/**
	Input interface use for implement various of input
*/
public interface Input {
	
	/**
		Ask user for any data
		@param:String question - it is information for user
		@return:String - input data from user
	*/
	String ask(String question);
}