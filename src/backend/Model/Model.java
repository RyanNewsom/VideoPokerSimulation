package backend.Model;

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

    /**
     * generates a new hand, then sends it to the view
     */
    public void generateNewHand(){
        HandOfCards newHand = pokerMachine.dealHandOfCards();
        if(newHand != null) {
            View.updateCurrentHand(newHand);
        }
    }

    /**
     * determines the expected payout for a hand, then sends it to the view
     */
    public void determineExpectedPayoutForHand(PayoutTable currentPayout){

    }

}
