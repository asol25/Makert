public class Wallet {

    /**
     * Amount dollars of the wallet.
     */
    private double dollars;

    /**
     * Amount coins of the wallet.
     */
    private double coins;

    /**
     * blockedDollars of the wallet.
     */
    private double blockedDollars;

    /**
     * blockedCoins of the wallet.
     */
    private double blockedCoins;


    public Wallet(double dollars, double coins) {
        this.dollars = dollars;
        this.coins = coins;

        this.blockedDollars = 0.0;
        this.blockedCoins = 0.0;
    }

    /**
     * Adds dollars to the wallet.
     * @param dollars The given amount of the dollars.
     */
    public void depositDollars(double dollars) {
        this.dollars += dollars;
    }

    /**
     * Adds coins to the wallet.
     * @param coins The given amount of the coins.
     */
    public void depositCoins(double coins) {
        this.coins += coins;
    }

    /**
     * Add dollars to blocked dollars.
     * @param dollars The given amount of the dollars.
     */
    public void blockedDollars(double dollars) {
        this.dollars -= dollars;
        this.blockedDollars += dollars;
    }

    /**
     * Add coins to blocked coins.
     * @param coins The given amount of the coins.
     */
    public void blockedCoins(double coins) {
        this.coins -= coins;
        this.blockedCoins += coins;
    }

    /**
	 * Pays the given amount of dollars from the blocked dollars.
	 * @param dollars The given amount of dollars.
	 */
	public void payFromBlockedDollars(double dollars) {
		blockedDollars -= dollars;
	}

    /**
     * Pays the given amount of coins from the blocked coins.
     * @param coins The given amount of coins.
     */
    public void payFromBlockedCoins(double coins) {
        blockedCoins -= coins;
    }

    /**
     * Check the amount of dollars is affordable.
     * @param dollars Amount of the dollars of the wallet.
     * @return TRUE if the given amount of dollars is affordable, FALSE otherwise.
     */
    public boolean checkWithDrawDollars(double dollars) {
        return this.dollars <= dollars;
    }

    /**
     * Check the amount of coins is affordable.
     * @param coins Amount of the coins of the wallet.
     * @return TRUE if the given amount of coins is affordable, FALSE otherwise.
     */
    public boolean checkWithDrawCoins(double coins) {
        return this.coins <= coins;
    }

    /**
	 * Checks if the given amount of dollars can be withdrawn from the blocked dollars.
	 * @param dollars The given amount of dollars.
	 * @return TRUE if the given amount of dollars is affordable, FALSE otherwise.
	 */
	public boolean checkBlockedDollars(double dollars) {
		return dollars <= blockedDollars;
	}
    
	/**
	 * Checks if the given amount of coins can be withdrawn from the blocked coins.
	 * @param coins The given amount of coins.
	 * @return TRUE if the given amount of coins is affordable, FALSE otherwise.
	 */
	public boolean checkBlockedCoins(double coins) {
		return coins <= blockedCoins;
	}


    /**
     * Returns the given amount of dollars from the blocked dollars to the available dollars.
     * @param dollars The given amount of dollars.
     */
    public void returnDollars(double dollars) {
        this.dollars += dollars;
        blockedDollars -= dollars;
    }
}
