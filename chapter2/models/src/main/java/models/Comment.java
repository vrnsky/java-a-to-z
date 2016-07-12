package models;

/**
*	Model of a comment.
*/
public class Comment {

	/**
	 * Text of comment.
	 */
	private String text;
	
	/**
	*	Constructor for comment.
	*	@param text  it is text of comment.
	*/
	public Comment(String text)
	{
		this.text = text;
	}

	/**
	*	This method call when we need to print this object.
	*	@return string view of this object.
	*/
	@Override
	public String toString()
	{
		return String.format("Comment: %s", this.text);
	}
}