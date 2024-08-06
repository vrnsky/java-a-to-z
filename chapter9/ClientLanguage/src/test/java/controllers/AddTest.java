package controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.mock;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 * This unit test check that add servlet works correct.
 */
class AddTest {

    /**
     * When admin add new user to the system should check that all is ok.
     * At this time this test ignore, because I don't know how
     * to create mock with multipart/form-data.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Disabled
    @Test
    void whenAdminAddUserToTheSystemShouldCheckThatAllIsOk() throws ServletException, IOException {
        Add add = new Add();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        add.doPost(request, response);
    }
}