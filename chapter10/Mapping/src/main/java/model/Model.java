package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 */
public class Model extends CarInfo {

    /**
     * Producer.
     */
    private CarInfo producer;

    /**
     * Default constructor.
     */
    public Model() {
        super();
    }

    /**
     * Create a new model with given name.
     * @param name of model.
     */
    public Model(String name) {
        super(name);
    }

    /**
     * Return producer of this model.
     * @return producer of this model.
     */
    public CarInfo getProducer() {
        return producer;
    }

    /**
     * Set new producer of this model.
     * @param producer new version of producer.
     */
    public void setProducer(CarInfo producer) {
        this.producer = producer;
    }
}
