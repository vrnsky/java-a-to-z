package ru.evrnsky.start;

/**
 * RuntimeException for signal of error to user.
 * Throw this if user choose wrong command.
 */
public class MenuOutException extends RuntimeException {

    /**
     * Constructor for exception.
     * @param msg message for user.
     */
    public MenuOutException(final String msg) {
        super(msg);
    }
}
