package repos;

import database.DBManager;
import model.Advert;
import model.Car;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */
public class AdvertRepo {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(AdvertRepo.class);

    /**
     * It is singleton.
     */
    private static final AdvertRepo REPO = new AdvertRepo();

    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * It is private, because singleton.
     */
    private AdvertRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of it.
     * @return it.
     */
    public static AdvertRepo getInstance() {
        return REPO;
    }

    /**
     * Add new advert to the system.
     * @param advert instance of advert class.
     */
    public void add(Advert advert) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.save(advert);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Edit already exist at the database advert.
     * @param advert instance of advert class.
     */
    public void edit(Advert advert) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.update(advert);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Remove advert from database.
     * @param advert instance of advert class.
     */
    public void remove(Advert advert) {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        session.remove(advert);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return advert with given id.
     * @param id unique among all adverts number.
     * @return advert with given id.
     */
    public Advert getById(int id) {
        Advert advert = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        advert = session.get(Advert.class, id);
        session.getTransaction().commit();
        return advert;
    }

    /**
     * Return adverts which written by user specify by id.
     * @param id unique number per user among all users.
     * @return list of adverts which created user with given id.
     */
    public List<Advert> getAdvertsByUserId(int id) {
        List<Advert> adverts;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        adverts = session.createQuery(String.format("from model.Advert where author_id = %s", id)).list();
        session.getTransaction().commit();
        return adverts;
    }

    /**
     * Return list of not sale adverts.
     * @return list of not sale adverts at the system.
     */
    public List<Advert> getAll() {
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        String query = "from model.Advert where sale = false";
        List<Advert> result = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    /**
     * Search on database advert with given car.
     * @param producer of car.
     * @param model of car.
     * @param body of car.
     * @return adverts with given params.
     */
    public List<Advert> getAdvertsByParam(String producer, String model, String body) {
        List<Advert> result = new ArrayList<>();
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from model.Car where producer_id =:p and model_id=:m and body_id=:b");
        query.setParameter("p", Integer.valueOf(producer));
        query.setParameter("m", Integer.valueOf(model));
        query.setParameter("b", Integer.valueOf(body));
        List<Car> cars = query.list();
        List<Advert> adverts = session.createQuery("from model.Advert where sale = false").list();
        for (Advert advert : adverts) {
            for (Car car : cars) {
                if (advert.getCar().getId() == car.getId()) {
                    result.add(advert);
                }
            }
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

