package model;

/**
 * A payout table for a Jacks or Better poker game
 */
public class PayoutTable {
	private long royalFlush;
	private long straightflush;
	private long fourOfAKind;
	private long fullHouse;
	private long flush;
	private long straight;
	private long threeOfAKind;
	private long twoPair;
	private long pairOfJacksOrBetter;

	/**
	 * Creates a new jacks or better payout table
	 * @param royalFlush - the payout for a royal flush
	 * @param straightflush - the payout for a straight flush
	 * @param fourOfAKind - the payout for four of a kind
	 * @param fullHouse - the payout for a full house
	 * @param flush - the payout for a flush
	 * @param straight - the payout for a straight
	 * @param threeOfAKind - the payout for three of a kind
	 * @param twoPair - the payout for a two pair
	 * @param pairOfJacksOrBetter - the payout for a pair of cards that are jacks or better
	 */
	public PayoutTable(long royalFlush, long straightflush, long fourOfAKind, long fullHouse, long flush, long straight, long threeOfAKind, long twoPair, long pairOfJacksOrBetter) {
		this.royalFlush = royalFlush;
		this.straightflush = straightflush;
		this.fourOfAKind = fourOfAKind;
		this.fullHouse = fullHouse;
		this.flush = flush;
		this.straight = straight;
		this.threeOfAKind = threeOfAKind;
		this.twoPair = twoPair;
		this.pairOfJacksOrBetter = pairOfJacksOrBetter;
	}

	public long getRoyalFlush() {
		return royalFlush;
	}

	public long getStraightflush() {
		return straightflush;
	}

	public long getFourOfAKind() {
		return fourOfAKind;
	}

	public long getFullHouse() {
		return fullHouse;
	}

	public long getFlush() {
		return flush;
	}

	public long getStraight() {
		return straight;
	}

	public long getThreeOfAKind() {
		return threeOfAKind;
	}

	public long getTwoPair() {
		return twoPair;
	}

	public long getPairOfJacksOrBetter() {
		return pairOfJacksOrBetter;
	}
}
