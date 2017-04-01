package service;

/**
 * Base for all other start.
 * @author evrnsky
 * @version 1.0.
 */
public abstract class Base {

    /**
     * Unique string for each model.
     */
    private String id;

    /**
     * Create new base with given string id.
     * @param id string view of id.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Return id of current model.
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set a new id.
     * @param id new version of id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
