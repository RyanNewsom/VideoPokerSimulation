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
//    Evaluator mEvaluator;
//    PayoutTable mPayoutTable;
//    HandOfCards mRoyalFlush;
//    HandOfCards mStraightFlush;
//    HandOfCards mFourOfAKind;
//    HandOfCards mFullHouse;
//    HandOfCards mFlush;
//    HandOfCards mStraight;
//    HandOfCards mThreeOfAKind;
//    HandOfCards mTwoPair;
//    HandOfCards mPairJacksOrBetter;
//
//    @Before
//    public void setUp() throws Exception {
//        mPayoutTable = new PayoutTable(800,50,25,8,5,4,3,2,1);
//        mEvaluator = new Evaluator(mPayoutTable);
//        ArrayList<Card> hand = new ArrayList<>();
//        Card card2 = new Card(Suit.CLUBS, 2);
//        Card card3 = new Card(Suit.CLUBS, 3);
//        Card card4 = new Card(Suit.CLUBS, 4);
//        Card card5 = new Card(Suit.CLUBS, 5);
//        Card card6 = new Card(Suit.CLUBS, 6);
//        Card card7 = new Card(Suit.CLUBS, 7);
//        Card card8 = new Card(Suit.CLUBS, 8);
//        Card card9 = new Card(Suit.CLUBS, 9);
//        Card card10 = new Card(Suit.CLUBS, 10);
//        Card card11 = new Card(Suit.CLUBS, 11);
//        Card card12 = new Card(Suit.CLUBS, 12);
//        Card card13 = new Card(Suit.CLUBS, 13);
//        Card card14 = new Card(Suit.CLUBS, 14);
//        Card card22 = new Card(Suit.DIAMOND, 2);
//        Card card23 = new Card(Suit.DIAMOND, 3);
//        Card card24 = new Card(Suit.DIAMOND, 4);
//        Card card25 = new Card(Suit.DIAMOND, 5);
//        Card card26 = new Card(Suit.DIAMOND, 6);
//        Card card27 = new Card(Suit.DIAMOND, 7);
//        Card card28 = new Card(Suit.DIAMOND, 8);
//        Card card29 = new Card(Suit.DIAMOND, 9);
//        Card card30 = new Card(Suit.DIAMOND, 10);
//        Card card31 = new Card(Suit.DIAMOND, 11);
//        Card card32 = new Card(Suit.DIAMOND, 12);
//        Card card33 = new Card(Suit.DIAMOND, 13);
//        Card card34 = new Card(Suit.DIAMOND, 13);
//
//
//        hand.add(card10);
//        hand.add(card11);
//        hand.add(card12);
//        hand.add(card13);
//        hand.add(card14);
//        mRoyalFlush = new HandOfCards(new ArrayList<>(hand));
//        hand.clear();
//
//        hand.add(card2);
//        hand.add(card11);
//        hand.add(card12);
//        hand.add(card13);
//        hand.add(card14);
//
//        mStraightFlush = new HandOfCards(new ArrayList<>(hand));
//        hand.clear();
//
//        hand.add(card29);
//        hand.add(card28);
//        hand.add(card27);
//        hand.add(card26);
//        hand.add(card25);
//
//        mStraightFlush = new HandOfCards(new ArrayList<>(hand));
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
//    private void testRoyalFlush(HandOfCards handToTest, Boolean isTrue) {
//        Strategy strategy = mEvaluator.evaluateHand(new Strategy(null, handToTest));
//
//        if(isTrue) {
//            assertEquals(mPayoutTable.getRoyalFlush(), strategy.getExpectedPayout(), 0);
//        } else{
//            assertNotEquals(mPayoutTable.getRoyalFlush(), 1, 0);
//        }
//
//    }
//
//    private void testStraightFlush(HandOfCards handToTest, Boolean isTrue){
//        Strategy strategy = mEvaluator.evaluateHand(new Strategy(null, handToTest));
//        assertEquals(mPayoutTable.getStraightflush(), strategy.getExpectedPayout() , 0);
//    }
//
//
//}