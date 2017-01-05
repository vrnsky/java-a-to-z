package start;

/**
 * Contract for all input handlers.
 */
public interface Input {

    /**
     * Ask something.
     * @param question info for user.
     * @return string from user.
     */
    String ask(String question);

    /**
     * Ask for int.
     * @param question info for user.
     * @param from     range.
     * @param to       range.
     * @return integer from user.
     */
    int ask(String question, int from, int to);

    /**
     * Ask for long from user.
     * @param question for user.
     * @return long number from user.
     */
    long askForLong(String question);

    /**
     * Ask about double from user.
     * @param question for user.
     * @return double which entered user.
     */
    double askForDouble(String question);
}
