package model;

public class Player {
	private Strategy myStrategy;

	/**
	 * Creates a new player to play video poker
	 */
	public Player(){ }

	/**
	 * The player will get the best strategy for a hand of poker
	 * @param initialHand - the hand the player has
	 * @param payoutTable - the payout table of the poker game
	 * @return - the best model.Strategy for the hand, which cards to hold, and the expected payout
	 */
	public Strategy getBestStrategy(HandOfCards initialHand, PayoutTable payoutTable){
		askStrategyComputerForBestStrategy(initialHand, payoutTable);
		return myStrategy;
	}

	/**
	 * The strategy computer will determine the best strategy for the player
	 * @param initialHand
	 * @param payoutTable
	 */
	private void askStrategyComputerForBestStrategy(HandOfCards initialHand, PayoutTable payoutTable) {
		StrategyComputer strategyComp = new StrategyComputer(payoutTable);
		myStrategy = strategyComp.determineBestStrategy(initialHand);
	}

}
