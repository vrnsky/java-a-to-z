package database;

import org.hibernate.Session;

import java.util.List;

/**
 * @author evrnsky (vrnsky at protonmail.ch)
 * @version 0.1.
 * @since 10.04.2017
 *
 * This class return all entity for specified class.
 * @param <T> describe which class may stored.
 *
 */
@FunctionalInterface
public interface AllEntity<T> {

    /**
     * Return list of all, also may be filtered if it needed.
     * @param session instance of hibernate session.
     * @return list of objects.
     */
    List<T> getAll(Session session);
}
