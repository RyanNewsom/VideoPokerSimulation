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
            removeCardFromDeck(strategy.getHandOfCards().getCard(0));
            Object[] obj = theCards.toArray();
            printCombinations();
        }


        return possibleOrderings;
    }

    public void printCombinations(){
        int A[] = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        subset(A, 4, 0, 0, B);
    }

    public void subset(int[] A, int k, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            for (int i = 0; i < A.length; i++) {
                if (used[i] == true) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (start == A.length) {
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

    private void removeCardFromDeck(Card card){
        ArrayList<Card> hand = strategy.getHandOfCards().getHandOfCards();
        ArrayList<Card> deck = theCards;
        for(int i = 0; i < hand.size(); i++){
            for(int j = 0; j < deck.size(); j++) {
                if (card.getSuit() == deck.get(j).getSuit() && card.getValue() == deck.get(j).getValue()) {
                    deck.remove(j);
                }
            }
        }
        theCards = deck;
    }

}
