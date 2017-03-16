package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 *
 * This is simple address structure.
 */
public class Address {

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
     * @param country country.
     * @param city city.
     */
    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /**
     * Return this country.
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Return this city.
     * @return this city.
     */
    public String getCity() {
        return city;
    }
}
