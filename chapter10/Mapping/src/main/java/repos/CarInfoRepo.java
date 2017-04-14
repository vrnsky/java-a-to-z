package repos;

import model.CarInfo;
import model.Producer;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

/**
 * @author evrnsky (vrnsky at protonmail.ch)
 * @version 0.1.
 * @since 10.04.2017
 *
 */
public class CarInfoRepo extends CommonRepo<CarInfo> {

    /**
     * Self instance.
     */
    private static final CarInfoRepo REPO = new CarInfoRepo();

    /**
     * Call parent constructor. Private because it is singleton.
     */
    private CarInfoRepo() {
        super();
    }

    /**
     * Return it.
     * @return self instance.
     */
    public static CarInfoRepo getInstance() {
        return REPO;
    }

    /**
     * Return list of car models by producer id.
     * @param producer for determine.
     * @return list of car info.
     */
    public List<CarInfo> getModelsByProducer(Producer producer) {
      return super.getAll(session -> {
          return session.createQuery("from model.Model as m where m.producer=:pid").setParameter("pid", producer).list();
      });
    }

    /**
     * Return list of all producers.
     * @return list of all producers.
     */
    public List<CarInfo> getAllProducers() {
        return super.getAll(session -> {
            return session.createQuery("from model.Producer").list();
        });
    }

    /**
     * Return all bodies.
     * @return all bodies.
     */
    public List<CarInfo> getAllBodies() {
        return super.getAll(session -> {
            return session.createQuery("from model.Body").list();
        });
    }

    /**
     * Add new car info to the database.
     * @param carInfo various car info implementation.
     */
    public void add(CarInfo carInfo) {
        super.execute(Session::save, carInfo);
    }

    /**
     * Return producer with given id.
     * @param id unique per all producer number.
     * @return car info object which describe producer.
     */
    public CarInfo getProducerById(int id) {
        return super.getById(session -> {
            Optional<CarInfo> producer =  (Optional<CarInfo>) session.createQuery("from model.Producer where id=:id").setParameter("id", id).uniqueResultOptional();
            if (!producer.isPresent()) {
                throw new IllegalArgumentException(String.format("Producer with id = %s not exist", id));
            }
            return producer.get();
        });
    }

    /**
     * Return body with given id.
     * @param id unique per all body number.
     * @return car info object which describe body car.
     */
    public CarInfo getBodyById(int id) {
        return super.getById(session -> {
            Optional<CarInfo> body = (Optional<CarInfo>) session.createQuery("from model.Body where id=:id").setParameter("id", id).uniqueResultOptional();
            if (!body.isPresent()) {
                throw new IllegalArgumentException(String.format("Body with id = %s not exist", id));
            }
            return body.get();
        });
    }


}
