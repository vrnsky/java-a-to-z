package controllers;

import dao.ExtendedRepo;
import model.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This unit test check work of create servlet.
 */
class CreateTest {


    /**
     * When admin add new user to the system should check that all is ok.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    void whenAdminAddNewUserToTheSystemShouldCheckThatOk() throws ServletException, IOException {
        Create create = new Create();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("yega");
        when(request.getParameter("password")).thenReturn("vrnsky");
        when(request.getParameter("role")).thenReturn("2");

        create.doPost(request, response);
        List<User> userList = ExtendedRepo.getInstance().getAllUsers();
        User user = userList.get(userList.size() - 1);
        assertEquals("yega", user.getLogin());
    }
}