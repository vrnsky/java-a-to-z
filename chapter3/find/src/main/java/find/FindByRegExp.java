package find;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find file by regular expression.
 * @author vrnsky.
 * @version 0.1
 */
public class FindByRegExp extends FindByName {

    /**
     * Check that file it is searching file.
     * @param file - file which will be check.
     * @param checkParam - at this place it is regular expression.
     * @return true if name of file approach to the regexp, and otherwise false.
     */
    @Override
    public boolean check(File file, String checkParam) {
        Pattern pattern = Pattern.compile(checkParam);
        Matcher matcher = pattern.matcher(file.getName());
        return matcher.matches();
    }
}
