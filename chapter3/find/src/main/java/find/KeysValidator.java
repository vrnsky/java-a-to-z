package find;

/**
 * Validator for input keys, it check input keys with list of existing key.
 */
public class KeysValidator {

    /**
     * All valid keys hold at this constant.
     */
    private static final String[] validKeys = new String[]{"-d","-n","-m","-o","-f","-r"};

    /**
     * Description for all valid keys.
     */
    private static final String[] descKeys = new String[]{
            "Use for specify directory",
            "Use for for specify name of file, or regular expression, or mask of file",
            "Use for search file by mask",
            "Use for search file by name",
            "Use for search by regular expression",
            "Use for specify file for write result"
    };

    /**
     * Count key which not valid.
     */
    private int badKey = 0;

    /**
     * It is uses for collect bad key and show user what is wrong.
     */
    private StringBuffer hint = new StringBuffer();

    /**
     * Check all keys at the input, if some one key invalid return a false.
     * Also show hint to user which point to wrong keys.
     * @param keys - array of string with key and value, but check only key.
     * @return true if key is valid and false if it invalid.
     */
    public boolean isValidKeys(String[] keys) {
        boolean valid = false;
        for(String key : keys) {
            if(key.startsWith("-")) {
                valid = keyExist(key);
                if(!valid) {
                    badKey++;
                    hint.append(String.format("%s - it is bad key, please choose correct key\n", key));
                }
            }
        }
        if(badKey != 0) {
            System.out.println(hint.toString());
            showValidKeys();
        }
        return badKey == 0;
    }

    /**
     * Check that key exist.
     * @param key key for checking.
     * @return true if key exist and false if key not exist.
     */
    private boolean keyExist(String key) {
        boolean exist = false;
        for(String valid : validKeys) {
            if(key.equals(valid))
                exist = true;
        }
        return exist;
    }

    /**
     * Show all valid keys in console.
     * And show that its means.
     */
    private void showValidKeys() {
        System.out.println("List of valid keys");
       for(int index = 0; index < validKeys.length; index++) {
           System.out.println(String.format("%s - %s",validKeys[index],descKeys[index]));
       }
    }


}
