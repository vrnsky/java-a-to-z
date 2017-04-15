package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> answers;
    /**
     * For hold file name.
     */
    private InputStream fileStream;
    /**
     * For hold count of string in file.
     */
    private int stringCount;

    /**
     * Construct answerer object for give answer.
     * @param inputStream - stream to the file.
     * @throws IOException - throw if file was not found.
     */
    public Answerer(InputStream inputStream) throws IOException {
        this.fileStream = inputStream;
        this.answerReader = new BufferedReader(new InputStreamReader(inputStream));
        this.answers = new ArrayList<>();
        this.loadData();
        answerReader.close();
    }

    /**
     * Construct answerer object for give answer from file.
     * @param file path to the fie.
     * @throws IOException if error occured at the open, reading or closing stream.
     */
    public Answerer(String file) throws IOException {
        this.answerReader = new BufferedReader(new FileReader(new File(file)));
        this.answers = new ArrayList<>();
        this.loadData();
        this.answerReader.close();
    }

    /**
     * Read and store data.
     */
    private void loadData() {
        try {
            while (answerReader.ready()) {
                String line = answerReader.readLine();
                if (!line.isEmpty()) {
                    answers.add(line);
                }
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        } finally {
            try {
                this.answerReader.close();
                if (fileStream != null) {
                    this.fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Return random string from array which contains strings from file.
     * @return random string from file.
     */
    public String getRandomString() {
        int position = RN.nextInt(answers.size());
        return answers.get(position);
    }

    /**
     * Return all string from file.
     * @return strings from file.
     */
    public List<String> getAllStrings() {
        return this.answers;
    }
}
