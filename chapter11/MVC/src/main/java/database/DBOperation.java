package database;

import org.hibernate.Session;

import java.sql.ResultSet;

/**
 * New inteface fot reduce duplicate code.
 */
@FunctionalInterface
public interface DBOperation {

    /**
     * Execute some operations with session.
     * @param session instance of ORM session.
     * @return result of execution.
     */
    ResultSet execute(Session session);
}
