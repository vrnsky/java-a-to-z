package ru.evrnsky.chapter2.models;

/**
	Model of a comment 
*/
public class Comment
{
	private String text;
	
	/**
		Constructor for comment
		@param: text - it is text of comment
	*/
	public Comment(String text)
	{
		this.text = text;
	}
	
	/**
		If you want updated comment use this method. This method set text in given text
		@param: text - it new text of comment
	*/
	public void setText(String text)
	{
		this.text = text;
	}
	
	/**
		Return a text of comment
		@return: String - text of comment
	*/
	public String getText()
	{
		return this.text;
	}
	
	/**
		This method call when we need to print this object
		@return: String view of this object
	*/
	@Override
	public String toString()
	{
		return String.format("Comment: %s", this.text);
	}
}