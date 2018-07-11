package dao;

import database.IDatabase;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * This user repository which allow add and get user.
 * @author vrnsky.
 * @version 0.1.
 */
@Repository
public class UserRepository {

    /**
     * Instance of database helper.
     */
    private IDatabase database;

    /**
     * Create a new user repo with given database helper implementation.
     * @param database any implementation of IDatabase interface.
     */
    @Autowired
    public UserRepository(IDatabase database) {
        this.database = database;
    }

    /**
     * Getting user from database if it exist on it, otherwise return null.
     * @param email of user.
     * @param password of user.
     * @return user if it exist at the database, otherwise false.
     */
    public User getUser(String email, String password) {
        User user = null;
        Session session = this.database.getFactory().openSession();
        session.beginTransaction();
        String hql = "from User u where u.email = :email and password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> results = query.getResultList();
        if (!results.isEmpty()) {
            user = results.get(0);
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }


    /**
     * Adding new user to application.
     * @param user instance of user class.
     */
    public void add(User user) {
        Session factory = this.database.getFactory().openSession();
        factory.beginTransaction();
        factory.save(user);
        factory.getTransaction().commit();
        factory.close();

    }


}
