package controllers;

import database.DBManager;
import model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repos.UserRepo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 14.04.2017
 *
 * Unit test for Login Servlet.
 */
public class LoginTest {

    /**
     * Before each test need setup connection.
     */
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When user submit correct email and password should check that data has received and pushed.
     * @throws IOException if io error detected.
     * @throws ServletException if request for post could not be handled.
     */
    @Test
    public void whenUserSubmitLoginFormShouldCheckThatDataHasReceivedAndPushed() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        User user = new User();
        user.setEmail("vrnsky@vrnsky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        when(request.getParameter("email")).thenReturn("vrnsky@vrnsky.com");
        when(request.getParameter("password")).thenReturn("root");
        when(request.getSession()).thenReturn(session);
        Login login = new Login();
        login.doPost(request, response);
        verify(session).setAttribute("user", user);

    }

    /**
     * After all test need close connection.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}