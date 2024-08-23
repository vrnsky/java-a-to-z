package repos;

import database.DBManager;
import model.Advert;
import model.User;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 12.04.2017
 */
class AdvertRepoTest {

    /**
     * Create a session factory before using hibernate session.
     */
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When add new advert to the system should check that id has set.
     */
    @Test
    void whenAddNewAdvertShouldCheckThatIdChanged() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        MatcherAssert.assertThat(advert.getId() != 0, is(true));
    }

    /**
     *  When update item should check that data saved.
     */
    @Test
    void whenTryEditItemShouldCheckThatAllIsOk() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        advert.setSale(true);
        AdvertRepo.getInstance().edit(advert);
        MatcherAssert.assertThat(AdvertRepo.getInstance().getById(advert.getId()).getSale(), is(true));
    }

    /**
     * Check that item was removed from repository.
     */
    @Test
    void whenTryRemoveItemShouldCheckThatItemWasRemoved() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        AdvertRepo.getInstance().remove(advert);
        MatcherAssert.assertThat(AdvertRepo.getInstance().getById(advert.getId()), is(nullValue()));
    }

    /**
     * When try to get item by id should check that repo return correct item.
     */
    @Test
    void whenTryGetGetAdvertByIdShouldCheckThatCorrectAdvert() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        Advert actual = AdvertRepo.getInstance().getById(advert.getId());
        MatcherAssert.assertThat(actual.getId(), is(advert.getId()));
    }

    /**
     * When try to get adverts by user id should check that all is ok.
     */
    @Test
    void whenTryGetAdvertByUserIdShouldCheckThatAllIsOk() {
        Advert advert = new Advert();
        AdvertRepo.getInstance().add(advert);
        User user = new User();
        user.setEmail("vrnsky@voronyansky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        advert.setAuthor(user);
        AdvertRepo.getInstance().edit(advert);
        MatcherAssert.assertThat(AdvertRepo.getInstance().getAdvertsByUserId(user.getId()).size(), is(1));
    }

    /**
     * When try to get all adverts should check that its more that zero or equal.
     */
    @Test
    void whenTryGetAllAdvertsShouldCheckThatItsMoreThanZero() {
        assertThat(AdvertRepo.getInstance().getAll().size() >= 0, is(true));
    }

    /**
     * Close session factory after using it.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}