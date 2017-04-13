package repos;

import model.Body;
import database.DBManager;
import model.Producer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
     * After all tet should close connection with database.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}