package start;

/**
*	It is common implementation of action.
*/
public abstract class BaseAction implements UserAction {
	
	private String name;
	
	/**
	* Create a new action and set name to the this name variable.
	* @param  name  it is name of action.
	*/
	public BaseAction(String name) {
		this.name = name;
	}
	
	/**
	*	Return info about action, include key and name.
	*	@return key and name of action.
	*/
	public String info() {
		return String.format("%s. %s", this.key(), this.name);
	}
}