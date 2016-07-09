package find;

/**
 * Entry point in application create need finder depending on key
 */
public class Finder {

    /**
     * Entry point of application
     * @param args - keys and values from user
     * @throws Exception for show alerts
     */
    public static void main(String[] args) throws Exception {
        new Finder().startFind(args);
    }


    /**
     * Start find a file by name, mask or regexp
     * @param args - keys and values
     */
    public void startFind(String[] args) {
        KeysValidator validator = new KeysValidator();
        if(validator.isValidKeys(args)) {
            String findParam = args[4];
            if(findParam.equals("-m")) {
                FindByMask finder = new FindByMask();
                finder.find(args);
            } else if(findParam.equals("-f")) {
                FindByName finder = new FindByName();
                finder.find(args);
            } else if(findParam.equals("-r")) {
                FindByRegExp finder = new FindByRegExp();
                finder.find(args);
            }
        }
    }

}
