package controllers;

import dao.ExtendedRepo;
import model.User;
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
 * This unit test check work of removing function.
 */
public class RemoveTest {

    /**
     * Remove user from system and check that it real was removed.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminRemoveUserShouldCheckThatUserWasRemoved() throws ServletException, IOException {
        Create createUser = new Create();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("vrnsky@vrnsky.com");
        when(request.getParameter("role")).thenReturn("2");
        createUser.doPost(request, response);

        Remove removeUser = new Remove();
        List<User> users = ExtendedRepo.getInstance().getAllUsers();
        User user = users.get(users.size() - 1);
        when(request.getParameter("id")).thenReturn(String.valueOf(user.getId()));
        removeUser.doPost(request, response);

        User removed = ExtendedRepo.getInstance().getUserById(user.getId());
        assertEquals(null, removed);
    }
}