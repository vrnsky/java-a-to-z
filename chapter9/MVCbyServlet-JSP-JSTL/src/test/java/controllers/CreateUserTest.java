package controllers;

import dao.Repository;
import models.User;
import org.junit.Test;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This unit test check work of adding new user servlet.
 */
public class CreateUserTest {


    /**
     * When admin add new user to the system should check that is ok.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminAddNewUserShouldCheckThatUserWasAdded() throws ServletException, IOException {
        CreateUser createUser = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Andrew");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("vrnsky@vrnsky.com");
        createUser.doPost(request, response);
        List<User> users = Repository.getInstance().getAllUsers();
        User added = users.get(users.size() - 1);
        assertEquals(added.getFirstName(), "Andrew");
    }
}