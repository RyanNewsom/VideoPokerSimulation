package backend;

import java.util.ArrayList;

/**
 * Created by Ryan on 11/3/2015.
 * This computes the optimal strategy for a given hand
 */
public class StrategyComputer {
    private Strategy bestStrategy;
    private HandOfCards initialHand;
    private Deck theDeck;

    public Strategy determineBestStrategy(HandOfCards initialHand){
        this.initialHand = initialHand;
        applyAllPossibleStrategies();
        return null;
    }

    private void applyAllPossibleStrategies() {
        //apply all strategies, this includes holding 1 card, holding 2, etc.
        Strategy h0 = applyHold0();
        Strategy h1 = applyHold1();
        Strategy h2 = applyHold2();
        Strategy h3 = applyHold3();
        Strategy h4 = applyHold4();
        Strategy h5 = applyHold5();

        //Compare h0-h5, whichever is highest

    }

    private Strategy applyHold0(){
        return null;
    }

    private Strategy applyHold1() {
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
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
        PossibleOrderingFactory orderingFactory = new PossibleOrderingFactory(strategy);
        ArrayList<Strategy> orderingsOfCards = orderingFactory.getAllPossibleOrderings();
        //From all possible orderings of the initial hand, now determine all possible outcomes
        return null;
    }

    private Strategy applyHold5(){
        return null;
    }
}
