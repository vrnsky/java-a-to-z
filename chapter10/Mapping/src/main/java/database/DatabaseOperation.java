package database;

import org.hibernate.Session;

/**
 * @author evrnsky (vrnsky at protonmail.ch)
 * @version 0.1.
 * @since 10.04.2017
 *
 * This interface marked as functional interface for use it as lambda.
 * @param <T> specify which class may store this interface.
 */
@FunctionalInterface
public interface DatabaseOperation<T> {

    /**
     * Execute some database operations.
     * @param session instance of hibernate session.
     * @param value object for add or edit.
     */
    void execute(Session session, T value);
}
