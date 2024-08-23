package dao;

import database.IDatabase;
import jakarta.persistence.Query;
import model.Car;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Car repository works with database it use hibernate for adding new cars.
 * @author vrnsky.
 * @version 0.1.
 */
@Repository
public class CarRepository {

    /**
     * Instance of database helper.
     */
    private IDatabase database;

    /**
     * Create a new repo with given helper.
     * @param database wrapper for work with database.
     */
    @Autowired
    public CarRepository(IDatabase database) {
        this.database = database;
    }


    /**
     * Adding new car to the system.
     * @param car instance of the car.
     */
    public void add(Car car) {
        Session session = this.database.getFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Find car by param.
     * @param producerId of producer.
     * @param modelId of car.
     * @param bodyId of car.
     * @param gearboxId of car.
     * @param colorId of car.
     * @return car or null.
     */
    public Car getCarByParameters(int producerId, int modelId, int bodyId, int gearboxId, int colorId) {
        Session session = this.database.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from car c where producer_id = :producerId and model_id = :modelId and body_id := bodyId"
                + "and gearbox_id = :gearboxId and color_id := colorId");
        query.setParameter("producerId", producerId);
        query.setParameter("modelId", modelId);
        query.setParameter("bodyId", bodyId);
        query.setParameter("gearboxId", gearboxId);
        query.setParameter("colorId", colorId);

        List<Car> cars = query.getResultList();
        Car find = null;
        if (!cars.isEmpty()) {
            find = cars.get(0);
        }
        return find;
    }
}
