package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 *
 * Wrapper for work with database accross hibernate orm.
 */
public class DBManager {

    /**
     * Self instance, it is singleton.
     */
    private static final DBManager DB_MANAGER = new DBManager();

    /**
     * Configuration of hibernate.
     */
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();

    /**
     * Factory of session.
     */
    private SessionFactory factory;

    /**
     * Default constructor.
     */
    private DBManager() {
    }

    /**
     * Return self.
     * @return self instance.
     */
    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    /**
     * Return session factory, which needs for create session.
     * @return session factory object.
     */
    private SessionFactory getFactory() {
        return this.factory;
    }

    /**
     * This method calls at the time when context is init.
     * You do not need call this method in client code.
     * It call automatically by container.
     * Init session factory object.
     */
    public void buildSessionFactory() {
        this.factory = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    }

    /**
     * This method calls at the when context is destroy.
     * You don not need call this method in client code.
     * It call automatically by container.
     * Close session factory.
     */
    public void closeSessionFactory() {
        this.factory.close();
    }

    /**
     * Open new session if current is not exist, otherwise return current session.
     * @return hibernate session.
     */
    public Session getSession() {
        return this.getFactory().openSession();
    }

}
