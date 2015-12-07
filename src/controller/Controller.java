package controller;

import model.HandOfCards;
import model.Model;
import model.PayoutTable;
import model.Strategy;

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
