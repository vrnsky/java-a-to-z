package storage;

/**
 * Model of Trash.
 */
public class Trash extends Storage {

    /**
     * Create trash with given capacity
     * @param capacity count of food in trash.
     */
    public Trash(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor.
     */
    public Trash() {
        this(100);
    }

    /**
     * Return a string view of content in trash.
     * @return string view of content in trash.
     */
    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the trash:\n" + this.buffer.toString();
    }
}
