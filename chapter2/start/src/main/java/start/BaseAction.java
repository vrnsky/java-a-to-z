package start;


import start.UserAction;

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
		Return info about action, inclue key and name
		@return:String - it is key and name of action
	*/
	public String info() {
		return String.format("%s. %s", this.key(), this.name);
	}
}