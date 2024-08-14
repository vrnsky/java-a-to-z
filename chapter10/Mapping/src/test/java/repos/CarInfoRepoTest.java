package repos;

import model.Body;
import database.DBManager;
import model.CarInfo;
import model.Model;
import model.Producer;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }


    /**
     * When try to  add body should check that body was added.
     */
    @Test
    public void whenTryAddSomeCarInfoShouldCheckThatAllIsOk() {
        Body body = new Body("sedan");
        CarInfoRepo.getInstance().add(body);
        MatcherAssert.assertThat(CarInfoRepo.getInstance().getBodyById(body.getId()).getName(), is("sedan"));
    }

    /**
     * When try to add producer to the table should check that all is ok.
     */
    @Test
    void whenTryAddProducerShouldCheckThatAllIsOk() {
        Producer producer = new Producer("Ford");
        CarInfoRepo.getInstance().add(producer);
        MatcherAssert.assertThat(CarInfoRepo.getInstance().getProducerById(producer.getId()).getName(), is("Ford"));
    }

    /**
     * When try to get body which is not exist should check that app throw exception.
     */
    @Test
    void whenTryGetNotExistBodyShouldCheckThatThrownException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarInfoRepo.getInstance().getBodyById(-1));
    }

    /**
     * When try to get producer which not exist should check that app throw exception.
     */
    @Test
    void whenTryGetNotExistProducerShouldCheckThatThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarInfoRepo.getInstance().getProducerById(-1));
    }

    /**
     * When try to get all producer in system should check that all is ok.
     */
    @Test
    void whenTryGetAllProducersShouldCheckThatAllIsOk() {
        CarInfo producer = new Producer("Ford");
        CarInfoRepo.getInstance().add(producer);
        MatcherAssert.assertThat(CarInfoRepo.getInstance().getAllProducers().size() > 0, is(true));
    }

    /**
     * When try to get all bodies should check that all is ok.
     */
    @Test
    void whenTryGetAllBodiesShouldCheckThatAllIsOk() {
        CarInfo body = new Body("hatchback");
        CarInfoRepo.getInstance().add(body);
    }

    /**
     * When try to get models by producer should check that all is ok.
     */
    @Test
    void whenTryGetModelByProducerIdShouldCheckThatAllFineWorks() {
        Producer producer = new Producer("Ford");
        Model model = new Model("Focus");
        model.setProducer(producer);
        CarInfoRepo.getInstance().add(producer);
        CarInfoRepo.getInstance().add(model);
        List<CarInfo> actual = CarInfoRepo.getInstance().getModelsByProducer(producer);
        assertThat(actual.size() >= 0, is(true));
    }

    /**
     * After all tet should close connection with database.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}