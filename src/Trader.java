public class Trader {

    /**
     * ID of the trader.
     */
    private int ID;

    /**
     * wallet of the trader.
     */
    private Wallet wallet;

    public int num_transaction;

    public Trader(int ID, Wallet wallet, int num_transaction) {
        this.ID = ID;
        this.num_transaction++;
    }

}
