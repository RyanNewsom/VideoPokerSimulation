package backend.discard;

import backend.Strategy;
import backend.TypeOfStrategy;
import backend.card.Card;
import backend.card.HandOfCards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ryan on 11/3/2015.
 * Gives all the possible hands that could result from a given strategy
 */
public class PossibleOutcomeFactory {
    private HandOfCards handOfCards;
    private Strategy strategy;
    private ArrayList<ArrayList<Strategy>> allPossibleOrderings = new ArrayList<>();
    private ArrayList<Strategy> possibleOrderings = new ArrayList<>();
    private ArrayList<Card> theCards;
    ArrayList<Card> newList = new ArrayList<Card>();
    private Card removedCard;


    /**
     * Constructor
     * @param theStrategy - Strategy to be used
     */
    public PossibleOutcomeFactory(Strategy theStrategy){
        strategy = theStrategy;
        handOfCards = strategy.getHandOfCards();
    }

    /**
     * This will get all possible combinations for 4 cards with the card to hold onto removed
     * @param strategy
     * @param cards
     * @return
     */
    public ArrayList<ArrayList<Strategy>> getAllPossibleOutcomes(Strategy strategy, ArrayList<Card> cards){
        theCards = cards;
        if(strategy.getTheType() == TypeOfStrategy.HOLD1) {
            //Try the 5 different possibilities for hold 1
            //Hold First Card
            removedCard = strategy.getHandOfCards().getCard(0);
            boolean [] cardsToHold = new boolean[] {true,false,false,false,false};
            strategy.setCardsToHoldOnto(cardsToHold);
            this.strategy = strategy;
            boolean[] B = new boolean[theCards.size()];
            subset(theCards, 4, 0, 0, B);
            allPossibleOrderings.add(possibleOrderings);
            possibleOrderings = new ArrayList<>();


            //Hold Second Card
            removedCard = strategy.getHandOfCards().getCard(0);
            boolean [] cardsToHold1 = new boolean[] {false,true,false,false,false};
            strategy.setCardsToHoldOnto(cardsToHold);
            this.strategy = strategy;
            boolean[] B1 = new boolean[theCards.size()];
            subset(theCards, 4, 0, 0, B);
            allPossibleOrderings.add(possibleOrderings);
            possibleOrderings = new ArrayList<>();

            //Hold Third Car
            removedCard = strategy.getHandOfCards().getCard(0);
            boolean [] cardsToHold2 = new boolean[] {false,false,true,false,false};
            strategy.setCardsToHoldOnto(cardsToHold);
            this.strategy = strategy;
            boolean[] B2 = new boolean[theCards.size()];
            subset(theCards, 4, 0, 0, B);
            allPossibleOrderings.add(possibleOrderings);
            possibleOrderings = new ArrayList<>();

            //Hold Fourth Car
            removedCard = strategy.getHandOfCards().getCard(0);
            boolean [] cardsToHold3 = new boolean[] {false,false,false,true,false};
            strategy.setCardsToHoldOnto(cardsToHold);
            this.strategy = strategy;
            boolean[] B3 = new boolean[theCards.size()];
            subset(theCards, 4, 0, 0, B);
            allPossibleOrderings.add(possibleOrderings);
            possibleOrderings = new ArrayList<>();

            //Hold Fifth Car
            removedCard = strategy.getHandOfCards().getCard(0);
            boolean [] cardsToHold4 = new boolean[] {false,false,false,false,true};
            strategy.setCardsToHoldOnto(cardsToHold);
            this.strategy = strategy;
            boolean[] B4 = new boolean[theCards.size()];
            subset(theCards, 4, 0, 0, B);
            allPossibleOrderings.add(possibleOrderings);
            possibleOrderings = new ArrayList<>();
        }
        return allPossibleOrderings;
    }

    /**
     * This will get all the possible outcome hands, then they each need to be evaluated
     * @param A - the alphabet
     * @param k - the size of the subsets
     * @param start
     * @param currLen
     * @param used
     */
    public void subset(ArrayList<Card> A, int k, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            ArrayList<Card> newList = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                if (used[i] == true) {
                    newList.add(A.get(i));
                    System.out.print(A.get(i) + " ");
                }
            }

            newList.add(removedCard);
            Collections.sort(newList);
            HandOfCards newHand = new HandOfCards(newList);
            strategy.setHandOfCards(newHand);
            Strategy newStrategy = new Strategy(strategy.getTheType(), strategy.getHandOfCards());
            newStrategy.setCardsToHoldOnto(strategy.getArrayCardsToHold());
            possibleOrderings.add(newStrategy);

            System.out.print(removedCard);
            System.out.println();
            return;
        }
        if (start == A.size()) {
            return;
        }
        // For every index we have two options,
        // 1.. Either we select it, means put true in used[] and make currLen+1
        used[start] = true;
        subset(A, k, start + 1, currLen + 1, used);
        // 2.. OR we dont select it, means put false in used[] and dont increase
        // currLen
        used[start] = false;
        subset(A, k, start + 1, currLen, used);
    }

}
