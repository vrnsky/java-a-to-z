package model;

import org.joda.time.DateTime;
import java.sql.Timestamp;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 *
 * Describe advert model in system.
 */
public class Advert {

    /**
     * Unique number among all adverts in system.
     */
    private int id;

    /**
     * Author of this adverts.
     */
    private User author;

    /**
     * Describe which car sell.
     */
    private Car car;

    /**
     * Flag which mean that car already sale.
     */
    private boolean sale;

    /**
     * Price for car.
     */
    private long price;

    /**
     * Time when advert was added.
     */
    private Timestamp timestamp;

    /**
     * URL to the photo file.
     */
    private String fileUrl;


    /**
     * Default constructor.
     */
    public Advert() {

    }

    /**
     * Create advert with given car.
     * @param car instance of car class.
     */
    public Advert(Car car) {
        this.car = car;
        this.sale = false;
    }

    /**
     * Create a ew advert with given car and user, price.
     * @param car instance of car.
     * @param author instance of author.
     * @param price for car.
     */
    public Advert(Car car, User author, long price) {
        this(car);
        this.author = author;
        this.price = price;
    }

    /**
     * Return id of this advert.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id.
     * @param id new id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return author of this advert.
     * @return user object which create this advert.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Set new author of this advert.
     * @param author instance of user class.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Return sell car.
     * @return car object which sell.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Set new car.
     * @param car new version of car.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Return price for this advert.
     * @return price for advert.
     */
    public long getPrice() {
        return price;
    }

    /**
     * Set new price.
     * @param price new version of price.
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * If true it means that car already sale, false - not yet sell.
     * @return true - sold, false - not sold yet.
     */
    public boolean getSale() {
        return sale;
    }

    /**
     * Set new sale flag.
     * @param sale true if advert already sell, false not sold yet.
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * Return time when advert was added to the system.
     * @return time when advert was added to the system.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Set new version of added time.
     * @param timestamp new version of time.
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Return url to the image.
     * @return url to the image.
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * Set new version of url.
     * @param fileUrl new version of url.
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }



    /**
     * Return text view of object.
     * @return text view of advert.
     */
    @Override
    public String toString() {
        DateTime publish = new DateTime(this.timestamp.getTime());
        String time = String.format("%s.%s.%s", publish.getDayOfMonth(), publish.getMonthOfYear(), publish.getYear());
        String alreadySale = this.sale ? "yes" : "no";
        return String.format("%s sale %s for %s. At this moment already sale:%s. This was publish %s",
                 this.author, this.car, this.price, alreadySale, time);
    }

}
