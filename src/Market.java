import java.util.ArrayList;
import java.util.PriorityQueue;

public class Market {

    /**
     * A PriorityQueue which holds buying order in the market.
     */
    private PriorityQueue<BuyingOrder> buyingOrders;

    /**
     * A PriorityQueue which holds selling order in the market.
     */
    private PriorityQueue<SellingOrder> sellingOrders;

    /**
     * A ArrayList which holds transaction in the market.
     */
    private ArrayList<Transaction> transaction;

    /**
     * An ArrayList which holds the traders in the market.
     */
    private ArrayList<Trader> traders;

    /**
     * nameOfMarket of the market
     */
    public int market;

    /**
     *Total number of successful transactions.
     */
    private int no_successful_transaction;

    /**
     * Constructor have one parameter.
     * @param key Name of the market object.
     */
    public Market(int key) {
        this.market = key;
        this.no_successful_transaction = 0;

        this.buyingOrders = new PriorityQueue<BuyingOrder>();
        this.sellingOrders = new PriorityQueue<SellingOrder>();
        this.transaction = new ArrayList<Transaction>();
        this.traders = new ArrayList<Trader>();
    }

    /**
     * Getter method of Market.
     * @return Market object
     */
    public int getMarket() {
        return market;
    }


    /**
     * The system makes an open market operation buying or selling orders
     * in order to set the price for coins to the given price.
     * @param price The given price.
     */
    public void makeOpenMarketOperation(double price) {
        while (buyingOrderPrice() >= price && !this.buyingOrders.isEmpty()) {
            BuyingOrder b_order = buyingOrders.peek();
            givenSellOrder(new SellingOrder(b_order.getAmount(), price, b_order.getTraderID()));
            checkTransactions(traders);
        }

        while (sellingOrderPrice() >= price && !this.sellingOrders.isEmpty()) {
            SellingOrder s_order = sellingOrders.peek();
            givenSellOrder(new SellingOrder(s_order.getAmount(), s_order.getPrice(), s_order.getTraderID()));
            checkTransactions(traders);
        }
    }

    /**
     * Checks whether the prices at the coins are overlapping.
     * If there is an overlap, the market should make transactions with the top of Coins, until there is no overlapping.
     * After handling all of the overlaps, then the method handles all the transactions.
     * @param traders An ArrayList which holds the traders in the market.
     */
    public void checkTransactions(ArrayList<Trader> traders) {
        boolean checkedEmpty = !this.buyingOrders.isEmpty() && !this.sellingOrders.isEmpty();
        while (buyingOrderPrice() >= sellingOrderPrice() && checkedEmpty) {
            BuyingOrder b_order = buyingOrders.poll();
            SellingOrder s_order = sellingOrders.poll();

            double traded_amount;

            assert s_order != null;
            assert b_order != null;

            if(s_order.getAmount() > b_order.getAmount()) {
                traded_amount = b_order.getAmount();
                double amount = s_order.getAmount() - traded_amount;
                sellingOrders.add(new SellingOrder(amount,
                        s_order.getPrice(),
                        s_order.getTraderID()));
            }
            else if (s_order.getAmount() < b_order.getAmount()) {
                traded_amount = s_order.getAmount();
                double amount = b_order.getAmount() - traded_amount;
                buyingOrders.add(new BuyingOrder(amount,
                        b_order.getPrice(),
                        b_order.getTraderID()));
            }
            else {
                traded_amount = b_order.getAmount();
            }

            int sell_flag = traders.get(s_order.getTraderID())
                    .sell(traded_amount,
                            s_order.getPrice(),
                            this);

            int buy_flag = traders.get(b_order.getTraderID())
                    .buy(traded_amount,
                            s_order.getPrice(),
                            this);

            if(sell_flag == 1 && buy_flag == 1)
                this.no_successful_transaction++;

            if(b_order.getPrice() > s_order.getPrice())
                traders.get(b_order.getTraderID())
                        .getWallet()
                        .returnDollars((b_order.getPrice() - s_order.getPrice()) * traded_amount);

            this.transaction.add(new Transaction(s_order, b_order));
        }
    }
    /**
     * Getter method for buyingOrders.
     * @return  A priority queue which holds the buying orders.
     */
    public PriorityQueue<BuyingOrder> getBuyingOrders() {
        return buyingOrders;
    }

    /**
     * Getter method for sellingOrders.
     * @return  A priority queue which holds the buying orders.
     */
    public PriorityQueue<SellingOrder> getSellingOrders() {
        return sellingOrders;
    }

    /**
     * Adds the given buying order to sellingOrders PriorityQueue.
     * @param order Given buying order.
     */
    public void givenBuyOrder(BuyingOrder order) {
        this.buyingOrders.add(order);
    }

    /**
     * Adds the given selling order to sellingOrders PriorityQueue.
     * @param order
     */
    public void givenSellOrder(SellingOrder order) {
        this.sellingOrders.add(order);
    }


    /**
     * Setter method for traders.
     * @param traders An ArrayList which holds the traders in the market.
     */
    public void setTrader(ArrayList<Trader> traders) {
        this.traders = traders;
    }

    /**
     * Returns the price of the top of buying priority queue.
     * @return The price of the top of buying priority queue.
     */
    public double buyingOrderPrice() {
        return this.buyingOrders.isEmpty() ? 0.0 : this.buyingOrders.peek().getPrice();
    }

    /**
     * Returns the price of the top of selling priority queue.
     * @return The price of the top of selling priority queue.
     */
    public double sellingOrderPrice() {
        return this.sellingOrders.isEmpty() ? 0.0 : this.sellingOrders.peek().getPrice();
    }

    /**
     * Returns a String which includes the current market size information.
     * @return Current market size: -total_$_in_buying_queue- -total_coins_in_selling_queue.
     */
    public String marketSizeInfo() {
        double dollars_sum = 0.0, coins_sum = 0.0;
        for(BuyingOrder b_order : buyingOrders)
            dollars_sum += b_order.getDollars();
        for(SellingOrder s_order : sellingOrders)
            coins_sum += s_order.getAmount();
        return String.format("Current market size: %.5f %.5f", dollars_sum, coins_sum);
    }


    /**
     * Returns a String which includes the current price information.
     * Note: If one of the priority queues is empty then the price related to it,
     * then it is not included in the average current price.
     * @return Current prices: -cp_buying- -cp_selling- -cp_average-.
     */
    public String currentPriceInfo() {
        final double buying_order_price = buyingOrderPrice();
        final double selling_order_price = sellingOrderPrice();
        double average_price;
        double divide = 2.0;

        boolean flag1 = buyingOrders.isEmpty();
        boolean flag2 = sellingOrders.isEmpty();

        if(flag1 && flag2)
            average_price = 0.0;
        else if(!flag1 && flag2)
            average_price = buying_order_price;
        else if(flag1 && !flag2)
            average_price = selling_order_price;
        else
            average_price = (buying_order_price + selling_order_price) / divide;

        return String.format("Current prices: %.5f %.5f %.5f", buying_order_price, selling_order_price, average_price);
    }

    /**
     * Returns a String which includes the total number of successful transactions.
     * @return Number of successful transactions: -num_of_successful_transaction-
     */
    public String transactionNumberInfo() {
        return "Number of successful transactions: " + no_successful_transaction;
    }
}
