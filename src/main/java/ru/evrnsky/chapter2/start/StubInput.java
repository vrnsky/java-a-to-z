package ru.evrnsky.chapter2.start;

/**
	It is stub for testing user input
*/
public class StubInput implements Input {
	
	private String[] answer;
	private int position = 0;
	
	/**
		Constructor for this class
		@params:String[] answer - it is list of possible answers
	*/
	public StubInput(String[] answer) {
		
		this.answer = answer;
	}
	
	/**
		Show user in the console question and return user input
		@params: String question - it is string which show user in console
		@retunr: String - given from user
	*/
	public String ask(String question)
	{
		return answer[position++];
	}
}