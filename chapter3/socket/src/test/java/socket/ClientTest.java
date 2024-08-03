package socket;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author vrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 15.04.2017
 */
class ClientTest {


    /**
     * When try to start chat from client should check that all is ok.
     * @throws Exception if i/o error detected.
     */
    @Test
    void whenTryStartClientShouldCheckThatClientWasPushedDataToServer() throws Exception {
        Socket socket = mock(Socket.class);
        File temp = File.createTempFile("logger", ".txt");
        ByteArrayInputStream userInput = new ByteArrayInputStream("finish".getBytes());
        ByteArrayInputStream clientInputStream = new ByteArrayInputStream("asd".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Client client = new Client(socket, userInput, temp.getAbsolutePath());
        when(socket.getInputStream()).thenReturn(clientInputStream);
        when(socket.getOutputStream()).thenReturn(outputStream);
        client.start();
        assertEquals("", outputStream.toString());
    }
}