package backend.Model;

import backend.Game;
import backend.Strategy;
import backend.data.PayoutTable;
import backend.actors.PokerMachine;
import backend.card.HandOfCards;
import fx.View;

/**
 * Created by Ryan on 11/6/2015.
 * Communicates between the controller and view
 */
public class Model {
    PokerMachine pokerMachine = new PokerMachine(null);
    HandOfCards currentHand;

    /**
     * generates a new hand, then sends it to the view
     */
    public HandOfCards generateNewHand(){
        currentHand = pokerMachine.dealHandOfCards();
        return currentHand;
    }

    /**
     * determines the expected payout for a hand, then sends it to the view
     */
    public Strategy determineExpectedPayoutForHand(PayoutTable currentPayout){
        Game aGameSimulation = new Game(currentPayout, currentHand);
        return aGameSimulation.determineOptimalStrategy();
    }

}
