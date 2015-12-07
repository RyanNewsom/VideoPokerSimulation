package model;

import model.Card;

import java.util.Collections;

/**
 * Created by Ryan on 11/15/2015.
 * Evaluates a given strategy to determine the expected payout
 */
public class Evaluator {
    private Strategy theStrategy;
    private PayoutTable payoutTable;
    private boolean royalFlush;
    private boolean straightFlush;
    private boolean fourOfAKind;
    private boolean fullHouse;
    private boolean flush;
    private boolean straight;
    private boolean threeOfAKind;
    private boolean twoPair;
    private boolean pairJacksOrBetter;

    /**
     * Creates a new hand evaluator
     * @param payoutTable - the payout table of the poker game
     */
    public Evaluator(PayoutTable payoutTable) {
        this.payoutTable = payoutTable;
    }

    /**
     * Evaluates a given strategy and determines the payout for it. It ignores all data within the model.Strategy, except
     * the hand of cards itself. Which strategy is being used(hold0, hold1, etc, does not have an effect on the evaluation
     * @param strategy - the strategy containing the hand of cards to be evaluated
     * @return
     */
    public Strategy evaluateHand(Strategy strategy){
        theStrategy = strategy;
        determinePayout();
        if(royalFlush){
            strategy.setExpectedPayout((int) payoutTable.getRoyalFlush());
        } else if(straightFlush){
            strategy.setExpectedPayout((int) payoutTable.getStraightflush());
        } else if(fourOfAKind){
            strategy.setExpectedPayout((int) payoutTable.getFourOfAKind());
        } else if(fullHouse){
            strategy.setExpectedPayout((int) payoutTable.getFullHouse());
        } else if(flush){
            strategy.setExpectedPayout((int) payoutTable.getFlush());
        } else if(straight){
            strategy.setExpectedPayout((int) payoutTable.getStraight());
        } else if(threeOfAKind){
            strategy.setExpectedPayout((int) payoutTable.getThreeOfAKind());
        } else if(twoPair){
            strategy.setExpectedPayout((int) payoutTable.getTwoPair());
        } else if(pairJacksOrBetter){
            strategy.setExpectedPayout((int) payoutTable.getPairOfJacksOrBetter());
        }

        resetBooleans();

        return strategy;
    }

    private void resetBooleans() {
        royalFlush = false;
        straightFlush = false;
        fourOfAKind = false;
        fullHouse = false;
        flush = false;
        straight = false;
        threeOfAKind = false;
        twoPair = false;
        pairJacksOrBetter = false;
    }

    private void determinePayout() {
        HandOfCards hand = theStrategy.getHandOfCards();
        Collections.sort(hand.getHandOfCards());
        Card card1 = hand.getCard(0);
        Card card2 = hand.getCard(1);
        Card card3 = hand.getCard(2);
        Card card4 = hand.getCard(3);
        Card card5 = hand.getCard(4);

        if (checkForFlush(card1, card2, card3, card4, card5)) {
            return;
        }

        checkForStraight(card1, card2, card3, card4, card5);

        checkForFlushAce(card1, card2, card3, card4, card5);

        checkForStraightAce(card1, card2, card3, card4, card5);

        if (checkForFourOfAKind(card1, card2, card3, card4)) return;

        if (checkForFourOfAKind(card2, card3, card4, card5)) return;

        if (checkForFullHouse(card1, card2, card3, card4, card5)) return;

        checkForThreeOfAKind(card1, card2, card3, card4, card5);

        checkForTwoPair(card1, card2, card3, card4, card5);

        checkForPairJacksOrBetter(card1, card2, card3, card4, card5);
    }

    private void checkForPairJacksOrBetter(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getValue() == card2.getValue()){
            if(card1.getValue() > 10) {
                pairJacksOrBetter = true;
            }
        }

        if(card2.getValue() == card3.getValue()){
            if(card2.getValue() > 10) {
                pairJacksOrBetter = true;
            }
        }

        if(card3.getValue() == card4.getValue()){
            if(card3.getValue() > 10) {
                pairJacksOrBetter = true;
            }
        }

        if(card4.getValue() == card5.getValue()){
            if(card4.getValue() > 10) {
                pairJacksOrBetter = true;
            }
        }
    }

    private void checkForTwoPair(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getValue() == card2.getValue() && card4.getValue() == card5.getValue()){
            twoPair = true;
        }
        if(card2.getValue() == card3.getValue() && card4.getValue() == card5.getValue()){
            twoPair = true;
        }
        if(card1.getValue() == card2.getValue() && card3.getValue() == card4.getValue()){
            twoPair = true;
        }
    }

    private void checkForThreeOfAKind(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue()){
            threeOfAKind = true;
        }
        if(card2.getValue() == card3.getValue() && card3.getValue() == card4.getValue()){
            threeOfAKind = true;
        }
        if(card3.getValue() == card4.getValue() && card4.getValue() == card5.getValue()){
            threeOfAKind = true;
        }
    }

    private boolean checkForFullHouse(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue() && card4.getValue() == card5.getValue()){
            fullHouse = true;
            return true;
        }
        if(card1.getValue() == card2.getValue() && card3.getValue() == card4.getValue() && card4.getValue() == card5.getValue()){
            fullHouse = true;
            return true;
        }
        return false;
    }

    private boolean checkForFourOfAKind(Card card1, Card card2, Card card3, Card card4) {
        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue() && card3.getValue() == card4.getValue()){
            fourOfAKind = true;
            return true;
        }
        return false;
    }

    private void checkForStraight(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getValue() +1 == card2.getValue() && card2.getValue() +1 == card3.getValue() && card3.getValue() +1 == card4.getValue() && card4.getValue() + 1 == card5.getValue()){
            straight = true;
        }
    }

    private boolean checkForFlush(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getSuit() == card2.getSuit() && card1.getSuit() == card3.getSuit() && card1.getSuit() == card4.getSuit() && card1.getSuit() == card5.getSuit()) {
            flush = true;
            //check for straight flush
            if (card1.getValue() + 1 == card2.getValue() && card2.getValue() + 1 == card3.getValue() && card3.getValue() + 1 == card4.getValue() && card4.getValue() + 1 == card5.getValue()) {
                straightFlush = true;
                if (card5.getValue() == 14) {
                    royalFlush = true;
                }
                return true;
            }
            if (card1.getValue() + 1 == card2.getValue() && card2.getValue() + 1 == card3.getValue() && card3.getValue() + 1 == card4.getValue() && card4.getValue() + 1 == card5.getValue()) {
                straightFlush = true;
                return true;
            }
        }
        return false;
    }

    private boolean checkForFlushAce(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card1.getSuit() == card2.getSuit() && card1.getSuit() == card3.getSuit() && card1.getSuit() == card4.getSuit() && card1.getSuit() == card5.getSuit()) {
            flush = true;
            //check for straight flush
            if(card5.getValue() == 14){
                if(card1.getValue() == 2 && card2.getValue() == 3 && card3.getValue() == 4 && card4.getValue() == 5){
                    straightFlush = true;
                }
            }
        }
        return false;
    }

    private void checkForStraightAce(Card card1, Card card2, Card card3, Card card4, Card card5) {
        if(card5.getValue() == 14) {
            if (card1.getValue() == 2 && card2.getValue() == 3 && card3.getValue() == 4 && card4.getValue() == 5) {
                straight = true;
            }
        }
    }
}
