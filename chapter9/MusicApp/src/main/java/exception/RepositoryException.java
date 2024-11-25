package exception;

/**
 * Runtime exception related to access data.
 * @version 1.0.0
 * @since 1.0.0
 */
public class RepositoryException extends RuntimeException {

    /**
     * Create a new repository exception.
     * @param message related to exception.
     */
    public RepositoryException(String message) {
        super(message);
    }
}
