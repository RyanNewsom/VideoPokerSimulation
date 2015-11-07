package backend;

public class Player {
	private Strategy myStrategy;
	private int totalExpectedPayout;
	
	public Player(){
		
	}
	
	public Strategy getBestStrategy(HandOfCards initialHand){
		askStrategyComputerForBestStrategy(initialHand);
		return myStrategy;
	}

	private void askStrategyComputerForBestStrategy(HandOfCards initialHand) {
		StrategyComputer strategyComp = new StrategyComputer();
		strategyComp.determineBestStrategy(initialHand);
	}

	public void applyBestStategy(){
		//This is a placeholder class that could be used to run a simulation
	}
}
