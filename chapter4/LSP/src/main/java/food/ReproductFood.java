package food;

/**
 * Model of recovery food.
 * It may be recovered.
 */
public class ReproductFood  {

    /**
     * Flag which determine may recovery this food.
     */
    protected boolean canReproduct;

    /**
     * Instance of food model.
     */
    private Food food;

    /**
     * Create a new reproduct food.
     * @param food intance of usually food.
     * @param canReproduct flag which determine may can reproduct this food.
     */
    public ReproductFood(Food food, boolean canReproduct) {
        this.food = food;
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

    /**
     * Return an info about food.
     * @return info about food in string view.
     */
    @Override
    public String toString() {
        String name = this.food.getName();
        String createTime = this.food.getStringViewOfTime(this.food.getCreateTime());
        String expaireTime = this.food.getStringViewOfTime(this.food.getExpairDate());
        double price = this.food.getPrice();
        int discount = this.food.getDiscount();

        return String.format("Name:%s\nWas added: %s\nExpair date: %s\nPrice: %s\nDiscount: %s\nCan reproduct: %s",name, createTime,
                expaireTime, price, discount, this.canReproduct);
    }

    /**
     * Get discount for this food.
     * @return size of discount.
     */
    public int getDiscount() {
        return this.food.getDiscount();
    }

    /**
     * Return an name of food.
     * @return name of food.
     */
    public String getName() {
        return this.food.getName();
    }

    /**
     * Return a price for this food.
     * @return price for this food.
     */
    public double getPrice() {
        return this.food.getPrice();
    }

    /**
     * Return result of calculation of fitness.
     * @return degree of food fresh.
     */
    public int calculateFitness() {
        return this.food.calculateFitness();
    }
}
