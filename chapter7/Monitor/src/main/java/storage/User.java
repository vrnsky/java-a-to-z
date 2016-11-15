package storage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class User {

    /**
     * Generator for random sequence.
     */
    private static final Random RN = new Random();

    /**
     * Normal range for id.
     */
    private static final int NORMAL_RANGE = 1000;

    /**
     * Amount of user.
     */
    private AtomicInteger amount;

    /**
     * Unique string per user.
     */
    private String id;

    /**
     * Create a new user.
     * @param userAmount some data for user.
     */
    public User(int userAmount) {
        this.amount = new AtomicInteger(userAmount);
        this.id = generateId();
    }

    /**
     * Return unique string per user.
     * @return unique string.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Return amount of user.
     * @return amount of user.
     */
    public int getAmount() {
        return this.amount.get();
    }

    /**
     * Set amount of user.
     * @param newAmount for user.
     */
    public void setAmount(int newAmount) {
        this.amount.set(newAmount);
    }

    /**
     * Help method which generate unique sequnce for user.
     * @return id of user.
     */
    private String generateId() {
        return String.format("%s", RN.nextInt(NORMAL_RANGE));
    }

}
