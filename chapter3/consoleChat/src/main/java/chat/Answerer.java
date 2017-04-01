package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Random;

/**
 * It is read data from file and hold it in string array.
 */
public class Answerer {

    /**
     * For find random string.
     */
    private static final Random RN = new Random();
    /**
     * For read data from file.
     */
    private BufferedReader answerReader;
    /**
     * For holding string from file.
     */
    private String[] answers;
    /**
     * For hold file name.
     */
    private String fileName;
    /**
     * For hold count of string in file.
     */
    private int stringCount;

    /**
     * Construct answerer object for give answer.
     * @param fileName - name of file with answers.
     * @throws IOException - throw if file was not found.
     */
    public Answerer(String fileName) throws IOException {
        this.fileName = fileName;
        this.answerReader = new BufferedReader(new FileReader(new File(fileName)));
        stringCount = countAnswerInFile();
        fillAnswers();
        answerReader.close();
    }

    /**
     * Count strings in files.
     * @return count of string in file.
     */
    private int countAnswerInFile() {
        int stringCount = 0;
        try {
            while (answerReader.ready()) {
                if (!answerReader.readLine().isEmpty()) {
                    stringCount++;
                } else {
                    break;
                }
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        answerReader = null;
        return stringCount;
    }

    /**
     * Fill answers array by strings from file.
     * @throws IOException throw if file was not found.
     */
    private void fillAnswers() throws IOException {
        answers = new String[stringCount];
        answerReader = new BufferedReader(new FileReader(new File(fileName)));
        int position = 0;

        try {
            while (answerReader.ready() && position < stringCount) {
                answers[position++] = answerReader.readLine();
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Return random string from array which contains strings from file.
     * @return random string from file.
     */
    public String getRandomString() {
        int position = RN.nextInt(answers.length);
        return answers[position];
    }

    /**
     * Return all string from file.
     * @return strings from file.
     */
    public String[] getAllStrings() {
        return this.answers;
    }
}
