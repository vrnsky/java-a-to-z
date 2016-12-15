package cache;

/**
 * @author evrnsky
 * @version 0.1
 * @since 29.11.2016
 * Instance of exception which thrown when something was wrong with version.
 */
public class OptimisticException extends RuntimeException {

    /**
     * Create a new exception.
     * @param message detailed info about exception.
     */
    public OptimisticException(String message) {
        super(message);
    }
}
