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
     * @param dollars Given amount of the dollars.
     */
    public void givenDollars(double dollars) {
        this.dollars += dollars;
    }

    /**
     * Adds coins to the wallet.
     * @param coins Given amount of the coins.
     */
    public void givenCoins(double coins) {
        this.coins += coins;
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
        return  this.coins <= coins;
    }
}
