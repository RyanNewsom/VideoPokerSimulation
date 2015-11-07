package backend.card;

public class Card {
	private Suit theSuit;
	private int theValue;
	
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
		this.theValue = theValue;
	}
	
	
	
	
}
