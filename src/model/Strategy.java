package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A strategy for a video poker hand
 */
public class Strategy {
	private double expectedPayout;
	private ArrayList cardsToHoldOnto;
	private HandOfCards handOfCards;
	private TypeOfStrategy theType;
	private boolean[] arrayCardsToHold;

	/**
	 * Creates a new strategy
	 * @param type - the type of strategy, hold0, hold1, hold2, hold3, hold4, hold5
	 * @param handDealt - the hand dealt
	 */
	public Strategy(TypeOfStrategy type, HandOfCards handDealt){
		theType = type;
		handOfCards = handDealt;
	}

	/**
	 * Gets the expected payout for this strategy
	 * @return - the expected payout for this strategy
	 */
	public double getExpectedPayout() {
		return expectedPayout;
	}

	public void setExpectedPayout(double payout){
		expectedPayout = payout;
	}

	/**
	 * The cards that will be held
	 * @param holdOnto - cards to be held, each index is associated with the same index of card
	 *                 ex. true, true, false, false, true. Hold card 1,2,5
	 */
	public void setCardsToHoldOnto(boolean[] holdOnto){
		arrayCardsToHold = holdOnto;
		cardsToHoldOnto = new ArrayList(Arrays.asList(holdOnto));
	}

	public HandOfCards getHandOfCards() {
		return handOfCards;
	}

	public TypeOfStrategy getTheType() {
		return theType;
	}

	/**
	 * Returns the cards to hold onto
	 * @return - an array of cards to hold onto, each index is associated with the same index of cards.
	 * 			ex. ex. true, true, false, false, true. Hold card 1,2,5
	 */
	public boolean[] getArrayCardsToHold() {
		return arrayCardsToHold;
	}
}
