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
    private Producer producer;

    /**
     * Default constructor.
     */
    public Model() {
        super();
    }

    /**
     * Return producer of this model.
     * @return producer of this model.
     */
    public Producer getProducer() {
        return producer;
    }

    /**
     * Set new producer of this model.
     * @param producer new version of producer.
     */
    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
