package database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */
public class DBManager {

    private static final DBManager DB_MANAGER = new DBManager();
    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private SessionFactory factory;

    private DBManager() {
    }

    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    public void init() {
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public void close() {
        factory.close();
    }

    public SessionFactory getFactory() {
        return factory;
    }


}

