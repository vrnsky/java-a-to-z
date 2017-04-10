package repos;

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
public class AdvertRepo extends CommonRepo<Advert> {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(AdvertRepo.class);

    /**
     * It is singleton.
     */
    private static final AdvertRepo REPO = new AdvertRepo();

    /**
     * It is private, because singleton.
     */
    private AdvertRepo() {
        super();
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
        super.execute(Session::save, advert);
    }

    /**
     * Edit already exist at the database advert.
     * @param advert instance of advert class.
     */
    public void edit(Advert advert) {
        super.execute(Session::update, advert);
    }

    /**
     * Remove advert from database.
     * @param advert instance of advert class.
     */
    public void remove(Advert advert) {
       super.execute(Session::remove, advert);
    }

    /**
     * Return advert with given id.
     * @param id unique among all adverts number.
     * @return advert with given id.
     */
    public Advert getById(int id) {
        return super.getById(session -> session.get(Advert.class, id));
    }

    /**
     * Return adverts which written by user specify by id.
     * @param id unique number per user among all users.
     * @return list of adverts which created user with given id.
     */
    public List<Advert> getAdvertsByUserId(int id) {
        return super.getAll(session -> {
            Query query = session.createQuery("from model.Advert where author_id=:id").setParameter("id", id);
            return query.list();
        });
    }

    /**
     * Return list of not sale adverts.
     * @return list of not sale adverts at the system.
     */
    public List<Advert> getAll() {
        return super.getAll(session -> {
            Query query = session.createQuery("from model.Advert where sale = false");
            return query.list();
        });
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
        List<Car> cars = CarRepo.getInstance().getCarByParam(Integer.valueOf(producer), Integer.valueOf(model), Integer.valueOf(body));
        List<Advert> adverts = this.getAll();
        for (Advert advert : adverts) {
            for (Car car : cars) {
                if (advert.getCar().getId() == car.getId()) {
                    result.add(advert);
                }
            }
        }
        return result;
    }
}

