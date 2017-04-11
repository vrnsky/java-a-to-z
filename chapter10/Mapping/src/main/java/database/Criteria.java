package database;

import org.hibernate.Session;

import java.util.List;

/**
 * Interface for lambda expression.
 * @param <T> speficy which class may stored.
 */
@FunctionalInterface
public interface Criteria<T> {

    /**
     * Return data selected by criteria.
     * @param session instance of hibernate session.
     * @return list of object.s
     */
    List<T> getByCriteria(Session session);
}
