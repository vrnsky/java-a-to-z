package repos;

import database.DBManager;
import model.Car;
import model.CarInfo;
import model.Producer;
import model.Body;
import model.Model;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 13.04.2017
 *
 * Unit test for Car Repository.
 */
public class CarRepoTest {

    /**
     * Before start all test need create a session factory object.
     */
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When try to add new car to the database should check that car was added.
     */
    @Test
    void whenTryAddSomeCarToTheDatabaseShouldCheckThatWasAdded() {
        Car car = new Car();
        car.setModel(new Model("Focus"));
        car.setProducer(new Producer("Ford"));
        CarRepo.getInstance().add(car);
        MatcherAssert.assertThat(CarRepo.getInstance().getById(car.getId()).getModel().getName(), is("Focus"));
    }


    /**
     * When try to get all bodies should check that list greater that zero.
     */
    @Test
    public void whenTryGetAllBodiesShouldCheckThatListGreaterThatZero() {
        CarInfo sedan = new Body("sedan");
        CarInfo coupe = new Body("coupe");
        CarInfoRepo.getInstance().add(sedan);
        CarInfoRepo.getInstance().add(coupe);
        MatcherAssert.assertThat(CarRepo.getInstance().getAllBodies().size() > 0, is(true));
    }

    /**
     * When try to get all producers should check that list greater that zero.
     */
    @Test
    void whenTryGetAllProducersShouldCheckThatRepoReturnListGreaterThatZero() {
        CarInfo ford = new Producer("Ford");
        CarInfo audi = new Producer("Audi");
        CarInfo bmw = new Producer("BMW");
        CarInfoRepo.getInstance().add(ford);
        CarInfoRepo.getInstance().add(audi);
        CarInfoRepo.getInstance().add(bmw);
        assertThat(CarRepo.getInstance().getAllProducers().size() > 0, is(true));
    }


    /**
     * After all test should check close session factory.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}