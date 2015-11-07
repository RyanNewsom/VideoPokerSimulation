package backend;

public class PayoutTable {
	/* Standard Pays */
	private double royalFlush;
	private double straightflush;
	private double fourOfAKindAces;
	private double fourOfAKind234;
	private double fourOfAKind5sToKings;
	private double fullHouse;
	private double flush;
	private double straight;
	private double threeOfAKind;
	private double twoPair;
	private double pairOfJacksOrBetter;
	
	/* Multiplier to apply to the payout table */
	private double multiplier = 1;

	public PayoutTable(double royalFlush, double straightflush, double fourOfAKindAces, double fourOfAKind234, double fourOfAKind5sToKings, double fullHouse, double flush, double straight, double threeOfAKind, double twoPair, double pairOfJacksOrBetter, double multiplier) {
		this.royalFlush = royalFlush;
		this.straightflush = straightflush;
		this.fourOfAKindAces = fourOfAKindAces;
		this.fourOfAKind234 = fourOfAKind234;
		this.fourOfAKind5sToKings = fourOfAKind5sToKings;
		this.fullHouse = fullHouse;
		this.flush = flush;
		this.straight = straight;
		this.threeOfAKind = threeOfAKind;
		this.twoPair = twoPair;
		this.pairOfJacksOrBetter = pairOfJacksOrBetter;
		this.multiplier = multiplier;
	}

}
