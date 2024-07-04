package socket;

import ru.evrnsky.chat.Answerer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementation of Server. It may send data to client also receive data to client.
 */
public class Server {

    /**
     * Logic port, is not hardware.
     */
    private static final int PORT = 3001;

    /**
     * Flag which signal about user finish change data with client.
     */
    private static final String FINISH = "exit";

    /**
     * For read data from client.
     */
    private BufferedReader input;
    /**
     * For write data to client.
     */
    private BufferedWriter  output;

    /**
     * Socket for exchange.
     */
    private final Socket socket;

    /**
     * Constructor for server.
     * @param socket instance of socket.
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Start server.
     */
    public void start() {
        try {
            Answerer answerer = new Answerer(Answerer.class.getClassLoader().getResourceAsStream("answers.txt"));
            String userMessage = "msg";
            this.setConnection();
            while (!userMessage.equalsIgnoreCase(FINISH)) {
                userMessage = input.readLine();
                if (userMessage.equalsIgnoreCase(FINISH)) {
                    userMessage = "Bye!";
                    output.write(userMessage);
                    output.flush();
                    break;
                } else {
                    userMessage = answerer.getRandomString();
                }
                output.write(userMessage);
                output.flush();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Wait a client and set with client connection.
     * @throws IOException if socket fails.
     */
    private void setConnection() throws IOException {
        InputStream socketInput = this.socket.getInputStream();
        OutputStream outputStream = this.socket.getOutputStream();
        input = new BufferedReader(new InputStreamReader(socketInput));
        output = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    /**
     * Entry point of server.
     * @param args - array of strings.
     */
    public static void main(String[] args)  {
        try (final Socket socket = new ServerSocket(3001).accept()) {
            new Server(socket);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}

