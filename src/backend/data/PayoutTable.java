package backend.data;

public class PayoutTable {
	/* Standard Pays */
	private long royalFlush;
	private long straightflush;
	private long fourOfAKindAces;
	private long fullHouse;
	private long flush;
	private long straight;
	private long threeOfAKind;
	private long twoPair;
	private long pairOfJacksOrBetter;

	public PayoutTable(long royalFlush, long straightflush, long fourOfAKindAces, long fullHouse, long flush, long straight, long threeOfAKind, long twoPair, long pairOfJacksOrBetter) {
		this.royalFlush = royalFlush;
		this.straightflush = straightflush;
		this.fourOfAKindAces = fourOfAKindAces;
		this.fullHouse = fullHouse;
		this.flush = flush;
		this.straight = straight;
		this.threeOfAKind = threeOfAKind;
		this.twoPair = twoPair;
		this.pairOfJacksOrBetter = pairOfJacksOrBetter;
	}
}
