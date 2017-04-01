package model;

import java.util.Random;

/**
 * Implementation of common item in tracker app.
 */
public class Item {


    /**
     * Length of comments for item.
     */
    private static final int COMMENTS_LENGTH = 10;

    /**
     * For generate random number for id.
     */
    private static final Random RN = new Random();

    /**
     * Unique string for each item.
     */
    private final String id;
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
     * Comments for item.
     */
    private Comment[] comments;

    /**
     * For correct adding new comment should use pointer.
     */
    private int commentPointer = 0;


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
        id = generateId();
        this.name = itemName;
        this.description = desc;
        comments = new Comment[COMMENTS_LENGTH];
        createTime = System.currentTimeMillis();
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
     * Add a comment to this item.
     * @param comment comment instance of comment model.
     */
    public final void addComment(final Comment comment) {
        comments[commentPointer++] = comment;
    }

    /**
     * Return all comment which not null for current item.
     * @return array of comments.
     */
    public final Comment[] getComments() {
        Comment[] result;
        int size = 0;

        for (Comment comment : comments) {
            if (comment != null) {
                size++;
            }
        }

        result = new Comment[size];

        for (int index = 0; index < size; index++) {
            Comment current = comments[index];
            if (current != null) {
                result[index] = current;
            }
        }

        return result;
    }


    /**
     * Generate a unique string.
     * @return unique value string.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
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
