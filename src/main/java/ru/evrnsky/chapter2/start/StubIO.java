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
		@retunr: String - given from user
	*/
	public String ask(String question) {
		return answer[position++];
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