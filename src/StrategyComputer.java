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
    private int anInt;

    public StrategyComputer(PayoutTable payoutTable) {
        this.payoutTable = payoutTable;
    }

    public Strategy determineBestStrategy(HandOfCards initialHand){
        this.initialHand = initialHand;
        removeCardsFromDeck();
        return applyAllPossibleStrategies();
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
    private Strategy applyAllPossibleStrategies() {
        //apply all strategies, this includes holding 1 card, holding 2, etc.
        Strategy h0 = applyHold0();
        Strategy h1 = applyHold1();
        Strategy h2 = applyHold2();
        Strategy h3 = applyHold3();
        Strategy h4 = applyHold4();
        Strategy h5 = applyHold5();

        //Compare h0-h5, whichever is highest will be the optimal strategy
        ArrayList<Strategy> allStrategies = new ArrayList<>();
        allStrategies.add(h0);
        allStrategies.add(h1);
        allStrategies.add(h2);
        allStrategies.add(h3);
        allStrategies.add(h4);
        allStrategies.add(h5);
        Strategy bestStrategy = allStrategies.get(0);
        for(int i = 1; i < allStrategies.size(); i++){
            if(allStrategies.get(i).getExpectedPayout() > bestStrategy.getExpectedPayout()){
                bestStrategy = allStrategies.get(i);
            }
        }

        return bestStrategy;
    }

    private Strategy applyHold0(){
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD0, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        //Now that we have all possible outcomes, they need to be evaluated
        //Go through each of the strategies and determines the highest expected payout for each
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);
        return highestExpectedPayoutStrategy;
    }

    private Strategy applyHold1() {
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD1, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        //Now that we have all possible outcomes, they need to be evaluated
        //Go through each of the strategies and determines the highest expected payout for each
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);
        return highestExpectedPayoutStrategy;
    }

    private Strategy applyHold2(){
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD2, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        //Now that we have all possible outcomes, they need to be evaluated
        //Go through each of the strategies and determines the highest expected payout for each
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);
        return  highestExpectedPayoutStrategy;
    }

    private Strategy applyHold3(){
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD3, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        //Now that we have all possible outcomes, they need to be evaluated
        //Go through each of the strategies and determines the highest expected payout for each
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);

        return highestExpectedPayoutStrategy;
    }

    private Strategy applyHold4(){
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD4, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);

        return highestExpectedPayoutStrategy;
    }

    private Strategy applyHold5(){
        Evaluator evaluator = new Evaluator(payoutTable);
        Strategy highestExpectedPayoutStrategy = new Strategy(null, null);
        Strategy strategy = new Strategy(TypeOfStrategy.HOLD5, initialHand);
        //Hold 1 card from the hand. Try Holding a card at each position...
        //Then generate all possible outcomes for
        // that hand
        PossibleOutcomeFactory outcomeFactory = new PossibleOutcomeFactory(strategy);
        ArrayList<ArrayList<Strategy>> possibleOutcomes = outcomeFactory.getAllPossibleOutcomes(strategy, theDeck.getCards());
        highestExpectedPayoutStrategy = evaluateStrategy(evaluator, highestExpectedPayoutStrategy, possibleOutcomes);

        return highestExpectedPayoutStrategy;
    }

    /**
     *
     * @param evaluator
     * @param highestExpectedPayoutStrategy
     * @param possibleOutcomes
     * @return
     */
    private Strategy evaluateStrategy(Evaluator evaluator, Strategy highestExpectedPayoutStrategy, ArrayList<ArrayList<Strategy>> possibleOutcomes) {
        double totalPayout = 0;
        int numberOfStrategies = 0;
        double average = 0;
        for(int j = 0; j < possibleOutcomes.size(); j++) {
            ArrayList<Strategy> strategies = possibleOutcomes.get(j);
            Strategy aStrategy = new Strategy(null, null);
            //Go through the strategy and determine the average expected payout
            for (int i = 0; i < strategies.size(); i++) {
                aStrategy = strategies.get(i);
                aStrategy = evaluator.evaluateHand(aStrategy);
                totalPayout += aStrategy.getExpectedPayout();
                numberOfStrategies++;
            }
            double newAverage = totalPayout/numberOfStrategies;
            numberOfStrategies = 0;
            anInt = 0;
            totalPayout = anInt;
            if (newAverage >= average) {
                average = newAverage;
                highestExpectedPayoutStrategy = aStrategy;
                highestExpectedPayoutStrategy.setExpectedPayout(average);
            }
        }
        return highestExpectedPayoutStrategy;
    }

}
