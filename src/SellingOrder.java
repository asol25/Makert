public class SellingOrder extends Order implements Comparable<SellingOrder>{
    /**
     * Overrides to compareTo method to return the BuyingOrder that has the highest price.
     * If two orders have the same price then you get the BuyingOrder which has the highest amount.
     * If it is still the same, you get the BuyingOrder that has the lowest tradersID.
     * @param trader Other SellingOrder.
     * @return 1 if this SellingOrder is of top priority, -1 if the other SellingOrder is of top priority, 0 if they have the same priority.
     */
    @Override
    public int compareTo(SellingOrder trader) {
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
     * Constructor have three parameter.
     * @param amount Quantity of trader given to set in selling order.
     * @param price Price of trader given to set in selling order.
     * @param traderID TraderID of trader who is given for selling order.
     */
    public SellingOrder(double amount, double price, int traderID) {
        super(amount, price, traderID);
    }
}
