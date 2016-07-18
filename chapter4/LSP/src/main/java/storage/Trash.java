package storage;

/**
 * Created by Egor on 18.07.2016.
 */
public class Trash extends Storage {

    public Trash(int capacity) {
        super(capacity);
    }

    public Trash() {
        this(100);
    }

    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the trash:\n" + this.buffer.toString();
    }
}
