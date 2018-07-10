package dao;

import database.IDatabase;
import model.Car;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Car repository works with database it use hibernate for adding new cars.
 * @author vrnsky.
 * @version 0.1.
 */
@Component
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
}
