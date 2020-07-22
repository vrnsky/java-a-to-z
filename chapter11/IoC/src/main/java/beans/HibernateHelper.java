package beans;

import interfaces.Helper;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/**
 * Implementation of helper interfaces which allow to use hibernate.
 * @author vrnsky.
 * @version 1.0
 */
@Component
public class HibernateHelper implements Helper {

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
        Configuration configuration = new Configuration().configure();
        configuration.addClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(builder.build());
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
