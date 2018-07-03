package beans;

import interfaces.Helper;
import interfaces.Storage;
import model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This spring component allow to use jdbc storage in other beans.
 * Work as CRUD repository for users.
 * @author vrnsky.
 * @version 1.0
 */
@Component
public class JdbcStorage implements Storage {

    /**
     * Any implementation of ORM machine.
     */
    private Helper dbHelper;

    /**
     * Create a new instance of this.
     * @param helper any implementation of helper interface.
     */
    @Autowired
    public JdbcStorage(Helper helper) {
        this.dbHelper = helper;
    }

    /**
     * Add new user to the system.
     * @param user instance of user class.
     */
    @Override
    public void add(User user) {
        Session session = this.dbHelper.getFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return user if it exist at the storage, otherwise return null.
     * @param id unique per user number.
     * @return user instance if object exist at the storage, otherwise return false.
     */
    @Override
    public User get(int id) {
        User user = null; //May be should use Optional(see @JDK8)
        Session session = this.dbHelper.getFactory().openSession();
        session.beginTransaction();
        user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    /**
     * Remove object from storage.
     * @param id unique per user number.
     */
    @Override
    public void remove(int id) {
        Session session = this.dbHelper.getFactory().openSession();
        session.beginTransaction();
        session.remove(this.get(id));
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Update user at the storage.
     * @param user new version of updatable user.
     */
    @Override
    public void update(User user) {
        Session session = this.dbHelper.getFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
}
