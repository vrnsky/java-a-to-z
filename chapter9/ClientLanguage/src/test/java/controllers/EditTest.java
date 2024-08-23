package controllers;


import dao.UserRepository;
import model.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This unit test check that edit function works correctly.
 */
class EditTest {

    /**
     * When admin edit user should check that user was updated.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    void whenAdminEditUserShouldCheckThatDataSaved() throws ServletException, IOException {
        Edit edit = new Edit();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("email")).thenReturn("vrnsky@v.com");
        when(request.getParameter("password")).thenReturn("luggage");
        when(request.getParameter("country")).thenReturn("Abkhazia");
        when(request.getParameter("city")).thenReturn("Baku");
        edit.doPost(request, response);

        User user = UserRepository.getInstance().getUserById(1);
        assertThat("vrnsky@v.com", is(user.getEmail()));
    }
}