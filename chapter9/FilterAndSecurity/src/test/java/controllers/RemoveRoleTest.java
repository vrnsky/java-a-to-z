package controllers;

import dao.ExtendedRepo;
import model.Role;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky
 * @version 0.1
 * @since 05.03.2017
 */
class RemoveRoleTest {

    /**
     * Add new role to the system - it unit test for this.
     * @throws ServletException if problem with conucrrency.
     * @throws IOException if problem with data exchange.
     */
    @Test
    void whenAdminAddNewRoleToSystemShouldCheckThatIsOk() throws ServletException, IOException {
        AddRole addRole = new AddRole();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("role")).thenReturn("subscriber");
        addRole.doPost(request, response);

        RemoveRole removeRole = new RemoveRole();
        List<Role> roles  = ExtendedRepo.getInstance().getAllRoles();
        when(request.getParameter("role")).thenReturn(String.valueOf(roles.size() - 1));
        removeRole.doPost(request, response);

        List<String> description = new ArrayList<>();
        for (Role role : ExtendedRepo.getInstance().getAllRoles()) {
            description.add(role.getDesc());
        }

        assertFalse(description.contains("subcriber"));
    }
}