package start;


/**
 * @author evrnsky
 * @version 0.1
 * @since 07.01.2017
 *
 * Implementation of vacancy model.
 */
public class Vacancy {

    /**
     * Unique number of vacancy.
     */
    private int id;

    /**
     * Title of the job offer.
     */
    private String title;

    /**
     * Requirements for job.
     */
    private String requirements;

    /**
     * Publish time of job offer.
     */
    private long publishTime;

    /**
     * Url to the forum.
     */
    private String url;

    /**
     * Create a new vacancy with specify data.
     * @param id unique number of vacancy.
     * @param title of job offer.
     * @param requirements for job offer.
     * @param publishTime time when job offer publish.
     * @param url to the forum.
     */
    public Vacancy(int id, String title, String requirements, long publishTime, String url) {
        this(title, requirements, publishTime, url);
        this.id = id;
    }

    /**
     * Create vacancy with specify data.
     * @param title of job offer.
     * @param requirements for job offer.
     * @param publishTime time when job offer when publish.
     * @param url to forum.
     */
    public Vacancy(String title, String requirements, long publishTime, String url) {
        this.title = title;
        this.requirements = requirements;
        this.publishTime = publishTime;
        this.url = url;
    }

    /**
     * Set unique number of vacancy.
     * @param id of vacancy.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return title of job offer.
     * @return title of job offer.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return requirements for job offer.
     * @return requirements for job offer.
     */
    public String getRequirements() {
        return requirements;
    }


    /**
     * Return time when vacany was published.
     * @return time of publishing vacancy.
     */
    public long getPublishTime() {
        return this.publishTime;
    }

    /**
     * Return url to the forum.
     * @return url to the forum.
     */
    public String getUrl() {
        return this.url;
    }

}
