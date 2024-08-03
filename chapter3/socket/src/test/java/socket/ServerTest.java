package socket;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @since 15.04.2017
 * @version 0.1
 */
class ServerTest {

    /**
     * When user type only exit should check that app exits.
     * @throws IOException if file not found, or some io errors detected.
     */
    @Test
    void whenTryStartServerShouldCheckThatAllIsOk() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.start();
        assertEquals("Bye!", out.toString());
    }

    /**
     * When user type two message should check that server answer for it.
     * @throws IOException if some problem detected.
     */

    @Test
    void whenTryStartServerAndStartExchangeShouldCheckThatAllIsOk() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("Hello\nexit".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.start();
        assertTrue(out.toString().contains("Bye!") && out.toString().length() > 4);
    }
}