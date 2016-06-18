package ru.evrnsky.chapter2.start;

/**
	It is stub for testing user input/output
*/
public class StubIO implements IO {
	
	private String[] answer;
	private int position = 0;
	private StringBuffer buffer;
	
	/**
		Constructor for this class
		@params:String[] answer - it is list of possible answers
	*/
	public StubIO(String[] answer) {
		this.answer = answer;
		this.buffer = new StringBuffer();
	}
	
	/**
		Show user in the console question and return user input
		@params: String question - it is string which show user in console
		@return: String - given from user
	*/
	public String ask(String question) {
		return answer[position++];
	}
	
	/**
		Ask user about int and check number for range
		@param:String question - it is question which show user
			   int from - it is start for range
			   int to - it is finish for range
		@return: int - it is number which exist between from and to
		@throw: exception if user choose wrong command
	*/
	public int ask(String question, int from, int to) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		if(key >= from && key <= to) 
			exist = true;
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
		@throw: exception which signal about wron data,
		if user enter value smaller or bigger than Long.MAX_VALUE or Long.MIN_VALUE
	*/
	public long askForLong(String question) {
		long key = Long.valueOf(this.ask(question));
		boolean exist = false;
		if(key > Long.MIN_VALUE && key < Long.MAX_VALUE)
			exist = true;
		if(exist) {
			return key;
		} else {
			throw new OutOfTimeException("Out of time range");
		}
	}
	
	/**
		Append to buffer value and move to new line
		@param: Object value - it is object for append
	*/
	public void println(Object value) {
		this.buffer.append(value + "\n");
	}
	
	/**
		Return a buffer data
		@param: String - it is all data from buffer
	*/
	public String getOut() {
		return buffer.toString();
	}
}