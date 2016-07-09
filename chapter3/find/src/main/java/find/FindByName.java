package find;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Search file by name
 */
public class FindByName {

    /**
     * It is directory. Will start search file from it
     */
    private String directory;

    /**
     * Name of searching file
     */
    private String fileName;

    /**
     * File for writing results
     */
    private String resultFile;

    /**
     * Main method which handle input values and set
     * needed variables for search and start find
     * @param values - values for handling
     */
    public void find(String[] values) {
        this.directory = values[1];
        this.fileName = values[3];
        this.resultFile = values[6];
        find(directory, fileName);
    }

    /**
     * Recursive find file
     * @param directory - from it will start search
     * @param fileName - name of file which search
     */
    private void find(String directory, String fileName) {
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                 find(file.getAbsolutePath(), fileName);
            } else if (check(file, fileName)) {
               saveResult(String.format("%s was found at %s", this.fileName,file.getAbsoluteFile()), this.resultFile);
            } else  {
                saveResult(String.format("%s was not found at %s", this.fileName, file.getAbsolutePath()), this.resultFile);
            }
        }

    }

    /**
     * Write result to file
     * @param fileResult name of file
     * @param destination path to file result
     */
    private void saveResult(String fileResult, String destination) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(destination),true))) {
            writer.write(fileResult);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch(IOException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Check that given file it is searching file
     * @param file - file which will be check
     * @param checkParam - at this place it is name
     * @return true if file have name which equals checkParam, otherwise false
     */
    protected boolean check(File file, String checkParam) {
        return file.getName().equals(checkParam);
    }


}
