package models;

/**
	It is a extension of item class
	Have all public variable and public, protected methods
*/
public class Task extends Item
{
	/**
		Create a new task
		@param: String name - it is name of new task
		@param: String desc - it is description of new task
	*/
	public Task(String name, String desc)
	{
		super(name, desc);
	}
}