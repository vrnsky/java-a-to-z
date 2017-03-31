package database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 29.03.2017
 *
 * This class is wrapper for work with database.
 */
public class DBManager {

    /**
     * It is self instance, singleton.
     */
    private static final DBManager DB_MANAGER = new DBManager();

    /**
     * Configuration builder for hibernate.
     */
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();

    /**
     * Session factory, it is producer for session.
     */
    private SessionFactory factory;

    /**
     * Default constructor.
     */
    private DBManager() {
    }

    /**
     * Return it.
     * @return it.
     */
    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    /**
     * Calls when servlet context created, you do not need call this method.
     */
    public void init() {
        factory = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    }

    /**
     * Calls when servlet context destroyed, you do not need call this method.
     */
    public void close() {
        factory.close();
    }

    /**
     * Return session factory.
     * @return session factory.
     */
    public SessionFactory getFactory() {
        return factory;
    }


}

