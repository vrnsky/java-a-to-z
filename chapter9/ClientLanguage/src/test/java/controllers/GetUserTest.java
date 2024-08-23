package controllers;

import dao.UserRepository;
import model.User;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * Unit test for get user servlet.
 */
class GetUserTest {


    /**
     * When client ask about user by id should check that app have this user.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    void whenClientAskServerByGetShouldReturnUserWithGivenId() throws ServletException, IOException {
        GetUser getUser = new GetUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        UserRepository repo = mock(UserRepository.class);
        when(response.getWriter()).thenReturn(mock(PrintWriter.class));
        when(request.getParameter("id")).thenReturn("1");
        when(repo.getUserById(1)).thenReturn(mock(User.class));
        getUser.doGet(request, response);
        verify(request).getParameter("id");
    }
}