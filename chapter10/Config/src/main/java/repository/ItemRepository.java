package repository;

import database.DBManager;
import model.Item;
import org.hibernate.Session;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 */
public class ItemRepository {



    private static final ItemRepository REPO = new ItemRepository();
    private DBManager dbManager;

    private ItemRepository() {
        this.dbManager = DBManager.getInstance();
    }

    public static ItemRepository getInstance() {
        return REPO;
    }


    public void addItem(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    public void editItem(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public Item getById(int id) {
        Item result = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void remove(Item item) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    public List<Item> getAll(boolean onlyDone) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        String query = "";
        if (onlyDone) {
            query = "from model.Item as i where i.done = true";
        } else {
            query = "from model.Item";
        }
        List<Item> result = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }


}
