package backend.actors;

import backend.Strategy;
import backend.card.Card;
import backend.card.HandOfCards;
import backend.data.PayoutTable;

import java.util.ArrayList;
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

    public Evaluator(PayoutTable payoutTable) {
        this.payoutTable = payoutTable;
    }

    public Strategy evaluateHand(Strategy strategy){
        theStrategy = strategy;
        determinePayout();
        if(royalFlush){
            strategy.setExpectedPayout((int) payoutTable.getRoyalFlush());
        } else if(straightFlush){
            strategy.setExpectedPayout((int) payoutTable.getStraightflush());
        } else if(fourOfAKind){
            strategy.setExpectedPayout((int) payoutTable.getFourOfAKindAces());
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

        if(card1.getSuit() == card2.getSuit() && card1.getSuit() == card3.getSuit() && card1.getSuit() == card4.getSuit() && card1.getSuit() == card5.getSuit()){
            flush = true;
            //check for straight flush
            if(card1.getValue() +1 == card2.getValue() && card2.getValue() +1 == card3.getValue() && card3.getValue() +1 == card4.getValue() && card4.getValue() + 1 == card5.getValue()){
                straightFlush = true;
                if(card5.getValue() == 13){
                    royalFlush = true;
                }
                return;
            }
        }
        if(card1.getValue() +1 == card2.getValue() && card2.getValue() +1 == card3.getValue() && card3.getValue() +1 == card4.getValue() && card4.getValue() + 1 == card5.getValue()){
            straight = true;
        }
        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue() && card3.getValue() == card4.getValue() && card4.getValue() == card5.getValue()){
            fourOfAKind = true;
            return;
        }

        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue() && card4.getValue() == card5.getValue()){
            fullHouse = true;
            return;
        }
        if(card1.getValue() == card2.getValue() && card3.getValue() == card4.getValue() && card4.getValue() == card5.getValue()){
            fullHouse = true;
            return;
        }

        if(card1.getValue() == card2.getValue() && card2.getValue() == card3.getValue()){
            threeOfAKind = true;
        }
        if(card2.getValue() == card3.getValue() && card3.getValue() == card4.getValue()){
            threeOfAKind = true;
        }
        if(card3.getValue() == card4.getValue() && card4.getValue() == card5.getValue()){
            threeOfAKind = true;
        }

        if(card1.getValue() == card2.getValue() && card4.getValue() == card5.getValue()){
            twoPair = true;
        }
        if(card2.getValue() == card3.getValue() && card4.getValue() == card5.getValue()){
            twoPair = true;
        }
        if(card1.getValue() == card2.getValue() && card3.getValue() == card4.getValue()){
            twoPair = true;
        }

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
}
