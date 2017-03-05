package crud;

import org.junit.Test;
import repo.User;
import repo.UserRepo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This is unit test for crud servlet.
 */
public class CrudTest {

    /**
     * When admin add user to the system should check that user was added.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminAddUserToTheSystemShouldCheckThatItAdd() throws ServletException, IOException {
        Crud crud = new Crud();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("voronyansky.egor@yandex.ru");
        crud.doPost(request, response);
        List<User> users = UserRepo.getInstance().getAllUsers();
        assertThat(users.get(users.size() - 1).getEmail(), is("voronyansky.egor@yandex.ru"));
    }


    /**
     * When admin edit user should check that data saved.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminEditUserShouldCheckThatDataSaved() throws ServletException, IOException {
        Crud crud = new Crud();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("voronyansky.egor@yandex.ru");
        crud.doPost(request, response);

        List<User> users = UserRepo.getInstance().getAllUsers();
        int id = users.get(users.size() - 1).getId();
        when(request.getParameter("id")).thenReturn(String.valueOf(id));
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("vrnsky@protonmail.ch");
        crud.doPut(request, response);
        List<User> updatedUsers = UserRepo.getInstance().getAllUsers();


        assertThat(updatedUsers.get(updatedUsers.size() - 1).getEmail(), is("vrnsky@protonmail.ch"));
    }

    /**
     * When admin remove user should check that user was removed.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminRemoveUserShouldCheckThatUserWasRemoved() throws ServletException, IOException {
        Crud crud = new Crud();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Yegor");
        when(request.getParameter("surname")).thenReturn("Voronyansky");
        when(request.getParameter("email")).thenReturn("voronyansky.egor@yandex.ru");
        crud.doPost(request, response);

        List<User> users = UserRepo.getInstance().getAllUsers();
        int id = users.get(users.size() - 1).getId();
        when(request.getParameter("id")).thenReturn(String.valueOf(id));
        crud.doDelete(request, response);
    }


}