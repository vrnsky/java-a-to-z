package repos;

import database.DBManager;
import model.Car;
import model.CarInfo;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */
public class CarRepo {

    private static final CarRepo REPO = new CarRepo();
    private DBManager dbManager;
    private CarRepo() {
        this.dbManager = DBManager.getInstance();
    }
    public static CarRepo getInstance() {
        return REPO;
    }

    public Car getById(int id) {
        return null;
    }

    public List<CarInfo> getModelsByProducer(String producerId) {
        List<CarInfo> models;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        models = session.createQuery("from model.Model as m where producer_id = " + producerId).list();
        session.getTransaction().commit();
        session.close();
        return models;
    }

    public List<CarInfo> getAllProducers() {
        List<CarInfo> producers;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        producers = session.createQuery("from model.Producer").list();
        session.getTransaction().commit();
        session.close();
        return producers;
    }

    public List<CarInfo> getAllBodies() {
        List<CarInfo> bodies;
        Session session = this.dbManager.getFactory().openSession();
        session.beginTransaction();
        bodies = session.createQuery("from model.Body").list();
        session.getTransaction().commit();
        session.close();
        return bodies;
    }

}

