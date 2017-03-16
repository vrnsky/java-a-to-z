package controllers;


import dao.UserRepository;
import model.Address;
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
 * @since 16.03.2017
 *
 * This unit test check that remove function works correctly.
 */
public class RemoveTest {

    /**
     * Remove user from system and check that it real was removed.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminRemoveUserShouldCheckThatUserWasRemoved() throws ServletException, IOException {
        UserRepository repo = UserRepository.getInstance();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        repo.addUser(new User(-1, "vrnsky", "asdasdas", "", new Address("Russia", "Moscow")));

        Remove removeUser = new Remove();
        List<User> users = repo.getAllUsers();
        User user = users.get(users.size() - 1);
        when(request.getParameter("id")).thenReturn(String.valueOf(user.getId()));
        removeUser.doPost(request, response);

        User removed = repo.getUserById(user.getId());
        assertEquals(null, removed);
    }

}