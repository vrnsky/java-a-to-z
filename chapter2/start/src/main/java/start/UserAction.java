package start;

/**
* Using for determine user actions. Contract for all user actions.
*/
public interface UserAction {
	int key();
	void execute(IO io, Tracker tracker);
	String info();
}