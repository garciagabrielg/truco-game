package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Opponent{
	
	private int opponentGamePoints;
	private int opponentRoundPoints;
	List<Cards> opponentHand = new ArrayList<>();
	public Cards opponentCarddOnTheTable = new Cards();
	
	
	public int getOpponentRoundPoints() {
		return opponentRoundPoints;
	}
	
	public List<Cards> getHand(){
		return opponentHand;
	}
	
	public Cards opponentPlayedCard() {
		return opponentCarddOnTheTable = opponentHand.remove((int) (Math.random() * opponentHand.size()));	
	}	

	public int getOpponentGamePoints() {
		return opponentGamePoints;
	}

	public Cards getOpponentCarddOnTheTable() {
		return opponentCarddOnTheTable;
	}
	
	public void receiveCard(Cards card) {
		opponentHand.add(card);
	}
	
	public void increaseOpponentGamePoints() {
		opponentGamePoints++;
	}
	public void increaseOppRoundPoints() {
		opponentRoundPoints++;
	}
	

}
