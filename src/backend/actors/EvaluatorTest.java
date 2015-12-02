package backend.actors;

import backend.Strategy;
import backend.card.Card;
import backend.card.HandOfCards;
import backend.card.Suit;
import backend.data.PayoutTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ryan on 12/1/2015.
 */
public class EvaluatorTest {
    Evaluator mEvaluator;
    PayoutTable mPayoutTable;
    HandOfCards mRoyalFlush;
    HandOfCards mStraightFlush;
    HandOfCards mFourOfAKind;
    HandOfCards mFullHouse;
    HandOfCards mFlush;
    HandOfCards mStraight;
    HandOfCards mThreeOfAKind;
    HandOfCards mTwoPair;
    HandOfCards mPairJacksOrBetter;

    @Before
    public void setUp() throws Exception {
        mPayoutTable = new PayoutTable(800,50,25,8,5,4,3,2,1);
        mEvaluator = new Evaluator(mPayoutTable);
        ArrayList<Card> hand = new ArrayList<>();
        Card card0 = new Card(Suit.CLUBS, 0);
        Card card10 = new Card(Suit.CLUBS, 10);
        Card card11 = new Card(Suit.CLUBS, 11);
        Card card12 = new Card(Suit.CLUBS, 12);
        Card card13 = new Card(Suit.CLUBS, 13);
        Card card14 = new Card(Suit.CLUBS, 14);
        hand.add(card10);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);
        mRoyalFlush = new HandOfCards(new ArrayList<>(hand));
        hand.clear();

        hand.add(card0);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);

        mStraightFlush = new HandOfCards(new ArrayList<>(hand));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testEvaluateHand() throws Exception {
        testRoyalFlush();

        testStraightFlush();
    }

    private void testRoyalFlush() {
        Strategy strategy = mEvaluator.evaluateHand(new Strategy(null, mRoyalFlush));
        assertEquals(mPayoutTable.getRoyalFlush(), strategy.getExpectedPayout(), 0);
    }

    private void testStraightFlush(){
        Strategy strategy = mEvaluator.evaluateHand(new Strategy(null, mStraightFlush));
        assertEquals(mPayoutTable.getStraightflush(), strategy.getExpectedPayout() , 0);
    }


}