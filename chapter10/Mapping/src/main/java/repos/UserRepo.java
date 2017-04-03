package repos;

import database.DBManager;
import model.User;
import org.hibernate.Session;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 03.04.2017
 */
public class UserRepo {

    private static final UserRepo REPO = new UserRepo();
    private DBManager dbManager;

    private UserRepo() {
        this.dbManager = DBManager.getInstance();
    }

    public static UserRepo getInstance() {
        return REPO;
    }

    public User getUserByCredits(String email, String password) {
        User user = null;
        String query = String.format("from model.User as u where u.email = %s and u.password = %s", email, password);
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        user = (User) session.createQuery(query).getSingleResult();
        return user;
    }
}