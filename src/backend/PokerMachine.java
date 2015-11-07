package backend;

import java.util.ArrayList;

public class PokerMachine {
	private PayoutTable thePayoutTable;
	private ArrayList<HandOfCards> possibleHands = new ArrayList<>();
	Game currentGame;
	Double expectedPayout;
	
	public PokerMachine(PayoutTable payoutTable){
		thePayoutTable = payoutTable;
	}
	
	public HandOfCards dealInitialHand(){
		//generate a handOfCards 
		return null;
	}
	
	public HandOfCards dealFinalHand(){
		//deal the final hand
		return null;
	}
	
	public HandOfCards dealNextHand(){
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
