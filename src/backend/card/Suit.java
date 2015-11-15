package backend.card;

public enum Suit {
	HEARTS, SPADES, CLUBS, DIAMOND;

	@Override
	public String toString() {
		if(this == HEARTS) return "heart";
		if(this == CLUBS) return "club";
		if(this == SPADES) return "spade";
		if(this == DIAMOND) return "diamond";
		else return null;
	}
}
