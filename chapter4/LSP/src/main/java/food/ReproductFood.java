package food;

import java.util.Calendar;

/**
 * Model of recovery food.
 * It may be recovered.
 */
public class ReproductFood extends Food {

    /**
     * Flag which determine may recovery this food.
     */
    protected boolean canReproduct;

    /**
     * Create a new food.
     * @param name of food.
     * @param createTime time of creating.
     * @param expairDate time when food is destroy.
     * @param price for food.
     * @param discount if product is not fresh may set discount.
     */
    public ReproductFood(String name, Calendar createTime, Calendar expairDate, double price, int discount, boolean canReproduct) {
        super(name, createTime, expairDate, price, discount);
        this.canReproduct = canReproduct;
    }

    /**
     * Return may or not recovery this food.
     * @return true or false.
     */
    public boolean getRecovery() {
        return this.canReproduct;
    }

    /**
     * Set a recovery flag.
     * @param canReproduct true for may recovery operation, otherwise false.
     */
    public void setRecovery(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    @Override
    public String toString() {
        String name = super.getName();
        String createTime = super.getStringViewOfTime(super.getCreateTime());
        String expaireTime = super.getStringViewOfTime(super.getExpairDate());
        double price = super.getPrice();
        int discount = super.getDiscount();

        return String.format("Name:%s\nWas added: %s\nExpair date: %s\nPrice: %s\nDiscount: %s\nCan reproduct: %s",name, createTime,
                expaireTime, price, discount, this.canReproduct);
    }
}
