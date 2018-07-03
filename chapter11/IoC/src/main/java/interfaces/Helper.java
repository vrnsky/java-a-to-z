package interfaces;

import org.hibernate.SessionFactory;

/**
 * Interface for database helpers. It allow us use any ORM implementation.
 * @author vrnsky.
 * @version 1.0
 */
public interface Helper {

    /**
     * Return session factory.
     * @return implementation of session factory interface.
     */
    SessionFactory getFactory();
}
