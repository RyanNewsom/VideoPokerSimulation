package model;

/**
 * A poker card
 */
public class Card implements Comparable {
	private Suit theSuit;
	private int theValue;

	/**
	 * Cretes a new poker card
	 * @param suit - the suit of the card
	 * @param value - the value of the card 2-14, 14 = ace
	 */
	public Card(Suit suit, int value){
		setSuit(suit);
		setValue(value);
	}

	public Suit getSuit() {
		return theSuit;
	}

	public void setSuit(Suit theSuit) {
		this.theSuit = theSuit;
	}

	public int getValue() {
		return theValue;
	}

	public void setValue(int theValue) {
		if(theValue == 1){
			System.out.print("no");
		}
		this.theValue = theValue;

	}


	@Override
	public int compareTo(Object o) {
		Card card = (Card) o;
		int compare = card.getValue();
		return this.getValue() - compare;
	}

	@Override
	public String toString() {
		return " model.Card Values: model.Suit: " + theSuit + " Value: " + theValue;
	}
}
