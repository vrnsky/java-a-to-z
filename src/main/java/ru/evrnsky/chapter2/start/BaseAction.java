package ru.evrnsky.chapter2.start;

/**
	It is common implementation of action 
	@since: 23.06.2016
*/
public abstract class BaseAction implements UserAction {
	
	private String name;
	
	/**
		Create a new action and set name to the this name variable
		@param: String name - it is name of action
	*/
	public BaseAction(String name) {
		this.name = name;
	}
	
	//Must override in subclasses
	public abstract void execute(IO io, Tracker tracker);
	//Must override in subclass
	public abstract int key();
	
	/**
		Return info about action, inclue key and name
		@return:String - it is key and name of action
	*/
	public String info() {
		return String.format("%s. %s", this.key(), this.name);
	}
}