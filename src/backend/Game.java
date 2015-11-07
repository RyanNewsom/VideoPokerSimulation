package backend;

import backend.actors.Player;
import backend.actors.PokerMachine;
import backend.card.HandOfCards;

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
        initialHand = machine.dealHandOfCards();
        return thePlayer.getBestStrategy(initialHand);
    }
}
