public class Transaction {

    /**
     * ID of the transaction.
     */
    private int ID;

    /**
     * wallet of the transaction.
     */
    private Wallet wallet;

    public Transaction(int ID, Wallet wallet) {
        this.ID = ID;
        this.wallet = wallet;
    }
}
