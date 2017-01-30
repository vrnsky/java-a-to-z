package start;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of common item in tracker app.
 */

public class Item {

    /**
     * Unique string for each item.
     */

    private String id;
    /**
     * Name of item.
     */
    private String name;

    /**
     * Description of item.
     */
    private String description;

    /**
     * Time when item was created.
     */
    private long createTime;

    /**
     * List of comments for this item.
     */
    private List<Comment> comments;


    /**
     * Default constructor.
     */
    public Item() {
        this("Edit me now", "Empty item");
    }

    /**
     * Create a item with given params.
     * @param itemName name of item.
     * @param desc description of item.
     */
    public Item(final String itemName, final String desc) {
        this.name = itemName;
        this.description = desc;
        comments = new ArrayList<>();
        createTime = System.currentTimeMillis();
    }

    /**
     * Constructor for create already in database items.
     * @param id unique number per item.
     * @param itemName name of item.
     * @param desc full description of item.
     * @param createTime time when item was created.
     */
    public Item(final String id, final String itemName, final String desc, final long createTime) {
        this(itemName, desc);
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * Update id of the item.
     * @param id new version.
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Return id of current item.
     * @return it is unique string for each item.
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Return a name of item.
     * @return name of current item.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Set a name of item.
     * @param newName new name of item.
     */
    public final void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Return a description of item.
     * @return description of current item.
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * Set a description of item.
     * @param newDescription new desc for item.
     */
    public final void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * Return a time of creating.
     * @return time when item will be created.
     */
    public final long getCreateTime() {
        return createTime;
    }

    /**
     * Set up creation time of item.
     * @param createTime new version of creation time.
     */
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /**
     * Add a comment to this item.
     * @param comment comment instance of comment model.
     */
    public final void addComment(final Comment comment) {
        this.comments.add(comment);
    }

    /**
     * Return all comment which not null for current item.
     * @return array of comments.
     */
    public final List<Comment> getComments() {
        return this.comments;
    }


    /**
     * Use this method if you want display data about item.
     * @return important data about item.
     */
    @Override
    public final String toString() {
        return String.format("Id:%s\tName:%s\nDesc:%s",
                             this.id, this.name, this.description);
    }

}
