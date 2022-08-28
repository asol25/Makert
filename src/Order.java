public class Order {

    //DO_NOT_EDIT_BELOW_THIS_LINE

    /**
     * amount of the order
     */
    protected double amount;

    /**
     * price of the order;
     */
    protected double price;

    /**
     * traderID of the order;
     */
    protected int traderID;

    /**
     * Constructor have three parameter.
     * @param amount Amount of the order.
     * @param price Price of the order.
     * @param traderID TraderID of the order
     */
    public Order(double amount, double price, int traderID) {
        this.amount = amount;
        this.price = price;
        this.traderID = traderID;
    }
}
