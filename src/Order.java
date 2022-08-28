public class Order {

    //DO_NOT_EDIT_BELOW_THIS_LINE

    /**
     * amount of the order
     *
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
     * @param amount Amount coins of the order.
     * @param price Price of the order.
     * @param traderID TraderID of the order
     */
    public Order(double amount, double price, int traderID) {
        this.amount = amount;
        this.price = price;
        this.traderID = traderID;
    }

    /**
    * Getter method for amount.
    * @return amount of the order set by the trader.
    */
    public double getAmount() {
        return this.amount;
    }

    /**
    * Getter method for price.
    * @return Price of the order set by the trader.
    */
    public double getPrice() {
        return this.price;
    }

    /**
    * Getter method for traderID.
    * @return traderID of the trader who is giving the order.
    */
    public int getTraderID() {
        return this.traderID;
    }
    
    /**
	 * Returns the dollars reserved for the order.
	 * @return amount * price
	 */
	public double getDollars() {
		return this.amount * this.price;
	}
}
