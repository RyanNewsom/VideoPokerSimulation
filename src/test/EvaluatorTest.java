//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Ryan on 12/1/2015.
// */
//public class EvaluatorTest {
//    model.Evaluator mEvaluator;
//    model.PayoutTable mPayoutTable;
//    model.HandOfCards mRoyalFlush;
//    model.HandOfCards mStraightFlush;
//    model.HandOfCards mFourOfAKind;
//    model.HandOfCards mFullHouse;
//    model.HandOfCards mFlush;
//    model.HandOfCards mStraight;
//    model.HandOfCards mThreeOfAKind;
//    model.HandOfCards mTwoPair;
//    model.HandOfCards mPairJacksOrBetter;
//
//    @Before
//    public void setUp() throws Exception {
//        mPayoutTable = new model.PayoutTable(800,50,25,8,5,4,3,2,1);
//        mEvaluator = new model.Evaluator(mPayoutTable);
//        ArrayList<model.Card> hand = new ArrayList<>();
//        model.Card card2 = new model.Card(model.Suit.CLUBS, 2);
//        model.Card card3 = new model.Card(model.Suit.CLUBS, 3);
//        model.Card card4 = new model.Card(model.Suit.CLUBS, 4);
//        model.Card card5 = new model.Card(model.Suit.CLUBS, 5);
//        model.Card card6 = new model.Card(model.Suit.CLUBS, 6);
//        model.Card card7 = new model.Card(model.Suit.CLUBS, 7);
//        model.Card card8 = new model.Card(model.Suit.CLUBS, 8);
//        model.Card card9 = new model.Card(model.Suit.CLUBS, 9);
//        model.Card card10 = new model.Card(model.Suit.CLUBS, 10);
//        model.Card card11 = new model.Card(model.Suit.CLUBS, 11);
//        model.Card card12 = new model.Card(model.Suit.CLUBS, 12);
//        model.Card card13 = new model.Card(model.Suit.CLUBS, 13);
//        model.Card card14 = new model.Card(model.Suit.CLUBS, 14);
//        model.Card card22 = new model.Card(model.Suit.DIAMOND, 2);
//        model.Card card23 = new model.Card(model.Suit.DIAMOND, 3);
//        model.Card card24 = new model.Card(model.Suit.DIAMOND, 4);
//        model.Card card25 = new model.Card(model.Suit.DIAMOND, 5);
//        model.Card card26 = new model.Card(model.Suit.DIAMOND, 6);
//        model.Card card27 = new model.Card(model.Suit.DIAMOND, 7);
//        model.Card card28 = new model.Card(model.Suit.DIAMOND, 8);
//        model.Card card29 = new model.Card(model.Suit.DIAMOND, 9);
//        model.Card card30 = new model.Card(model.Suit.DIAMOND, 10);
//        model.Card card31 = new model.Card(model.Suit.DIAMOND, 11);
//        model.Card card32 = new model.Card(model.Suit.DIAMOND, 12);
//        model.Card card33 = new model.Card(model.Suit.DIAMOND, 13);
//        model.Card card34 = new model.Card(model.Suit.DIAMOND, 13);
//
//
//        hand.add(card10);
//        hand.add(card11);
//        hand.add(card12);
//        hand.add(card13);
//        hand.add(card14);
//        mRoyalFlush = new model.HandOfCards(new ArrayList<>(hand));
//        hand.clear();
//
//        hand.add(card2);
//        hand.add(card11);
//        hand.add(card12);
//        hand.add(card13);
//        hand.add(card14);
//
//        mStraightFlush = new model.HandOfCards(new ArrayList<>(hand));
//        hand.clear();
//
//        hand.add(card29);
//        hand.add(card28);
//        hand.add(card27);
//        hand.add(card26);
//        hand.add(card25);
//
//        mStraightFlush = new model.HandOfCards(new ArrayList<>(hand));
//        hand.clear();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void testEvaluateHand() throws Exception {
//        testRoyalFlush(mRoyalFlush, true);
//        testStraightFlush(mStraightFlush, true);
//    }
//
//    /**
//     * Determines if a hand is worth a royal flush
//     * @param handToTest
//     * @param isTrue
//     */
//    private void testRoyalFlush(model.HandOfCards handToTest, Boolean isTrue) {
//        model.Strategy strategy = mEvaluator.evaluateHand(new model.Strategy(null, handToTest));
//
//        if(isTrue) {
//            assertEquals(mPayoutTable.getRoyalFlush(), strategy.getExpectedPayout(), 0);
//        } else{
//            assertNotEquals(mPayoutTable.getRoyalFlush(), 1, 0);
//        }
//
//    }
//
//    private void testStraightFlush(model.HandOfCards handToTest, Boolean isTrue){
//        model.Strategy strategy = mEvaluator.evaluateHand(new model.Strategy(null, handToTest));
//        assertEquals(mPayoutTable.getStraightflush(), strategy.getExpectedPayout() , 0);
//    }
//
//
//}