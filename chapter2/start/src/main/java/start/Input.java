package start;

/**
	Input interface use for implement various of input
*/
public interface Input {
	
	/**
		Ask user for string data
		@param:String question - it is information for user
		@return:String - input data from user
	*/
	String ask(String question);
	
	int ask(String question, int from, int to);

	long askForLong(String question);
	
}