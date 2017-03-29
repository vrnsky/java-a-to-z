package repository;

import database.DBManager;
import model.Item;
import org.hibernate.Session;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 *
 * Provide crud operations for items table.
 */
public class ItemRepository {

    /**
     * Instance of itelsef, it is singleton.
     */
    private static final ItemRepository REPO = new ItemRepository();

    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * Init needed fields.
     */
    private ItemRepository() {
        this.dbManager = DBManager.getInstance();
    }


    /**
     * Return itself instance.
     * @return itself instance.
     */
    public static ItemRepository getInstance() {
        return REPO;
    }

    /**
     * Add new item to the database.
     * @param item instance of item class.
     */
    public void addItem(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Edit already exist at the database item.
     * @param item instance of item class.
     */
    public void editItem(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Find at the database item with given id, if it exist return it, otherwise false.
     * @param id unique among all items number.
     * @return instance of item class with given id.
     */
    public Item getById(int id) {
        Item result = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    /**
     * Remove item from the database.
     * @param item instance of item class.
     */
    public void remove(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return list of all task or list of only done task.
     * @param onlyDone if true return task which alread done, otherwise false.
     * @return list of items.
     */
    public List<Item> getAll(boolean onlyDone) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        String query = "";
        if (onlyDone) {
            query = "from model.Item as i where i.done = true order by i.id asc";
        } else {
            query = "from model.Item order by id asc";
        }
        List<Item> result = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }


}
