package repos;

import database.DBManager;
import database.Criteria;
import database.DatabaseOperation;
import database.AllEntity;
import database.ID;
import org.hibernate.Session;
import java.util.List;

/**
 * @author evrnsky (vrnsky at protonmail.ch)
 * @version 0.1.
 * @since 10.04.2017
 *
 * This is common repository, it provide session management.
 * @param <T> specify which class may be operational.
 */
public abstract class CommonRepo<T> {

    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    public CommonRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Execute some db operations which describe in child in lambda.
     * @param db operation with database.
     * @param value for add or remove from database.
     */
    @SuppressWarnings("unchecked")
    public void execute(DatabaseOperation db, T value) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        db.execute(session, value);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return object with given id.
     * @param operation lambda which describe how to get object.
     * @return object with given id.
     */
    @SuppressWarnings("unchecked")
    public T getById(ID operation) {
        T value = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        value = (T) operation.getById(session);
        session.getTransaction().commit();
        session.close();
        return value;
    }

    /**
     * Return list of entities.
     * @param allEntity describe how to get and also may filter entity.
     * @return list of objects.
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll(AllEntity allEntity) {
        List<T> values = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        values = (List<T>) allEntity.getAll(session);
        session.getTransaction().commit();
        session.close();
        return values;
    }

    /**
     * Return list of adverts with specific data.
     * @param criteria functional interface, in child lambda expressions.
     * @return list of adverts.
     */
    @SuppressWarnings("unchecked")
    public List<T> getByCriteria(Criteria criteria) {
        List<T> values = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        values = (List<T>) criteria.getByCriteria(session);
        session.getTransaction().commit();
        session.close();
        return values;
    }

}
