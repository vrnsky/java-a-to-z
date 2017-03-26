package model;

import java.sql.Timestamp;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.03.2017
 *
 * This class is model of item.
 */
public class Item {

    /**
     * Unique per item number.
     */
    private int id;

    /**
     * Text description of item.
     */
    private String desc;

    /**
     * Time when item was created.
     */
    private Timestamp creationTime;

    /**
     * Flag which means that this items already done.
     */
    private boolean done;

    /**
     * Default constructor.
     */
    public Item() {
        this.creationTime = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Create a new item with given description.
     * @param desc text about item.
     */
    public Item(String desc) {
        this();
        this.desc = desc;
    }

    /**
     * Retrun id of this item.
     * @return unique number among all items.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for this item.
     * @param id new version of item.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return text about this item.
     * @return text about item.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set new description for this item.
     * @param desc new version of text.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Return time when item was created.
     * @return time when item was created.
     */
    public Timestamp getCreationTime() {
        return creationTime;
    }

    /**
     * Set new creation time.
     * @param creationTime new creation time.
     */
    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * Return true if this item already done, and false if not done.
     * @return true if item done, otherwise false.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Set new version of done flag.
     * @param done true - item has done, false - item has not done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
