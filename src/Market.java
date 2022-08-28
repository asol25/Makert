import java.util.ArrayList;
import java.util.PriorityQueue;

public class Market {

    /**
     * A PriorityQueue which hold buying order.
     */
    private PriorityQueue<BuyingOrder> buyingOrders;

    /**
     * A PriorityQueue which hold selling order.
     */
    private PriorityQueue<SellingOrder> sellingOrders;

    /**
     * A ArrayList which hold transaction.
     */
    private ArrayList<Transaction> transaction;

    public Market() {
        this.buyingOrders = new PriorityQueue<>();
        this.sellingOrders = new PriorityQueue<>();
        this.transaction = new ArrayList<>();
    }
}
