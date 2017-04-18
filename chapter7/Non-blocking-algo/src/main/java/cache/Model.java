package cache;

/**
 * @author evrnsky
 * @version 0.1
 * @since 29.11.2016
 * Simple model.
 */
public class Model {

    /**
     * Version of model, it declare volatile for thread safety.
     */
    private volatile int version;

    /**
     * Long of this model - by default it is time of creation.
     */
    private long id;

    /**
     * Default constructor.
     */
    public Model() {
        this.version = 0;
        this.id = System.currentTimeMillis();
    }

    /**
     * Incremental update of version for this model.
     */
    public void updateVersion() {
        this.version++;
    }

    /**
     * Return current version of this model.
     * @return current version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Return id of this model.
     * @return unqiue value for this model.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Set new id.
     * @param id new version of id.
     */
    public void setId(long id) {
        this.id = id;
    }
}
