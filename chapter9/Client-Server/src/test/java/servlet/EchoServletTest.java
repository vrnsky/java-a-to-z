package servlet;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Unit test for Echo Servlet.
 * @author evrnsky
 * @version 0.1
 * @since 15.04.2017
 */
public class  EchoServletTest {

    /**
     * When try push data to the client should check that all is  ok.
     * @throws IOException if io error detected.
     * @throws ServletException if request for get could not be handled.
     */
    @Test
    public void whenCallDoGetMethodShouldCheckThatDataPushedToTheClient() throws IOException, ServletException {
        EchoServlet echoServlet = new EchoServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
        echoServlet.doGet(request, response);
        verify(writer).flush();
    }
}