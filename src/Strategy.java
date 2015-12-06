import java.util.ArrayList;
import java.util.Arrays;

public class Strategy {
	private double expectedPayout;
	private ArrayList cardsToHoldOnto;
	private HandOfCards handOfCards;
	private TypeOfStrategy theType;
	private boolean[] arrayCardsToHold;
	
	public Strategy(TypeOfStrategy type, HandOfCards handDealt){
		theType = type;
		handOfCards = handDealt;
	}

	public double getExpectedPayout() {
		return expectedPayout;
	}

	public void setExpectedPayout(double payout){
		expectedPayout = payout;
	}

	public ArrayList getCardsToHoldOnto(){
		return cardsToHoldOnto;
	}

	public void setCardsToHoldOnto(boolean[] holdOnto){
		arrayCardsToHold = holdOnto;
		cardsToHoldOnto = new ArrayList(Arrays.asList(holdOnto));
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

	public boolean[] getArrayCardsToHold() {
		return arrayCardsToHold;
	}
}
