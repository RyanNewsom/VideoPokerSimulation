package backend;

import java.util.ArrayList;

public class HandOfCards {
	private ArrayList<Card> handOfCards = new ArrayList<>(5);
	
	public HandOfCards(ArrayList<Card> theHand){
		handOfCards = theHand;
	}

	public ArrayList<Card> getHandOfCards() {
		return handOfCards;
	}

	public Card getCard(int index) throws Exception{
		Card card = handOfCards.get(index);
		if(card == null){
			throw new Exception("You tried to get a card that is not in the hand");
		}
		return card;
	}
}
