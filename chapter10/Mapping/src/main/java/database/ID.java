package database;

import org.hibernate.Session;

/**
 * @author evrnsky (vrnsky at protonmail.ch)
 * @version 0.1.
 * @since 10.04.2017
 *
 * This interface marked as functional interface for using it as lambda.
 * @param <T> specify which class may give.
 */
@FunctionalInterface
public interface ID<T> {

    /**
     * Return some object from database with given id.
     * @param session instance of hibernate session.
     * @return object with given id.
     */
    T getById(Session session);
}
