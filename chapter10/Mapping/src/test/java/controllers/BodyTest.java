package controllers;

import database.DBManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repos.CarInfoRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 14.04.2017
 * <p>
 * Unit test for Body Servlet.
 */
class BodyTest {

    /**
     * Before all test needs to create a connection.
     */
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When try to get all bodies should check that data was pushed.
     *
     * @throws Exception if i/o errors detected or request for get could not be handled.
     */
    @Test
    void whenAppTryGetAllBodiesInSystemShouldCheckThatAllIsOk() throws Exception {
        Body body = new Body();
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(response.getWriter()).thenReturn(writer);
        model.Body sedan = new model.Body("sedan");
        CarInfoRepo.getInstance().add(sedan);
        body.doGet(request, response);
        verify(writer).flush();

    }

    /**
     * After all test we need close connection to the database.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }

}