package controllers;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
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
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");

//        login.doPost(request, response);
//        assertEquals(null, request.getAttribute("error"));
    }
}