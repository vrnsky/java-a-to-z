package repos;

import database.DBManager;
import model.Car;
import model.CarInfo;
import org.hibernate.Session;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 *
 * This is car repository.
 */
public class CarRepo {

    /**
     * Self instance, it is singleton.
     */
    private static final CarRepo REPO = new CarRepo();

    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * It is private, because it is singleton.
     */
    private CarRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return self instance.
     * @return instance of this.
     */
    public static CarRepo getInstance() {
        return REPO;
    }

    /**
     * Find car by given id.
     * @param id unique among all cars in system number.
     * @return car which id is equals to given id.
     */
    public Car getById(int id) {
        Car car = null;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        car = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    /**
     * Return models by producer id.
     * @param producerId unique among all producers at the system number.
     * @return list of models.
     */
    public List<CarInfo> getModelsByProducer(String producerId) {
        List<CarInfo> models;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        models = session.createQuery(String.format("from model.Model as m where producer_id = %s", producerId)).list();
        session.getTransaction().commit();
        session.close();
        return models;
    }

    /**
     * Return list of all producers.
     * @return list of all producers.
     */
    public List<CarInfo> getAllProducers() {
        List<CarInfo> producers;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        producers = session.createQuery("from model.Producer").list();
        session.getTransaction().commit();
        session.close();
        return producers;
    }

    /**
     * Return all bodies.
     * @return all bodies.
     */
    public List<CarInfo> getAllBodies() {
        List<CarInfo> bodies;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        bodies = session.createQuery("from model.Body").list();
        session.getTransaction().commit();
        session.close();
        return bodies;
    }

    /**
     * Return car with given parameters.
     * @param modelId specify model of car.
     * @param producerId specify producer of car.
     * @param bodyId specify body of car.
     * @return car which have given params.
     */
    public Car getCarByParam(int modelId, int producerId, int bodyId) {
        Car cars;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        cars = (Car) session.createQuery(String.format(
                "from model.Car as c where c.model_id = %s and c.producer_id = %s and c.body_id = %s", modelId, producerId, bodyId)).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return cars;
    }

}

