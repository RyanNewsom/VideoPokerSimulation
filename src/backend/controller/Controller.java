package backend.controller;

import backend.Model.Model;
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
    public void determineExpectedPayout(PayoutTable payoutTable){
        notifyModel(payoutTable);
    }

    /**
     * Notifies the model to get a new deck of cards and give it to the view
     */
    public HandOfCards getNewHandOfCards(){
        return model.generateNewHand();
    }

    /**
     * Tell's the model to update the expected payout
     * @param payoutTable - the current payout table as defined by the user
     */
    private void notifyModel(PayoutTable payoutTable) {
        model.determineExpectedPayoutForHand(payoutTable);
    }


}
