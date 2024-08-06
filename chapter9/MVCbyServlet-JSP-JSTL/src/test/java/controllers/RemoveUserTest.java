package controllers;

import dao.Repository;
import models.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 * <p>
 * This unit test check removing function.
 */
class RemoveUserTest {

    /**
     * Remove user from system and check that it real was removed.
     *
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Test
    void whenAdminRemoveUserShouldCheckThatUserWasRemoved() throws ServletException, IOException {
        CreateUser createUser = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("vrnsky@vrnsky.com");
        createUser.doPost(request, response);

        List<User> users = Repository.getInstance().getAllUsers();
        User created = users.get(users.size() - 1);
        RemoveUser removeUser = new RemoveUser();
        when(request.getParameter("id")).thenReturn(String.valueOf(created.getId()));
        removeUser.doPost(request, response);

        User user = Repository.getInstance().getUserById(created.getId());
        assertNull(user);
    }
}