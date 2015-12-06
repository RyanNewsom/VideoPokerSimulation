import java.util.ArrayList;
import java.util.Collections;

/**
 * A poker machine
 */
public class PokerMachine {

	//Objects
	private PayoutTable thePayoutTable;
	private ArrayList<HandOfCards> possibleHands = new ArrayList<>();
	private Deck deckOfCards = new Deck();

	//Data
	private int currentHandPosition;

	/**
	 * Creates a new poker machine with the associated payout table
	 * @param payoutTable
	 */
	public PokerMachine(PayoutTable payoutTable){
		thePayoutTable = payoutTable;
		setUpPossibleHands();
	}

	/**
	 * deals a hand of cards
	 * @return - the next hand in the array of possible hands
	 */
	public HandOfCards dealHandOfCards(){
		return setUpPossibleHands();
	}

	/**
	 * A place holder class in case I ever want to allow a full poker simulation
	 * @return
	 */
	private HandOfCards dealFinalHand(){
		//deal the final hand
		return null;
	}

	/**
	 * Add all the possible hands to the possibleHands arrayList, that way every possible hand can be used to determine
	 * the expected payout for a poker machine. However, scope has changed so now this method just generates a random hand from
	 * the deck.
	 * [TODO] Add all the possibilities if scope changes back to, determine expected payout for a video poker machine
	 */
	private HandOfCards setUpPossibleHands(){
		Deck deck = new Deck();
		Card card1 = deck.getCard();
		Card card2 = deck.getCard();
		Card card3 = deck.getCard();
		Card card4 = deck.getCard();
		Card card5 = deck.getCard();
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		Collections.sort(hand);
		HandOfCards handOfCards = new HandOfCards(hand);
		return handOfCards;
		//		possibleHands.add(handOfCards);
	}
}
