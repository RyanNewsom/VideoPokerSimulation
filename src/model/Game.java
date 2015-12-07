package model;

/**
 * Created by Ryan on 11/3/2015.
 * This class is the system class and is the environment for the game
 */
public class Game {
    private PayoutTable payoutTable;
    private Player thePlayer;
    private HandOfCards initialHand;

    /**
     * Creates a new poker game with the associated payout table and initial hand of cards
     * @param payoutTable - the payout table
     * @param handOfCards - the initial hand of cards
     */
    public Game(PayoutTable payoutTable, HandOfCards handOfCards){
        thePlayer = new Player();
        initialHand = handOfCards;
        this.payoutTable = payoutTable;
    }

    /**
     * Asks the player when the optimal strategy is for the current hand
     * @return - the optimal model.Strategy to use, containing the payout and which cards to hold
     */
    public Strategy determineOptimalStrategy(){
        return thePlayer.getBestStrategy(initialHand, payoutTable);
    }
}
