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
	
	/**
		This method must determine how to execute action in sub classes
		@param:IO io - it is intance of any class which implement IO interface
		@param:Tracker tracker - it is instance of Tracker API
	*/
	abstract public void execute(IO io, Tracker tracker);
	
	/**
		This method must determine how key contains actions
		It uses for identificate action
		@return:int - it is key for choose action in menu
	*/
	abstract public int key();
	
	/**
		Return info about action, inclue key and name
		@return:String - it is key and name of action
	*/
	public String info() {
		return String.format("%s. %s", this.key(), this.name);
	}
}