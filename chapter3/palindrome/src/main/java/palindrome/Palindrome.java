package palindrome;

import start.IO;

/**
 * Check that string from user is palindrome.
 */
public class Palindrome {

    /**
     * Instance of io interface for handle input and output.
     */
    private IO io;

    /**
     * For using at this class we need reference on instance of IO interface.
     * @param io implementation of io interface.
     */
    public Palindrome(IO io) {
        this.io = io;
    }

    /**
     * Check that string entered user is palindrome.
     * @return true if string is palindrome, otherwise false.
     */
    public boolean isPalindrome() {
        boolean isPalindrome = false;
        String userInput = handleInput();
        char[] charsUser = userInput.toCharArray();
        for(int index = 0; index <= charsUser.length / 2; index++) {
            if(charsUser[index] != charsUser[charsUser.length - index - 1]) {
                isPalindrome = false;
            } else {
                isPalindrome = true;
            }
        }
        this.io.println("User input is palindrome: " + isPalindrome);
        return isPalindrome;
    }

    /**
     * Handling input by checking that user entered not empty string and string length is 5.
     * @return - correct string in lower case for correct compare by chars.
     */
    private String handleInput() {
        String input = "";
        boolean invalid = true;
        do {
            input = this.io.ask("Enter a palindrome: ");
            if(!input.isEmpty() && input.length() == 5) {
                invalid = false;
            } else {
              this.io.println("You made mistake: in words must be 5 letters");
            }
        } while(invalid);

        return input.toLowerCase();
    }
}
