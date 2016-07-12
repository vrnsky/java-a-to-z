package start;

/**
 * Contract for all input handlers.
 */
public interface Input {

	String ask(String question);
	
	int ask(String question, int from, int to);

	long askForLong(String question);

	double askForDouble(String question);
	
}