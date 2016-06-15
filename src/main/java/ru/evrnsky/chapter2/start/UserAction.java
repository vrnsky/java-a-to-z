package ru.evrnsky.chapter2.start;

/**
	Using for determine user actions
*/
public interface UserAction {
	
	/**
		Must return a number of operation
		@return - a number of operation
	*/
	int key();
	
	/**
		Execute action by calling methods from API Tracker
	*/
	void execute(IO io, Tracker tracker);
	
	/**
		Information about action for user
	*/
	String info();

}