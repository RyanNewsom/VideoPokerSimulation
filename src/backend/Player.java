package backend;

public class Player {
	private Strategy myStrategy;
	private int totalExpectedPayout;
	
	public Player(){
		
	}
	
	public Strategy getBestStrategy(){
		return myStrategy;
	}
	
	public void applyBestStategy(){
		//This is a placeholder class that could be used to run a simulation
	}
}
