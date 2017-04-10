package repos;

import model.User;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 03.04.2017
 */
public class UserRepo extends CommonRepo<User> {

    /**
     * Self instance.
     */
    private static final UserRepo REPO = new UserRepo();

    /**
     * Init db wrapper.
     */
    private UserRepo() {
        super();
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
        return super.getAll(session -> {
            return session.createQuery("from model.User where email=:e and password=:p")
                    .setParameter("e", email)
                    .setParameter("p", password)
                    .list();
        }).get(0);
    }


}