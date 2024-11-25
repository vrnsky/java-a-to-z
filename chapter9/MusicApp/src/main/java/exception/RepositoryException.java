package exception;

import java.io.Serial;

/**
 * Runtime exception related to access data.
 * @version 1.0.0
 * @since 1.0.0
 */
public class RepositoryException extends RuntimeException {

    /**
     * Identifier of serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Create a new repository exception.
     * @param message related to exception.
     */
    public RepositoryException(String message) {
        super(message);
    }

    /**
     * Create a new repository exception.
     * @param message related to exception
     * @param cause underlying exception.
     */
    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
