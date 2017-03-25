package model;

import java.sql.Timestamp;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.03.2017
 */
public class Item {

    private int id;
    private String desc;
    private Timestamp creationTime;
    private boolean done;

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
