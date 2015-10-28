package backend;

import java.util.ArrayList;

public abstract class Strategy {
	private int expectedPayout;
	private ArrayList cardsToHoldOnto;
	private HandOfCards handOfCards;
	
	private Strategy(){
		
	}
	
	private ArrayList getCardsToHoldOnto(){
		return cardsToHoldOnto;
	}
	
	private void setCardsToHoldOnto(ArrayList holdOnto){
		cardsToHoldOnto = holdOnto;
	}

	public int getExpectedPayout() {
		return expectedPayout;
	}
	
}
