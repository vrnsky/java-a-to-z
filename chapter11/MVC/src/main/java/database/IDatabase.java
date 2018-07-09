package database;

import org.hibernate.SessionFactory;

/**
 * Database interface. By this interface we may use any implementation.
 * @author vrnsky.
 * @version 0.1.
 */
public interface IDatabase {

    /**
     * Return session factory from ORM.
     * @return session factory object from ORM.
     */
    SessionFactory getFactory();
}
