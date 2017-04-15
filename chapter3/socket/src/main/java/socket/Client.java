package socket;

import chat.Logger;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.EOFException;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * It is implementation of client for server.
 */

public class Client {

    /**
     * Flag for program doesn't answer on user input.
     */
    private static final String STOP = "stop";
    /**
     * Flag for program for start answer on user input.
     */
    private static final String CONTINUE = "continue";
    /**
     * Flag for program fro finish work.
     */
    private static final String FINISH = "finish";

    /**
     * Logic port. It is not hardware.
     */
    private static final int PORT = 3001;
    /**
     * IP address of localhost.
     */
    private static final String IP = "127.0.0.1";

    /**
     * For read data from server.
     */
    private BufferedReader input;

    /**
     * For write data to server.
     */
    private BufferedWriter output;

    /**
     * Logger instance, for write logs to file.
     */
    private Logger logger;

    /**
     * Silent mode - it flag which determine should we be silent.
     * Silent means that do not chat with server.
     */
    private boolean silentMode;

    /**
     * For reading user input.
     */
    private BufferedReader keyboard;

    /**
     * Socket for web exchange.
     */
    private Socket socket;

    /**
     * Stub for user input.
     */
    private InputStream userInput;

    /**
     * Path to the log file.
     */
    private String logPath;

    /**
     * Create a new client for exchange wit server.
     * @param socket instance of worker with server.
     * @param userInput instance of stream to collect user input.
     * @param logPath path to the temp log file.
     */
    public Client(Socket socket, InputStream userInput, String logPath) {
        this.socket = socket;
        this.userInput = userInput;
        this.logPath = logPath;
    }
    /**
     * Start client instance, it connect to server and start chat.
     */
    public void start() {
        try {
            logger = new Logger(this.logPath);
            this.setConnection();
            this.keyboard = new BufferedReader(new InputStreamReader(this.userInput));
            String userMessage = "";
            while (!FINISH.equalsIgnoreCase(userMessage = this.keyboard.readLine())) {
                logger.log(userMessage);
                if (STOP.equalsIgnoreCase(userMessage)) {
                    silentMode = true;
                } else if (CONTINUE.equalsIgnoreCase(userMessage)) {
                    silentMode = false;
                }
                if (!silentMode) {
                    chatWithServer(userMessage);
                }
            }
        } catch (SocketException exp) {
            System.out.println("Server reject you...");
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                keyboard.close();
                logger.close();
                input.close();
                output.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Set connection to the server.
     * @throws IOException if some socket or stream fails
     */
    private void setConnection() throws IOException {
         InputStream in = this.socket.getInputStream();
         OutputStream out = this.socket.getOutputStream();

         this.input = new BufferedReader(new InputStreamReader(in));
         this.output = new BufferedWriter(new OutputStreamWriter(out));
    }

    /**.
     * Send data to server and receive answer
     * Show answer in console.
     * @param userMessage - message for server.
     * @throws IOException is output or input fails.
     */
    private void chatWithServer(String userMessage) throws IOException {
        output.write(userMessage);
        output.flush();
        try {
            userMessage = input.readLine();
        } catch (EOFException exception) {
            System.out.println("Server not response!");
            output.close();
        }
        System.out.println(userMessage);
    }

    /**
     * Start client by send and receive data from console.
     * @param args keys and value for start app.
     * @throws IOException if io error detected.
     */
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName(IP);
        new Client(new Socket(address, PORT), System.in, FileUtils.getTempDirectoryPath()).start();
    }

}
