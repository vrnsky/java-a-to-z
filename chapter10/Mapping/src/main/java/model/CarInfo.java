package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 *
 * Describe information about car.
 */
public abstract class CarInfo {
    /**
     * Unique number.
     */
    private int id;

    /**
     * Name of property.
     */
    private String name;

    /**
     * Default constructor.
     */
    public CarInfo() {
    }

    /**
     * Create a car info with given name.
     * @param name of car info.
     */
    public CarInfo(String name) {
        this.name = name;
    }

    /**
     * Return id of this property.
     * @return id of this property.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for this..
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return name.
     * @return name of this.
     */
    public String getName() {
        return name;
    }

    /**
     * Set new version of name.
     * @param name new version of this.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return text view.
     * @return text view of this.
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
