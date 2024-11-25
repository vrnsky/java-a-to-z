package exception;

/**
 * Dao exception represent exception occurred during data access.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DaoException extends RuntimeException {

    /**
     * Create a new dao exception.
     * @param message related to data access exception.
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Create a new dao exception.
     * @param message related to exception.
     * @param cause - the underlying exception.
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
