package controllers;


import database.DBManager;
import model.Advert;
import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repos.AdvertRepo;
import repos.UserRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This unit test for UserAdverts servlet.
 *
 * @author vrnsky
 * @since 14.04.17
 */
public class UserAdvertsTest {

    /**
     * Before all test we need setup connection with database.
     */
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When client as ask about user adverts should check that data pushed.
     *
     * @throws Exception if request for get could not be handled or i/o error detected.
     */
    @Test
    void whenClientAskAboutUserAdvertShouldCheckThatDataPushed() throws Exception {
        UserAdverts adverts = new UserAdverts();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        PrintWriter writer = mock(PrintWriter.class);
        User user = new User();
        user.setEmail("vrnsky@vrnsky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        Advert advert = new Advert();
        advert.setAuthor(user);
        AdvertRepo.getInstance().add(advert);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(response.getWriter()).thenReturn(writer);
        adverts.doGet(request, response);
        verify(writer).flush();
    }

    /**
     * After all test we need to close connection to the database.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().init();
    }
}