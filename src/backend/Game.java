package backend;

/**
 * Created by Ryan on 11/3/2015.
 * This class is the system class and is the environment for the game
 */
public class Game {
    private Player thePlayer;
    private PokerMachine machine;
    private HandOfCards initialHand;

    public Game(){
        thePlayer = new Player();
    }

    public Strategy determineOptimalStrategy(){
        initialHand = machine.dealInitialHand();
        return thePlayer.getBestStrategy(initialHand);
    }
}
