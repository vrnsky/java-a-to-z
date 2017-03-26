package database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 */
public class DBManager {

    private static final DBManager DB_MANAGER = new DBManager();
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();
    private SessionFactory factory;

    private DBManager() {
    }

    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    public SessionFactory getFactory() {
        return this.factory;
    }

    public void buildSessionFactory() {
        this.factory = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    }

    public void closeSessionFactory() {
        this.factory.close();
    }

}
