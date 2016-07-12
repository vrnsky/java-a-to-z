package start;

/**
* It is stub for testing user input/output.
*/
public class StubIO implements IO {

	/**
	 * List of possible input from user.
	 */
	private String[] answer;

	/**
	 * For correct move across answer array.
	 */
	private int position = 0;

	/**
	 * For collect data which produce application.
	 */
	private StringBuffer buffer;
	
	/**
	* Constructor for this class
	* @param answer list of possible answers
	*/
	public StubIO(String[] answer) {
		this.answer = answer;
		this.buffer = new StringBuffer();
	}
	
	/**
	* Show user question and return user input.
	* @param question string which show user.
	* @return string given from user.
	*/
	public String ask(String question) {
		return answer[position++];
	}
	
	/**
	* Ask user about int and check number for range.
	* @param question question which show user.
	* @param from  start for range.
	* @param to finish for range.
	* @return number which exist between from and to.
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
	* Ask user about long and return it.
	* @param question show to user.
	* @return result of correct input.
	*/
	public long askForLong(String question) {
		return Long.valueOf(this.ask(question));
	}

	/**
	 * Ask user about double and return it.
	 * @param question - info for user.
	 * @return double which get from user.
     */
	public double askForDouble(String question) { return  Double.valueOf(this.ask(question));}
	
	/**
	* Append to buffer value and move to new line.
	* @param value object for append.
	*/
	public void println(Object value) {
		this.buffer.append(value + "\n");
	}
	
	/**
	* Return a buffer data.
	* @return all data from buffer
	*/
	public String getOut() {
		return buffer.toString();
	}


}