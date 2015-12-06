import java.util.ArrayList;

/**
 * Created by Ryan on 12/5/2015.
 */
public class VPDriver {
    PayoutTable mPayoutTable;
    public VPDriver(String payoutTable) {
        String delims = "[ ]+";
        String [] nums = payoutTable.split(delims);
        long a = Long.valueOf(nums[0]);
        long b = Long.valueOf(nums[1]);
        long c = Long.valueOf(nums[2]);
        long d = Long.valueOf(nums[3]);
        long e = Long.valueOf(nums[4]);
        long f = Long.valueOf(nums[5]);
        long g = Long.valueOf(nums[6]);
        long h = Long.valueOf(nums[7]);
        long i = Long.valueOf(nums[8]);
        mPayoutTable = new PayoutTable(a, b, c, d, e, f, g, h, i);
    }

    public double testHand(int card0, int card1, int card2, int card3, int card4) {
        ArrayList<Card> hand = new ArrayList<>();
        Card c0 = makeCard(card0);
        Card c1 = makeCard(card1);
        Card c2 = makeCard(card2);
        Card c3 = makeCard(card3);
        Card c4 = makeCard(card4);

        hand.add(c0);
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);

        HandOfCards handOfCards = new HandOfCards(hand);

        Game aGameSimulation = new Game(mPayoutTable, handOfCards);
        Double payout = aGameSimulation.determineOptimalStrategy().getExpectedPayout();
        System.out.print("The expected payout is " + payout);
        return payout;
    }

    public Card makeCard(int card){
        int val = card;
        Card card1;
        if(card >= 39){
            //Heart
            if(card == 39){
                val = 14;
            } else {
                val = val - 38;
            }
            card1 = new Card(Suit.SPADES, val);
        } else if(card >= 26){
            //Club
            if(card == 26){
                val = 14;
            } else {
                val = val - 25;
            }
            card1 = new Card(Suit.DIAMOND, val);
        } else if(card >= 13){
            //King
            if(card == 13){
                val = 14;
            } else {
                val = val - 12;
            }
            card1 = new Card(Suit.CLUBS, val);
        } else {
            //Diamonds
            if(card == 0){
                val = 14;
            }
            card1 = new Card(Suit.HEARTS, val);
        }
        return  card1;
    }
}
