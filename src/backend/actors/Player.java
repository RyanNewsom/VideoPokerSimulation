package backend.actors;

import backend.Strategy;
import backend.card.HandOfCards;
import backend.data.PayoutTable;

public class Player {
	private Strategy myStrategy;
	private int totalExpectedPayout;
	
	public Player(){
		
	}
	
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

	public void applyBestStategy(){
		//This is a placeholder class that could be used to run a simulation
	}
}
