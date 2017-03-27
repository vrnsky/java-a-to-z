package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 */
public class Advert {

    private int id;
    private User author;
    private Car car;
    private boolean sale;

    public Advert() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
