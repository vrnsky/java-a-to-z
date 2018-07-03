package beans;
import interfaces.Helper;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

/**
 * Implementation of helper interfaces which allow to use hibernate.
 * @author vrnsky.
 * @version 1.0
 */
@Component
public class HibernateHelper implements Helper {

    /**
     * Configuration builder for hibernate.
     */
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();

    /**
     * Session factory, it is producer for session.
     */
    private SessionFactory factory;


    /**
     * Create a new hibernate helper.
     */
    public HibernateHelper() {
        this.init();
    }
    /**
     * Calls when servlet context created, you do not need call this method.
     */
    private void init() {
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
