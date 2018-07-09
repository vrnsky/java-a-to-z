package database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

/**
 * Database helper which create a session factory object.
 * @author vrnsky.
 * @version 0.1.
 */
@Component
public class HibernateDatabaseImpl implements IDatabase {

    /**
     * Create a new registry object for build session factory.
     */
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();

    /**
     * Allow to close and open sessions for interact with database.
     */
    private SessionFactory factory;

    /**
     * Create a new implementation of this class.
     */
    public HibernateDatabaseImpl() {
        this.init();
    }

    /**
     * Init factory for starting work with database.
     */
    private void init() {
        this.factory = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    }

    /**
     * Return current session factory.
     * @return session factory object.
     */
    public SessionFactory getFactory() {
        return this.factory;
    }

    /**
     * Close session factory.
     */
    public void close() {
        if (this.factory != null) {
            this.factory.close();
        }
    }
}
