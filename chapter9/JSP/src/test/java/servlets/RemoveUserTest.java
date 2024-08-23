package servlets;

import dao.Repository;
import models.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This unit test check controller's work for removing user from app.
 */
class RemoveUserTest {


    /**
     * Remove user from system and check that it really was removed.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
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

        RemoveUser removeUser = new RemoveUser();
        List<User> users = Repository.getInstance().getAllUsers();
        User user = users.get(users.size() - 1);
        when(request.getParameter("id")).thenReturn(String.valueOf(user.getId()));
        removeUser.doPost(request, response);

        User updated = Repository.getInstance().getUserById(user.getId());
        assertThat(updated, is(nullValue()));
    }
}