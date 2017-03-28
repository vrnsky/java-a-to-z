package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 *
 * Describe car model at the system.
 */
public class Car {

    /**
     * Unique number among all car.
     */
    private int id;

    /**
     * Car body, such as hatchback, coupe.
     */
    private CarInfo body;

    /**
     * Car producer such as Ford, Honda.
     */
    private CarInfo producer;

    /**
     * Car model such as Focus, Civic.
     */
    private CarInfo model;

    /**
     * URL to the photo file.
     */
    private String fileUrl;

    /**
     * Default constructor.
     */
    public Car() {
    }

    /**
     * Return id of this car.
     * @return id of this car.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for this car.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return body of this car.
     * @return body of this car.
     */
    public CarInfo getBody() {
        return body;
    }

    /**
     * Set new body to the car.
     * @param body new version of body.
     */
    public void setBody(CarInfo body) {
        this.body = body;
    }

    /**
     * Return producer.
     * @return producer.
     */
    public CarInfo getProducer() {
        return producer;
    }

    /**
     * Set new producer for this car.
     * @param producer instance of producer class.
     */
    public void setProducer(CarInfo producer) {
        this.producer = producer;
    }

    /**
     * Return model for this.
     * @return model of car.
     */
    public CarInfo getModel() {
        return model;
    }

    /**
     * Set new model for this.
     * @param model new version of model.
     */
    public void setModel(CarInfo model) {
        this.model = model;
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
     * Return text view of this.
     * @return text view of the object.
     */
    @Override
    public String toString() {
        return String.format("%s %s %s", producer.toString(), model.toString(), body.toString());
    }
}