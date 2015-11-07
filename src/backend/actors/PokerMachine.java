package backend.actors;

import backend.data.PayoutTable;
import backend.card.Card;
import backend.card.Deck;
import backend.card.HandOfCards;

import java.util.ArrayList;

public class PokerMachine {

	//Objects
	private PayoutTable thePayoutTable;
	private ArrayList<HandOfCards> possibleHands = new ArrayList<>();
	private Deck deckOfCards = new Deck();

	//Data
	private int currentHandPosition;
	
	public PokerMachine(PayoutTable payoutTable){
		thePayoutTable = payoutTable;
		setUpPossibleHands();
	}

	/**
	 * deals a hand of cards
	 * @return - the next hand in the array of possible hands
	 */
	public HandOfCards dealHandOfCards(){
		return possibleHands.get(currentHandPosition);
	}

	/**
	 * A place holder class in case I ever want to allow a full poker simulation
	 * @return
	 */
	private HandOfCards dealFinalHand(){
		//deal the final hand
		return null;
	}

	public PayoutTable getPayoutTable(){
		return thePayoutTable;
	}
	
	public void setPayoutTable(PayoutTable table){
		thePayoutTable = table;
	}

	/**
	 * Add all the possible hands to the possibleHands arrayList
	 * [TODO] Add all the possibilities
	 */
	private void setUpPossibleHands(){
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
		HandOfCards handOfCards = new HandOfCards(hand);
		possibleHands.add(handOfCards);
	}
}
