package backend.controller;

import backend.Model.Model;
import backend.Strategy;
import backend.card.HandOfCards;
import backend.data.PayoutTable;

/**
 * Communicates between the view and model
 */
public class Controller {
    private Model model = new Model();
    /**
     * Will tell the model to determine the expected payout
     */
    public Strategy determineExpectedPayout(PayoutTable payoutTable){
        return model.determineExpectedPayoutForHand(payoutTable);
    }

    /**
     * Notifies the model to get a new deck of cards and give it to the view
     */
    public HandOfCards getNewHandOfCards(){
        return model.generateNewHand();
    }

}
