package controllers;

import dao.ExtendedRepo;
import model.Role;
import org.junit.Test;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 *
 * This unit test check add role function.
 */
public class AddRoleTest {


    /**
     * Add new role to the system - it unit test for this.
     * @throws ServletException if problem with conucrrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    public void whenAdminAddNewRoleToSystemShouldCheckThatIsOk() throws ServletException, IOException {
        AddRole addRole = new AddRole();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("role")).thenReturn("writer");

        addRole.doPost(request, response);

        List<String> description = new ArrayList<>();
        for (Role role : ExtendedRepo.getInstance().getAllRoles()) {
            description.add(role.getDesc());
        }
        assertThat(description.contains("writer"), is(true));
        verify(request).getParameter("role");
    }
}