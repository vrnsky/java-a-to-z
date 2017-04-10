package repos;

import model.Car;
import model.CarInfo;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 *
 * This is car repository.
 */
public class CarRepo extends CommonRepo<Car> {

    /**
     * Self instance, it is singleton.
     */
    private static final CarRepo REPO = new CarRepo();


    /**
     * It is private, because it is singleton.
     */
    private CarRepo() {
        super();
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
       return super.getById(session -> session.get(Car.class, id));
    }

    /**
     * Return models by producer id.
     * @param producerId unique among all producers at the system number.
     * @return list of models.
     */
    public List<CarInfo> getModelsByProducer(String producerId) {
      return CarInfoRepo.getInstance().getModelsByProducer(producerId);
    }

    /**
     * Return list of all producers.
     * @return list of all producers.
     */
    public List<CarInfo> getAllProducers() {
       return CarInfoRepo.getInstance().getAllProducers();
    }

    /**
     * Return all bodies.
     * @return all bodies.
     */
    public List<CarInfo> getAllBodies() {
        return CarInfoRepo.getInstance().getAllBodies();
    }

    /**
     * Return car with given parameters.
     * @param modelId specify model of car.
     * @param producerId specify producer of car.
     * @param bodyId specify body of car.
     * @return car which have given params.
     */
    public List<Car> getCarByParam(int producerId, int modelId, int bodyId) {
        return super.getAll(session -> {
            Query query = session.createQuery("from model.Car where producer_id=:pid and model_id=:mid and body_id:=bid")
                    .setParameter("pid", producerId)
                    .setParameter("mid", modelId)
                    .setParameter("bid", bodyId);
            return query.list();
        });

    }

}

