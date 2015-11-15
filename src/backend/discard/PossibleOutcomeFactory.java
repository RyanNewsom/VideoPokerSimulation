package backend.discard;

import backend.Strategy;
import backend.TypeOfStrategy;
import backend.card.Card;
import backend.card.HandOfCards;
import com.google.common.collect.Sets;
import com.sun.javafx.css.Combinator;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ryan on 11/3/2015.
 */
public class PossibleOutcomeFactory {
    private HandOfCards handOfCards;
    private Strategy strategy;
    private ArrayList<HandOfCards> possibleOrderings = new ArrayList<>();
    private ArrayList<Card> theCards;
    ArrayList<Card> newList = new ArrayList<Card>();
    private Card removedCard;



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
    public ArrayList<HandOfCards> getAllPossibleOrderings(Strategy strategy, ArrayList<Card> cards){
        theCards = cards;
        if(strategy.getTheType() == TypeOfStrategy.HOLD1) {
            //Try the 5 different possibilities for hold 1
            removedCard = strategy.getHandOfCards().getCard(0);
            printCombinations();
        }


        return possibleOrderings;
    }

    public void printCombinations(){
        boolean[] B = new boolean[theCards.size()];
        subset(theCards, 4, 0, 0, B);
    }

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
            HandOfCards newHand = new HandOfCards(newList);
            possibleOrderings.add(newHand);
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
