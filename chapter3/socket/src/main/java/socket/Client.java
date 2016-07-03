package socket;

import chat.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * It is implementation of client for server
 */

public class Client {

    /**
     * Flag for program doesn't answer on user input
     */
    private static final String STOP = "стоп";
    /**
     * Flag for program for start answer on user input
     */
    private static final String CONTINUE = "продолжить";
    /**
     * Flag for program fro finish work
     */
    private static final String FINISH = "закончить";

    /**
     * Logic port. It is not hardware
     */
    private static final int PORT = 3001;
    /**
     * IP address of localhost
     */
    private static final String IP = "127.0.0.1";

    /**
     * Special object for construct socket
     */
    private InetAddress ipAddress;

    /**
     * Socket which connect to server
     */
    private Socket clientSocket;

    /**
     * Input stream of socket
     */
    private InputStream inputSocket;

    /**
     * Output stream of socket
     */
    private OutputStream outputSocket;

    /**
     * For read data from server
     */
    private DataInputStream input;

    /**
     * For write data to server
     */
    private DataOutputStream output;

    /**
     * Logger instance, for write logs to file
     */
    private Logger logger;

    /**
     * Silent mode - it flag which determine
     * Should we be silent. Silent means that
     * do not chat with server
     */
    private boolean silentMode;

    /**
     * For reading user input
     */
    private BufferedReader keyboard;

    /**
     * Start client by send and receive data from console
     * @param args
     */
    public static void main(String[] args) {
       new Client().start();
    }

    /**
     * Start client instance, it connect to server
     * and start chat
     */
    private void start() {
        try {
            logger = new Logger("myLog.txt");
            this.setConnection();
            this.keyboard = new BufferedReader(new InputStreamReader(System.in));
            String userMessage = null;
             do {
                userMessage = keyboard.readLine();
                logger.log(userMessage);
                if((FINISH.equalsIgnoreCase(userMessage)))
                    break;
                if (STOP.equalsIgnoreCase(userMessage))
                    silentMode = true;
                else if (CONTINUE.equalsIgnoreCase(userMessage))
                    silentMode = false;
                if (!silentMode)
                    chatWithServer(userMessage);
            } while(true);


        } catch (SocketException exp) {
            System.out.println("Server reject you...");
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                keyboard.close();
                logger.close();
            } catch(IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Set connection to the server
     * @throws IOException if some socket or stream fails
     */
    private void setConnection() throws IOException {
         ipAddress = InetAddress.getByName(IP);
         clientSocket = new Socket(ipAddress, PORT);

         inputSocket = clientSocket.getInputStream();
         outputSocket = clientSocket.getOutputStream();

         input = new DataInputStream(inputSocket);
         output = new DataOutputStream(outputSocket);
    }

    /**
     * Send data to server and receive answer
     * Show answer in console
     * @param userMessage - message for server
     * @throws IOException is output or input fails
     */
    private void chatWithServer(String userMessage) throws IOException {
        output.writeUTF(userMessage);
        output.flush();
        userMessage = input.readUTF();
        System.out.println(userMessage);
    }

}
