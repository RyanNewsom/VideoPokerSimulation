package backend;

public class PokerMachine {
	private PayoutTable thePayoutTable;
	
	public PokerMachine(PayoutTable payoutTable){
		thePayoutTable = payoutTable;
	}
	
	public void beginGame(){
		
	}
	
	public HandOfCards dealInitialHand(){
		//generate a handOfCards 
		return null;
	}
	
	public HandOfCards dealFinalHand(){
		//deal the final hand
		return null;
	}
	
	public HandOfCards dealNextHand(){
		return null;
	}
	
	public PayoutTable getPayoutTable(){
		return thePayoutTable;
	}
	
	public void setPayoutTable(PayoutTable table){
		thePayoutTable = table;
	}
}
