public class Trader {

    /**
     * ID of the trader.
     */
    private int ID;

    /**
     * wallet of the trader.
     */
    private Wallet wallet;

/**
	 * Total number of traders in the market.
	 */
	public static int numberOfUsers = 0;

    /**
	 * A constructor with 2 parameters, namely dollars and coins.
	 * @param dollars Initial amount of dollars in the trader's wallet.
	 * @param coins Initial amount of coins in the trader's wallet.
	 */
	public Trader(double dollars, double coins) {
		this.ID = numberOfUsers;
		numberOfUsers++;
		this.wallet = new Wallet(dollars, coins);
	}

    /**
	 * Processes the selling part of the transaction.
	 * @param amount Coins reserved for the selling order.
	 * @param price Price of the selling order set by the selling trader.
	 * @param market The market object.
	 * @return 1 if the selling part of the transaction is successful, 0 otherwise.
	 */
    public int sell(double amount, double price, double market) {
        final boolean flag = this.wallet.checkBlockedCoins(amount) || this.ID == 0;

        if (flag) {
            this.wallet.payFromBlockedCoins(amount);
            double calculator = amount * price * (1.0 - (double)market.getFee() / 1000.0);
            this.wallet.depositDollars(calculator);
        }

        return flag ? 1 : 0;
    }

    /**
    * Processes the buying part of the transaction.
    * @param amount Coins reserved for the buying order.
    * @param price Price of the buying order set by buying trader.
    * @param market the market object.
    * @return 1 if the buying part of the transaction is successful, 0 otherwise.
    */
    public boolean buy(double amount, double price, double market) {
        final double dollars = amount * price;
        final boolean flag = this.wallet.checkBlockedDollars(dollars) || this.ID == 0;

        if (flag) {
            this.wallet.payFromBlockedDollars(dollars);
            this.wallet.depositCoins(amount);
        }

        return flag ? 1 : 0;
    }


	/**
	 * Getter method for wallet.
	 * @return Wallet of the trader.
	 */
	public Wallet getWallet() {
		return wallet;
	}
}
