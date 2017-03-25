package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This is music type model, such as rock, jaz, pop.
 */
public class MusicType implements IDInterface {

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
     * Check that given object equals this.
     * @param o object for compare.
     * @return true if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this == o) {
            equals = true;
        }
        if (!(o instanceof MusicType)) {
            equals = false;
        }

        MusicType musicType = (MusicType) o;

        if (id != musicType.id) {
            equals = false;
        } else if (type.equals(musicType.type)) {
            equals = true;
        }
        return equals;
    }

    /**
     * Return hash code for this object.
     * @return unique hash code.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
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
