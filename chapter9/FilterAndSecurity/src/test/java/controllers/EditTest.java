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
 * This unit test check how to work edit function.
 */
class EditTest {


    /**
     * When admin edit user info should check that all is ok.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    void whenAdminEditUserShouldCheckThatAllIsOk() throws ServletException, IOException {
        Edit edit = new Edit();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("id")).thenReturn(String.valueOf("1"));
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");
        when(request.getParameter("role")).thenReturn(String.valueOf("1"));
        edit.doPost(request, response);

        List<User> userList = ExtendedRepo.getInstance().getAllUsers();
        User admin = userList.get(0);

        assertEquals("root", admin.getLogin());

    }
}