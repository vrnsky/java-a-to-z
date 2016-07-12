package socket;

import chat.Answerer;

import java.io.*;
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
    private static final String FINISH = "закончить";

    /**
     * It need for read string from file and get random string from it.
     */
    private Answerer answerer;

    /**
     * Socket for server, which wait a client.
     */
    private ServerSocket serverSocket;
    /**
     * Socket from client, which may send to server some data and get data from server.
     */
    private Socket clientSocket;

    /**
     * For accept data from client need get input stream from socket.
     */
    private InputStream socketInput;

    /**
     * For send data to client need get output stream from socket.
     */
    private OutputStream outputStream;

    /**
     * For read data from client.
     */
    private DataInputStream input;
    /**
     * For write data to client.
     */
    private DataOutputStream  output;

    /**
     * Entry point of server.
     * @param args - array of strings.
     */
    public static void main(String[] args) {
        new Server().start();
    }

    /**
     * Start server.
     */
    public void start() {
        try {
            Answerer answerer = new Answerer("answers.txt");
            String userMessage;
            this.setConnection();
            while (!FINISH.equalsIgnoreCase(userMessage = input.readUTF())) {
                userMessage = answerer.getRandomString();
                output.writeUTF(userMessage);
                output.flush();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Wait a client and set with client connection.
     * @throws IOException if socket fails.
     */
    private void setConnection() throws IOException {
        serverSocket = new ServerSocket(PORT);
        clientSocket = serverSocket.accept();
        socketInput = clientSocket.getInputStream();
        outputStream = clientSocket.getOutputStream();
        input = new DataInputStream(socketInput);
        output = new DataOutputStream(outputStream);
    }

}

