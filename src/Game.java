/**
 * Created by Ryan on 11/3/2015.
 * This class is the system class and is the environment for the game
 */
public class Game {
    private PayoutTable payoutTable;
    private Player thePlayer;
    private PokerMachine machine;
    private HandOfCards initialHand;

    public Game(PayoutTable payoutTable, HandOfCards handOfCards){
        thePlayer = new Player();
        initialHand = handOfCards;
        this.payoutTable = payoutTable;
    }

    public Strategy determineOptimalStrategy(){
        return thePlayer.getBestStrategy(initialHand, payoutTable);
    }
}
