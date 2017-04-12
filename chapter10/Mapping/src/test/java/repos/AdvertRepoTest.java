package repos;

import database.DBManager;
import model.Advert;
import model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 12.04.2017
 */
public class AdvertRepoTest {

    /**
     * Create a session factory before using hibernate session.
     */
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When add new advert to the system should check that id has set.
     */
    @Test
    public void whenAddNewAdvertShouldCheckThatIdChanged() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        assertThat(advert.getId() != 0, is(true));
    }

    /**
     *  When update item should check that data saved.
     */
    @Test
    public void whenTryEditItemShouldCheckThatAllIsOk() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        advert.setSale(true);
        AdvertRepo.getInstance().edit(advert);
        assertThat(AdvertRepo.getInstance().getById(advert.getId()).getSale(), is(true));
    }

    /**
     * Check that item was removed from repository.
     */
    @Test
    public void whenTryRemoveItemShouldCheckThatItemWasRemoved() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        AdvertRepo.getInstance().remove(advert);
        assertThat(AdvertRepo.getInstance().getById(advert.getId()), is(nullValue()));
    }

    /**
     * When try get item by id should check that repo return correct item.
     */
    @Test
    public void whenTryGetGetAdvertByIdShouldCheckThatCorrectAdvert() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        Advert actual = AdvertRepo.getInstance().getById(advert.getId());
        assertThat(actual.getId(), is(advert.getId()));
    }

    /**
     * When try get adverts by user id should check that all is ok.
     */
    @Test
    public void whenTryGetAdvertByUserIdShouldCheckThatAllIsOk() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        User user = new User();
        user.setEmail("vrnsky@voronyansky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        advert.setAuthor(user);
        AdvertRepo.getInstance().edit(advert);
        assertThat(AdvertRepo.getInstance().getAdvertsByUserId(user.getId()).size(), is(1));
    }

    /**
     * When try get all adverts should check that its more that zero or equal.
     */
    @Test
    public void whenTryGetAllAdvertsShouldCheckThatItsMoreThanZero() {
        assertThat(AdvertRepo.getInstance().getAll().size() >= 0, is(true));
    }

    /**
     * Close session factory after using it.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}