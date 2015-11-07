package backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 11/3/2015.
 */
public class PossibleOrderingFactory {
    private HandOfCards handOfCards;
    private Strategy strategy;
    private ArrayList<Strategy> possibleOrderings;
    ArrayList<Card> newList = new ArrayList<Card>();



    public PossibleOrderingFactory(Strategy theStrategy){
        strategy = theStrategy;
        handOfCards = strategy.getHandOfCards();
    }

    public ArrayList<Strategy> getAllPossibleOrderings(){
        determineOrderings(new ArrayList<Card>(), handOfCards.getHandOfCards());
        return possibleOrderings;
    }

    private void determineOrderings(ArrayList<Card> prefix, ArrayList<Card> cards) {
        int n = cards.size();
        if (n == 0) return;
        else {
            for (int i = 0; i < n; i++) {
                newList = new ArrayList<>(cards.subList(0, i));
                newList.addAll(cards.subList(i+1,n));
                possibleOrderings.add(new Strategy(null, new HandOfCards(prefix)));
                determineOrderings(prefix, newList);
            }
        }
    }
}
