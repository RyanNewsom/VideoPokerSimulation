package backend;

import backend.card.HandOfCards;

import java.util.ArrayList;

public class Strategy {
	private int expectedPayout;
	private ArrayList cardsToHoldOnto;
	private HandOfCards handOfCards;
	private TypeOfStrategy theType;
	
	public Strategy(TypeOfStrategy type, HandOfCards handDealt){
		theType = type;
		handOfCards = handDealt;
	}

	public int getExpectedPayout() {
		return expectedPayout;
	}

	public ArrayList getCardsToHoldOnto(){
		return cardsToHoldOnto;
	}

	public void setCardsToHoldOnto(ArrayList holdOnto){
		cardsToHoldOnto = holdOnto;
	}

	public HandOfCards getHandOfCards() {
		return handOfCards;
	}

	public void setHandOfCards(HandOfCards handOfCards) {
		this.handOfCards = handOfCards;
	}

	public TypeOfStrategy getTheType() {
		return theType;
	}

	public void setTheType(TypeOfStrategy theType) {
		this.theType = theType;
	}
	
}
