package model;

import model.Card;

import java.util.ArrayList;

/**
 * A hand of five individual cards
 */
public class HandOfCards {
	private ArrayList<Card> handOfCards = new ArrayList<>(5);

	/**
	 * Creates a new hand of cards
	 * @param theHand - an arraylist of cards
	 */
	public HandOfCards(ArrayList<Card> theHand){
		handOfCards = theHand;
	}

	/**
	 *
	 * @return - the hand of cards as an array list
	 */
	public ArrayList<Card> getHandOfCards() {
		return handOfCards;
	}

	/**
	 * gets the card at a specific index
	 * @param index - the index of the card you want, 0-4
	 * @return - the associated card at the specified index
	 */
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
