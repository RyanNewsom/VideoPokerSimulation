package backend.actors;

import backend.card.Card;
import backend.data.PayoutTable;
import backend.discard.PossibleOutcomeFactory;
import backend.Strategy;
import backend.TypeOfStrategy;
import backend.card.Deck;
import backend.card.HandOfCards;

import java.util.ArrayList;

/**
 * Created by Ryan on 11/3/2015.
 * This computes the optimal strategy for a given hand
 */
public class StrategyComputer {
    private Strategy bestStrategy;
    private HandOfCards initialHand;
    private Deck theDeck = new Deck();
    private PayoutTable payoutTable;
    private ArrayList<Card> cards;

    public StrategyComputer(PayoutTable payoutTable) {
        this.payoutTable = payoutTable;
    }

    public Strategy determineBestStrategy(HandOfCards initialHand){
        this.initialHand = initialHand;
        removeCardsFromDeck();
        applyAllPossibleStrategies();
        return bestStrategy;
    }

    /**
     * This will remove the cards in the current hand from the deck
     */
    private void removeCardsFromDeck() {
        ArrayList<Card> hand = initialHand.getHandOfCards();
        ArrayList<Card> deck = theDeck.getCards();
        for(int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            for(int j = 0; j < deck.size(); j++) {
                if (card.getSuit() == deck.get(j).getSuit() && card.getValue() == deck.get(j).getValue()) {
                    deck.remove(j);
                }
            }
        }
        theDeck.setDeckOfCards(deck);
    }

    /**
     * This will apply all possible strategies and determine which one is the best
     */
    private void applyAllPossibleStrategies() {
        //apply all strategies, this includes holding 1 card, holding 2, etc.
        Strategy h0 = applyHold0();
        Strategy h1 = applyHold1();
        Strategy h2 = applyHold2();
        Strategy h3 = applyHold3();
        Strategy h4 = applyHold4();
        Strategy h5 = applyHold5();

        //Compare h0-h5, whichever is highest will be the optimal strategy

    }

    private Strategy applyHold0(){
        return null;
    }

    private Strategy applyHold1() {
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD1, initialHand);
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        outcomeFactory.getAllPossibleOrderings(strategy, theDeck.getCards());
        return null;
    }

    private Strategy applyHold2(){
        //Hold 2 cards for each hand
        return null;
    }

    private Strategy applyHold3(){
        return null;
    }

    private Strategy applyHold4(){
        //Determine all possible combinations of the cards being held.
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD4, initialHand);
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        outcomeFactory.getAllPossibleOrderings(strategy, cards);
        //From all possible orderings of the initial hand, now determine all possible outcomes
        return null;
    }

    private Strategy applyHold5(){
        return null;
    }
}
