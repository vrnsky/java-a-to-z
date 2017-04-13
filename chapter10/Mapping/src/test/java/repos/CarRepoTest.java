package repos;

import database.DBManager;
import model.Car;
import model.CarInfo;
import model.Producer;
import model.Body;
import model.Model;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When try add new car to the database should check that car was added.
     */
    @Test
    public void whenTryAddSomeCarToTheDatabaseShouldCheckThatWasAdded() {
        Car car = new Car();
        car.setModel(new Model("Focus"));
        car.setProducer(new Producer("Ford"));
        CarRepo.getInstance().add(car);
        assertThat(CarRepo.getInstance().getById(car.getId()).getModel().getName(), is("Focus"));
    }

    /**
     * When try get models by producer should check that repo return list with positive size.
     * FIXME
     */
//    @Test
//    public void whenTryGetModelsByProducerIdShouldCheckThatRepoReturnListWithPositiveSize() {
//        CarInfo producer = new Producer("Ford");
//        CarInfoRepo.getInstance().add(producer);
//        Car fiesta = new Car();
//        Car focus = new Car();
//        fiesta.setProducer(producer);
//        focus.setProducer(producer);
//        CarRepo.getInstance().add(fiesta);
//        CarRepo.getInstance().add(focus);
//        assertThat(CarRepo.getInstance().getModelsByProducer(String.valueOf(producer.getId())).size() > 0, is(true));
//    }

    /**
     * When try get all bodies should check that list greater that zero.
     */
    @Test
    public void whenTryGetAllBodiesShouldCheckThatListGreaterThatZero() {
        CarInfo sedan = new Body("sedan");
        CarInfo coupe = new Body("coupe");
        CarInfoRepo.getInstance().add(sedan);
        CarInfoRepo.getInstance().add(coupe);
        assertThat(CarRepo.getInstance().getAllBodies().size() > 0, is(true));
    }

    /**
     * When try get all producers should check that list greater that zero.
     */
    @Test
    public void whenTryGetAllProducersShouldCheckThatRepoReturnListGreaterThatZero() {
        CarInfo ford = new Producer("Ford");
        CarInfo audi = new Producer("Audi");
        CarInfo bmw = new Producer("BMW");
        CarInfoRepo.getInstance().add(ford);
        CarInfoRepo.getInstance().add(audi);
        CarInfoRepo.getInstance().add(bmw);
        assertThat(CarRepo.getInstance().getAllProducers().size() > 0, is(true));
    }

    /**
     * When try get model by producer id should check that app return correct list.
     * FIXME
     */
//    @Test
//    public void whenTryCarWithSpecifiedParamsShouldCheckThatAppReturnCorrectCar() {
//       Producer producer = new Producer("Ford");
//       Model model = new Model("Focus");
//       model.setProducer(producer);
//       CarInfo sedan = new Body("sedan");
//       CarInfoRepo.getInstance().add(producer);
//       CarInfoRepo.getInstance().add(model);
//       CarInfoRepo.getInstance().add(sedan);
//       Car car = new Car(producer, model, sedan);
//       CarRepo.getInstance().add(car);
//
//       Car actual = CarRepo.getInstance().getCarByParam(producer.getId(), model.getId(), sedan.getId()).get(0);
//       assertThat(actual.getProducer().getName(), is("Ford"));
//    }

    /**
     * After all test should check close session factory.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}