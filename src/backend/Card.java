package backend;

public class Card {
	private Suit theSuit;
	private Value theValue;
	
	public Card(Suit suit, Value value){
		setSuit(suit);
		setValue(value);
	}

	public Suit getSuit() {
		return theSuit;
	}

	public void setSuit(Suit theSuit) {
		this.theSuit = theSuit;
	}

	public Value getValue() {
		return theValue;
	}

	public void setValue(Value theValue) {
		this.theValue = theValue;
	}
	
	
	
	
}
