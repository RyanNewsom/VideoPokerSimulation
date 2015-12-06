import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ryan on 11/3/2015.
 * Gives all the possible hands that could result from a given strategy
 */
public class PossibleOutcomeFactory {
    private Strategy strategy;
    private ArrayList<ArrayList<Strategy>> allPossibleOrderings = new ArrayList<>();
    private ArrayList<Strategy> possibleOrderings = new ArrayList<>();
    private ArrayList<Card> theCards;

    /**
     * Creates a new possible outcome factory, with a given strategy
     * @param theStrategy - Strategy to be used
     */
    public PossibleOutcomeFactory(Strategy theStrategy){
        strategy = theStrategy;
    }

    /**
     * This will get all possible combinations for a given strategy
     * @param strategy - the strategy that is being used
     * @param cards - the cards left in the deck
     * @return - each index of the parent arraylist contains an arraylist of the possible outcomes for each strategy,
     * so they are at seperate index's
     */
    public ArrayList<ArrayList<Strategy>> getAllPossibleOutcomes(Strategy strategy, ArrayList<Card> cards){
        theCards = cards;
        this.strategy = strategy;
        possibleOrderings.clear();
        allPossibleOrderings.clear();
        if(strategy.getTheType() == TypeOfStrategy.HOLD0) {
            runallHold0();
        }

        if(strategy.getTheType() == TypeOfStrategy.HOLD1) {
            runallHold1();
        }

        if(strategy.getTheType() == TypeOfStrategy.HOLD2) {
            runallHold2();
        }

        if(strategy.getTheType() == TypeOfStrategy.HOLD3) {
            runallHold3();
        }

        if(strategy.getTheType() == TypeOfStrategy.HOLD4) {
            runallHold4();
        }

        if(strategy.getTheType() == TypeOfStrategy.HOLD5) {
            runallHold5();
        }

        return allPossibleOrderings;
    }

    private void runallHold5() {
        boolean [] cardsToHold = new boolean[] {true,true,true,true,true};
        determineOrderings(cardsToHold,0);
    }

    private void runallHold4() {
        boolean [] cardsToHold = new boolean[] {false,true,true,true,true};
        determineOrderings(cardsToHold,1);

        boolean [] cardsToHold1 = new boolean[] {true,false,true,true,true};
        determineOrderings(cardsToHold1,1);

        boolean [] cardsToHold2 = new boolean[] {true,true,false,true,true};
        determineOrderings(cardsToHold2,1);

        boolean [] cardsToHold3 = new boolean[] {true,true,true,false,true};
        determineOrderings(cardsToHold3,1);

        boolean [] cardsToHold4 = new boolean[] {true,true,true,true,false};
        determineOrderings(cardsToHold4,1);
    }

    private void runallHold3() {
        boolean [] cardsToHold = new boolean[] {true,true,true,false,false};
        determineOrderings(cardsToHold,2);

        boolean [] cardsToHold1 = new boolean[] {false,true,true,true,false};
        determineOrderings(cardsToHold1,2);

        boolean [] cardsToHold2 = new boolean[] {false,false,true,true,true};
        determineOrderings(cardsToHold2,2);

        boolean [] cardsToHold3 = new boolean[] {true,true,false,false,true};
        determineOrderings(cardsToHold3,2);

        boolean [] cardsToHold4 = new boolean[] {true,true,false,true,false};
        determineOrderings(cardsToHold4,2);

        boolean [] cardsToHold5 = new boolean[] {true,false,true,true,false};
        determineOrderings(cardsToHold5,2);

        boolean [] cardsToHold6 = new boolean[] {true,false,true,false,true};
        determineOrderings(cardsToHold6,2);

        boolean [] cardsToHold7 = new boolean[] {true,false,false,true,true};
        determineOrderings(cardsToHold7,2);

        boolean [] cardsToHold8 = new boolean[] {false,true,true,false,true};
        determineOrderings(cardsToHold8,2);
    }


