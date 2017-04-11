package repos;

import model.CarInfo;
import java.util.List;

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
     * @param producerId for determine.
     * @return list of car info.
     */
    public List<CarInfo> getModelsByProducer(String producerId) {
      return super.getAll(session -> {
          return session.createQuery("from model.Model where id=:pid").setParameter("pid", Integer.valueOf(producerId)).list();
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


}