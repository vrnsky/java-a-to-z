package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 */
public class Address {

    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
