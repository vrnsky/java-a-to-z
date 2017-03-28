package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 *
 * Simple checking that annotations works.
 */
public class Demo {

    /**
     * Entry point of application.
     * @param args key for app.
     */
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        final SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Item item = null;
        Session session = factory.openSession();
        session.beginTransaction();
        item = session.get(Item.class, 1);
        session.getTransaction().commit();
        session.close();
        factory.close();

        for (Comment comment : item.getComments()) {
            System.out.println(comment);
        }
    }
}
