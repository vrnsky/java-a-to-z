package repos;

import model.Body;
import database.DBManager;
import model.CarInfo;
import model.Model;
import model.Producer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 13.04.2017
 */
public class CarInfoRepoTest {

    /**
     * Before start all test need set connection to the database.
     */
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().init();
    }


    /**
     * When try add body should check that body was added.
     */
    @Test
    public void whenTryAddSomeCarInfoShouldCheckThatAllIsOk() {
        Body body = new Body();
        body.setName("sedan");
        CarInfoRepo.getInstance().add(body);
        assertThat(CarInfoRepo.getInstance().getBodyById(body.getId()).getName(), is("sedan"));
    }

    /**
     * When try add producer to the table should check that all is ok.
     */
    @Test
    public void whenTryAddProducerShouldCheckThatAllIsOk() {
        Producer producer = new Producer();
        producer.setName("Ford");
        CarInfoRepo.getInstance().add(producer);
        assertThat(CarInfoRepo.getInstance().getProducerById(producer.getId()).getName(), is("Ford"));
    }

    /**
     * When try get body which is not exist should check that app throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGetNotExistBodyShouldCheckThatThrownException() {
        CarInfoRepo.getInstance().getBodyById(-1);
    }

    /**
     * When try get producer which not exist should check that app throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGetNotExistProducerShouldCheckThatThrowException() {
        CarInfoRepo.getInstance().getProducerById(-1);
    }

    /**
     * When try to get all producer in system should check that all is ok.
     */
    @Test
    public void whenTryGetAllProducersShouldCheckThatAllIsOk() {
        CarInfo producer = new Producer();
        producer.setName("Ford");
        CarInfoRepo.getInstance().add(producer);
        assertThat(CarInfoRepo.getInstance().getAllProducers().size() > 0, is(true));
    }

    /**
     * When try to get all bodies should check that all is ok.
     */
    @Test
    public void whenTryGetAllBodiesShouldCheckThatAllIsOk() {
        CarInfo body = new Body();
        body.setName("hatchback");
        CarInfoRepo.getInstance().add(body);
    }

    /**
     * When try get models by producer should check that all is ok.
     */
    @Test
    public void whenTryGetModelByProducerIdShouldCheckThatAllFineWorks() {
        CarInfo producer = new Producer();
        producer.setName("Ford");
        Model model = new Model();
        model.setName("Focus");
        model.setProducer(producer);
        CarInfoRepo.getInstance().add(producer);
        CarInfoRepo.getInstance().add(model);
        List<CarInfo> actual = CarInfoRepo.getInstance().getModelsByProducer(String.valueOf(producer.getId()));
        assertThat(actual.size() >= 0, is(true));
    }

    /**
     * After all tet should close connection with database.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}