package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This is music type model, such as rock, jaz, pop.
 */
public class MusicType {

    /**
     * Unique number.
     */
    private int id;

    /**
     * Text description of music type.
     */
    private String type;

    /**
     * Default constructor.
     * @param id unique number.
     * @param type description.
     */
    public MusicType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Return id of type.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for this music type.
     * @param id of this.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return description of this type.
     * @return this type.
     */
    public String getType() {
        return this.type;
    }
}
