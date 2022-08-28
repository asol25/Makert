public class BuyingOrder extends Order implements Comparable<BuyingOrder> {

    /**
     * Overrides to compareTo method to return the BuyingOrder that has the highest price.
     * If two orders have the same price then you get the BuyingOrder which has the highest amount.
     * If it is still the same, you get the BuyingOrder that has the lowest tradersID.
     * @param trader Other BuyingOrder.
     * @return 1 if this BuyingOrder is of top priority, -1 if the other BuyingOrder is of top priority, 0 if they have the same priority.
     */
    @Override
    public int compareTo(BuyingOrder trader) {
        if(price < trader.price)
            return -1;
        if (price > trader.price)
            return 1;
        if(amount > trader.amount)
            return -1;
        if (amount < trader.amount)
            return 1;
        if(traderID < trader.traderID)
            return -1;
        if (traderID > trader.traderID)
           return 1;
        return 0;
    }


    /**
     * Constructor with 3 parameters.
     * @param traderID ID of the trader who is giving the buying order.
     * @param amount Quantity reserved for the buying order.
     * @param price Price of the buying order set by the buying trader.
     */
    public BuyingOrder(double amount, double price, int traderID) {
        super(amount, price, traderID);
    }
}
