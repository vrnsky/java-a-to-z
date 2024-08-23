package controllers;

import database.Repository;
import models.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 * <p>
 * This unit test check work of edit controller of app.
 */
class EditUserTest {

    /**
     * Add new user to the system and edit it, after it operations check that all is ok.
     *
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Test
    void whenAdminEditUserShouldCheckThatDataWasChanged() throws ServletException, IOException {
        CreateUser createUser = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("vrnsky@vrnsky.com");
        createUser.doPost(request, response);

        EditUser editUser = new EditUser();
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("name")).thenReturn("Andrew");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("a@vrngroup.com");
        editUser.doPost(request, response);

        User user = Repository.getInstance().findUserById(1);
        assertThat(user.getName(), is("Andrew"));
    }

}