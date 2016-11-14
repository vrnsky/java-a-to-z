package models;

/**
 * Model of a comment.
 */
public class Comment {

    /**
     * Text of comment.
     */
    private final String text;


    /**
     * Constructor for comment.
     * @param comment it is text of comment.
     */
    public Comment(final String comment) {
        this.text = comment;
    }

    /**
     * This method call when we need to print this object.
     * @return string view of this object.
     */
    @Override
    public final String toString() {
        return String.format("Comment: %s", this.text);
    }
}
