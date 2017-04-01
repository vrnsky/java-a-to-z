package find;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

/**
 * Find a file by mask.
 * @author vrnsky
 * @version 0.1
 */
public class FindByMask extends FindByName {

    /**
     * Check that given file have given mask.
     * @param file - file which will be check.
     * @param checkParam - string view of mask.
     * @return true if file approach mask and false otherwise.
     */
    @Override
    protected boolean check(File file, String checkParam) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + checkParam);
        return matcher.matches(Paths.get(file.getName()));
    }
}
