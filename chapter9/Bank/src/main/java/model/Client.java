package model;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.03.2017
 *
 * This is model of client.
 */
public class Client  {

    /**
     * Instance of logger for checking time in and time out of client.
     */
    private static final Logger LOG = Logger.getLogger(Client.class);

    /**
     * At this time client came in bank.
     */
    private long timeIn;

    /**
     * At this time client go out from bank.
     */
    private long timeOut;

    /**
     * Create client with given time in and time out params.
     * @param timeIn time in which client came at the bank.
     * @param timeOut time in which client go out from bank.
     */
    public Client(long timeIn, long timeOut) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        LOG.log(Level.INFO, this.toString());
    }

    /**
     * Return time in of client.
     * @return time in of client.
     */
    public long getTimeIn() {
        return this.timeIn;
    }

    /**
     * Return time out of client.
     * @return time out of client.
     */
    public long getTimeOut() {
        return this.timeOut;
    }

    /**
     * Readable version of client object.
     * @return text view of object.
     */
    @Override
    public String toString() {
        DateTime comeTime = new DateTime(timeIn);
        DateTime outTime = new DateTime(timeOut);
        return String.format("Client came at %s and out at %s", comeTime, outTime);
    }
}
