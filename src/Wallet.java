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
     *
     * @param dollars Amount of dollars
     * @return
     */
    public boolean checkWithDrawDollars(double dollars) {
        return this.dollars < dollars ? false : true;
    }

    public boolean checkWithDrawCoins(double coins) {
        return  this.coins < coins ? false : true;
    }
}
