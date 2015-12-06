public class Card implements Comparable {
	private Suit theSuit;
	private int theValue;
	
	public Card(Suit suit, int value){
		setSuit(suit);
		setValue(value);
		if(value == 1){
			System.out.print("wtf");
		}
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
		return " Card Values: S: " + theSuit + " Val: " + theValue;
	}
}
