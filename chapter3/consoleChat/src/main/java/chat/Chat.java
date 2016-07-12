package chat;

import java.io.*;

/**
 * Implementation of console chat.
 */
public class Chat {

    /**
     * Flag for program doesn't answer on user input.
     */
    private static final String STOP = "стоп";
    /**
     * Flag for program for start answer on user input.
     */
    private static final String CONTINUE = "продолжить";
    /**
     * Flag for program fro finish work.
     */
    private static final String FINISH = "закончить";

    /**
     * All actions at this method. It takes user input, handle it by answering
     * and log, also solve set flag of start/finish silentMode.
     * @throws IOException if file for answer was not found.
     */
    public void startChat() throws IOException {
        Answerer answerer = new Answerer("answers.txt");
        Logger logger = new Logger("log.txt");

        boolean silentMode = false;
        String userMessage = "";
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while(!FINISH.equalsIgnoreCase(userMessage = keyboard.readLine())) {
            logger.log(userMessage);

            if(STOP.equalsIgnoreCase(userMessage))
                silentMode = true;
            else if(CONTINUE.equalsIgnoreCase(userMessage))
                silentMode = false;

            if(!silentMode) {
                String answer = answerer.getRandomString();
                System.out.println(answer);
                logger.log(answer);
            }
        }
        keyboard.close();
        logger.close();
    }
}