    private void runallHold2() {
        boolean [] cardsToHold = new boolean[] {true,true,false,false,false};
        determineOrderings(cardsToHold,3);

        boolean [] cardsToHold1 = new boolean[] {true,false,true,false,false};
        determineOrderings(cardsToHold1,3);

        boolean [] cardsToHold2 = new boolean[] {true,false,false,true,false};
        determineOrderings(cardsToHold2,3);

        boolean [] cardsToHold3 = new boolean[] {true,false,false,false,true};
        determineOrderings(cardsToHold3,3);

        boolean [] cardsToHold4 = new boolean[] {false,true,true,false,false};
        determineOrderings(cardsToHold4,3);

        boolean [] cardsToHold5 = new boolean[] {false,true,false,true,false};
        determineOrderings(cardsToHold5, 3);

        boolean [] cardsToHold6 = new boolean[] {false,true,false,false,true};
        determineOrderings(cardsToHold6,3);

        boolean [] cardsToHold7 = new boolean[] {false,false,true,true,false};
        determineOrderings(cardsToHold7, 3);

        boolean [] cardsToHold8 = new boolean[] {false,false,true,false,true};
        determineOrderings(cardsToHold8, 3);

        boolean [] cardsToHold9 = new boolean[] {false,false,false,true,true};
        determineOrderings(cardsToHold9,3);
    }

    private void runallHold1() {
        //Try the 5 different possibilities for hold 1
        //Hold First Card
        boolean [] cardsToHold = new boolean[] {true,false,false,false,false};
        determineOrderings(cardsToHold, 4);


        //Hold Second Card
        boolean [] cardsToHold1 = new boolean[] {false,true,false,false,false};
        determineOrderings(cardsToHold1, 4);


        //Hold Third Car
        boolean [] cardsToHold2 = new boolean[] {false,false,true,false,false};
        determineOrderings(cardsToHold2, 4);


        //Hold Fourth Car
        boolean [] cardsToHold3 = new boolean[] {false,false,false,true,false};
        determineOrderings(cardsToHold3, 4);


        //Hold Fifth Car
        boolean [] cardsToHold4 = new boolean[] {false,false,false,false,true};
        determineOrderings(cardsToHold4, 4);
    }

    private void runallHold0(){
        boolean [] cardsToHold = new boolean[] {false,false,false,false,false};
        determineOrderings(cardsToHold, 5);
    }

    /**
     * Determines the possible orderings and populates the arraylist
     * @param cardsToHold - these are the cards that will be held
     * @param amountToGet - the number of cards that need to be generated, 5 cards - held cards
     */
    private void determineOrderings(boolean[] cardsToHold, int amountToGet) {
        boolean[] b = new boolean[theCards.size()] ;
        this.strategy.setCardsToHoldOnto(cardsToHold);
        createAllPossibilities(theCards, amountToGet, 0, 0, b);
        allPossibleOrderings.add(possibleOrderings);
        possibleOrderings = new ArrayList<>();
    }

    /**
     * This will get all the possible outcome hands, then they each need to be evaluated
     * @param A - the deck of cards that remains
     * @param k - the size of each subset
     * @param start - the index to start at
     * @param currLen - the current length
     * @param used - flags cards that have been used
     */
    private void createAllPossibilities(ArrayList<Card> A, int k, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            ArrayList<Card> newList = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                if (used[i] == true) {
                    newList.add(A.get(i));
                }
            }

            HandOfCards newHand = insertHeldCard(newList);
            Strategy newStrategy = new Strategy(strategy.getTheType(),newHand);
            newStrategy.setCardsToHoldOnto(strategy.getArrayCardsToHold());
            possibleOrderings.add(newStrategy);
            return;
        }
        if (start == A.size()) {
            return;
        }
        // For each index their are two possibilities
        // Select it
        used[start] = true;
        createAllPossibilities(A, k, start + 1, currLen + 1, used);
        // don't select it
        used[start] = false;
        createAllPossibilities(A, k, start + 1, currLen, used);
    }

    /**
     * Inserts back into the hand, the cards that were removed because they were being held
     * @param newList - cards that do not have the held cards in them
     * @return - a new hand of cards with the new cards and cards being held combined
     */
    private HandOfCards insertHeldCard(ArrayList<Card> newList) {
        //Look at the removed cards,
        ArrayList<Card> cardsToAdd = new ArrayList<>();
        boolean [] cardsToHold = strategy.getArrayCardsToHold();
        for(int i = 0; i < cardsToHold.length; i++)
        {
            if(cardsToHold[i] == true){
                cardsToAdd.add(strategy.getHandOfCards().getCard(i));
            }
        }

        newList.addAll(cardsToAdd);
        Collections.sort(newList);
        return new HandOfCards(newList);
    }

}
