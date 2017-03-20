package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This is model of address.
 */
public class Address {

    /**
     * Unique number per each address.
     */
    private int id;

    /**
     * Country.
     */
    private String country;

    /**
     * City.
     */
    private String city;

    /**
     * Default constructor.
     * @param id unique number.
     * @param country country.
     * @param city city.
     */
    public Address(int id,String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    /**
     * Return id of address.
     * @return id of this address.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set new id.
     * @param id new.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return country for this address.
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Return city.
     * @return city.
     */
    public String getCity() {
        return city;
    }
}
