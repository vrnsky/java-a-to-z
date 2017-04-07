package repos;

import database.DBManager;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 03.04.2017
 */
public class UserRepo {

    /**
     * Self instance.
     */
    private static final UserRepo REPO = new UserRepo();

    /**
     * Wrapper for database.
     */
    private DBManager dbManager;

    /**
     * Init db wrapper.
     */
    private UserRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return itself.
     * @return itself.
     */
    public static UserRepo getInstance() {
        return REPO;
    }

    /**
     * Return user by email and password.
     * @param email of user.
     * @param password of user.
     * @return user if exist, otherwise false.
     */
    public User getUserByCredits(String email, String password) {
        User user = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from model.User where email=:e and password=:p");
        query.setParameter("e", email);
        query.setParameter("p", password);
        user = (User) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}