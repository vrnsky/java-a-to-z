package storage;

import java.util.Random;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class User {

    private static final Random RN = new Random();
    private Integer amount;
    private String id;

    public User(int amount) {
        this.amount = amount;
        this.id = generateId();
    }

    public String getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private String generateId() {
        return String.format("%s", RN.nextInt(1000));
    }

}
