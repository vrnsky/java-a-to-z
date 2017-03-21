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

    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this == o) {
            equals = true;
        }
        if (!(o instanceof Address)) {
            equals = false;
        }

        Address address = (Address) o;

        if (id != address.id) {
            equals = false;
        }
        if (!country.equals(address.country)) {
            equals = false;
        } else if (city.equals(address.city) && country.equals(address.country) && address.id == this.id) {
            equals = true;
        }
        return equals;
    }

    /**
     * Hash code for object, depend on id, country and city.
     * @return unique hash code.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        return result;
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
