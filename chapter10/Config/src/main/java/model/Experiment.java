package model;


import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * @author evrnsky
 * @version 0.1
 * @since 25.03.2017
 */
public class Experiment {

    public static void main(String[] args) {
        Item item = new Item();
        item.setDesc("Deployed with hibernate");
        item.setCreationTime(new Timestamp(System.currentTimeMillis()));
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
