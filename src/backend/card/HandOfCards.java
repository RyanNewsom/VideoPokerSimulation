package backend.card;

import backend.card.Card;

import java.util.ArrayList;

public class HandOfCards {
	private ArrayList<Card> handOfCards = new ArrayList<>(5);
	
	public HandOfCards(ArrayList<Card> theHand){
		handOfCards = theHand;
	}

	public ArrayList<Card> getHandOfCards() {
		return handOfCards;
	}

	public Card getCard(int index){
		Card card = null;
		try {
			card = handOfCards.get(index);
		} catch (IndexOutOfBoundsException uhoh){
			uhoh.printStackTrace();
		}
		return card;
	}
}
