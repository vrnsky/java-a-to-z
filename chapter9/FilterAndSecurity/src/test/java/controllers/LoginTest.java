package controllers;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This unit test check that login form works correctly.
 */
public class LoginTest {


    /**
     * Test when user log in system.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenUserLoginWithGoodDataShouldCheckGiveAccess() throws ServletException, IOException {
        Login login = new Login();
        HttpSession mock = PowerMockito.mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(mock);
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");

        login.doPost(request, response);

        verify(request).getSession();

    }

    /**
     * When user type a wrong data should check that request set attr.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenUserLoginWithBadDataShouldCheckDontAccess() throws ServletException, IOException {
        Login login = new Login();
        HttpSession mock = PowerMockito.mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher =  mock(RequestDispatcher.class);
        when(request.getSession()).thenReturn(mock);
        when(request.getRequestDispatcher("/WEB-INF/views/login.jsp")).thenReturn(dispatcher);
        when(request.getParameter("login")).thenReturn("toor");
        when(request.getParameter("password")).thenReturn("toor");
        when(request.getAttribute("error")).thenReturn("Credintals is not valid!");
        login.doPost(request, response);

        assertThat(request.getAttribute("error"), is("Credintals is not valid!"));

    }
}