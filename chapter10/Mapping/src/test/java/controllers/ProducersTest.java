package controllers;


import database.DBManager;
import model.Producer;
import org.junit.jupiter.api.AfterAll;
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
 * This unit test for Producers servlet.
 * @author vrnsky
 * @since 14.04.17
 */
class ProducersTest {

    /**
     * Before all test we need setup connection with database.
     */
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When client ask about producers should check that data pushed to the client.
     * @throws Exception if request for get could not be handled or i/o error detected.
     */
    @Test
    void whenClientAskAboutAllProducersShouldCheckThatAppReturnProducers() throws Exception {
        Producers producers = new Producers();
        CarInfoRepo.getInstance().add(new Producer("Ford"));
        CarInfoRepo.getInstance().add(new Producer("Audi"));
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
        producers.doGet(request, response);
        verify(writer).flush();
    }

    /**
     * After all test we need to close connection with database.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}