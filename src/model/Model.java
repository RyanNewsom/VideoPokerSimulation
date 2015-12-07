package model;

/**
 * Created by Ryan on 11/6/2015.
 * The model of the backend
 */
public class Model {
    PokerMachine pokerMachine = new PokerMachine(null);
    HandOfCards currentHand;

    /**
     * Generates a new hand, then sends it to the view
     */
    public HandOfCards generateNewHand(){
        currentHand = pokerMachine.dealHandOfCards();
        return currentHand;
    }

    /**
     * Determines the expected payout for a hand, then sends it to the view
     */
    public Strategy determineExpectedPayoutForHand(PayoutTable currentPayout){
        Game aGameSimulation = new Game(currentPayout, currentHand);
        return aGameSimulation.determineOptimalStrategy();
    }

}
